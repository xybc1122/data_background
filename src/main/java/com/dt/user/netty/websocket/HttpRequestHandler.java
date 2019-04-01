package com.dt.user.netty.websocket;

import com.alibaba.fastjson.JSONObject;
import com.dt.user.config.ApplicationContextRegister;
import com.dt.user.netty.ChatService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

/**
 * @ClassName TextWebSocketFrameHandler
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 16:43
 **/
@Component
public class HttpRequestHandler extends SimpleChannelInboundHandler<Object> {


    private ChatService chatService = ApplicationContextRegister.getBean(ChatService.class);


    private WebSocketServerHandshaker handShaker;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
        //传统的http接入
        if (o instanceof FullHttpRequest) {
            handleHttpRequest(ctx, (FullHttpRequest) o);
        }
        //webSocket接入
        else if (o instanceof WebSocketFrame) {
            handleWebSocketFrame(ctx, (WebSocketFrame) o);
        }
    }

    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
        //判断是否是链路关闭消息
        if (frame instanceof CloseWebSocketFrame) {
            handShaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        //判断是否是ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().writeAndFlush(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        //文本消息处理
        String data = ((TextWebSocketFrame) frame).text();
        System.out.println("接受的信息是：" + data);
        JSONObject param = JSONObject.parseObject(data);
        String type = (String) param.get("type");
        switch (type) {
            case "REGISTER":
                chatService.register(param, ctx);
                break;
        }
    }


    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
        //构造握手响应返回
        WebSocketServerHandshakerFactory webSocketServerHandshakerFactory = new WebSocketServerHandshakerFactory("ws://localhost:20000/web", null, false);
        handShaker = webSocketServerHandshakerFactory.newHandshaker(req);
        handShaker.handshake(ctx.channel(), req);

    }

    /**
     * 添加用户
     *
     * @param ctx
     * @throws Exception
     */

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("添加用户" + ctx.channel());
        Channel.clients.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("移除用户" + ctx.channel());
        chatService.remove(ctx);
        //ChannelGroup会自动移除
        //clients.remove(ctx.channel());
    }


    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.channel().close();
        Channel.clients.remove(ctx.channel());
    }

    private void sendErrorMessage(ChannelHandlerContext ctx, String errorMsg) {
        ctx.channel().writeAndFlush(new TextWebSocketFrame("error"));
    }


}
