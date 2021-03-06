package com.dt.project.netty.websocket;

import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.netty.service.ChatService;
import com.dt.project.toos.Constants;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName TextWebSocketFrameHandler
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 16:43
 **/
@Component
public class MyHttpRequestHandler extends SimpleChannelInboundHandler<Object> {


    //这里会有点问题 上传到Linux上启动会报 NULL 注入失败  @Autowired注入的话 chatService是NULL
    @Autowired
    private ChatService chatService;

    private static MyHttpRequestHandler myHttpRequestHandler;

    //通过@PostConstruct实现初始化bean之前进行的操作
    @PostConstruct
    public void init() {
        myHttpRequestHandler = this;
        myHttpRequestHandler.chatService = this.chatService;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) {
        //传统的http接入
        if (o instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) o);
        }
        //webSocket接入
        else if (o instanceof WebSocketFrame) {
            handlerWebSocketFrame(ctx, (WebSocketFrame) o);
        }
    }

    /**
     * 描述：处理Http请求，要是完成HTTP协议到WebSocket协议的升主级
     *
     * @param ctx
     * @param req
     */
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        if (!req.decoderResult().isSuccess()) {
            sendHttpResponse(ctx, req,
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(
                "ws:/" + ctx.channel() + "/ws", null, false);
        WebSocketServerHandshaker handShaker = wsFactory.newHandshaker(req);
        Constants.webSocketHandShakerMap.put(ctx.channel().id().asLongText(), handShaker);
        if (handShaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            handShaker.handshake(ctx.channel(), req);
        }

    }

    /**
     * 描述：处理WebSocketFrame
     *
     * @param ctx
     * @param frame
     * @throws Exception
     */
    private void handlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        //判断是否是链路关闭消息
        if (frame instanceof CloseWebSocketFrame) {
            WebSocketServerHandshaker handShaker =
                    Constants.webSocketHandShakerMap.get(ctx.channel().id().asLongText());
            if (handShaker == null) {
                sendErrorMessage(ctx, "不存在的客户端连接！");
            } else {
                handShaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            }
            return;
        }
        //判断是否是ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 本例程仅支持文本消息，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            sendErrorMessage(ctx, "仅支持文本(Text)格式，不支持二进制消息！");
            return;
        }
        //文本消息处理
        String data = ((TextWebSocketFrame) frame).text();
        System.out.println("接受的信息是：" + data);
        JSONObject param = JSONObject.parseObject(data);
        if (param == null) {
            sendErrorMessage(ctx, "参数为空！");
            return;
        }
        String type = (String) param.get("type");
        //webSocket接收的频道
        switch (type) {
            case "REGISTER":
                myHttpRequestHandler.chatService.register(param, ctx);
                break;
        }
    }

    private void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, DefaultFullHttpResponse res) {
        // 返回应答给客户端
        if (res.status().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        // 如果是非Keep-Alive，关闭连接
        boolean keepAlive = HttpUtil.isKeepAlive(req);
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!keepAlive) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * 描述：异常处理，关闭channel
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.channel().close();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("移除用户" + ctx.channel());
        myHttpRequestHandler.chatService.remove(ctx);
    }


    private void sendErrorMessage(ChannelHandlerContext ctx, String errorMsg) {
        ctx.channel().writeAndFlush(new TextWebSocketFrame(JSONObject.toJSONString(JsonData.setResultError(errorMsg))));
    }


}
