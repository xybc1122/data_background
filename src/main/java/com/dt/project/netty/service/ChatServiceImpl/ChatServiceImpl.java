package com.dt.project.netty.service.ChatServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.dt.project.netty.websocket.ChatType;
import com.dt.project.netty.service.ChatService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.JsonUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName ChatServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 16:57
 **/
@Service
public class ChatServiceImpl implements ChatService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServiceImpl.class);

    @Override
    public void register(JSONObject object, ChannelHandlerContext ctx) {
        Integer uId = (Integer) object.get("uId");
        Constants.onLineUserMap.put(uId.longValue(), ctx);
        System.out.println("绑定用户" + uId + "----" + ctx.channel());
        sendMessage(ctx, JsonUtils.getJsonTypeSuccess("连接成功 绑定用户" + uId + "----" + ctx.channel(), ChatType.REGISTER));
        LOGGER.info(MessageFormat.format("userId为 {0} 的用户登记到在线用户表，当前在线人数为：{1}"
                , uId, Constants.onLineUserMap.size()));
    }

    @Override
    public void servicePush(ChannelHandlerContext ctx, String message) {
        sendMessage(ctx, message);
    }

    @Override
    public void remove(ChannelHandlerContext ctx) {
        Iterator<Map.Entry<Long, ChannelHandlerContext>> iterator =
                Constants.onLineUserMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, ChannelHandlerContext> entry = iterator.next();
            if (entry.getValue() == ctx) {
                LOGGER.info("正在移除握手实例...");
                Constants.webSocketHandShakerMap.remove(ctx.channel().id().asLongText());
                LOGGER.info(MessageFormat.format("已移除握手实例，当前握手实例总数为：{0}"
                        , Constants.webSocketHandShakerMap.size()));
                iterator.remove();
                LOGGER.info(MessageFormat.format("userId为 {0} 的用户已退出聊天，当前在线人数为：{1}"
                        , entry.getKey(), Constants.onLineUserMap.size()));
                break;
            }
        }
    }

    @Override
    public ChannelHandlerContext getCtx(Long uId) {
        if (Constants.onLineUserMap.get(uId) != null) {
            return Constants.onLineUserMap.get(uId);
        }
        return null;
    }

    /**
     * 上传进度推送
     *
     * @param ctx          webSocket对象
     * @param intMap       判断Map
     * @param currentCount 总数
     */
    public void schedule(ChannelHandlerContext ctx,
                         Map<String, Integer> intMap, int currentCount,
                         String msg) {
        //如果是第一次
        if (intMap.size() == 0) {
            intMap.put("current", currentCount);
            servicePush(ctx, msg);
        }
        //如果值不一样 发送webSocket给前端
        else if (intMap.get("current") != currentCount) {
            servicePush(ctx, msg);
            intMap.put("current", currentCount);
        }
    }

    /**
     * 发送消息
     *
     * @param ctx
     * @param message
     */
    public void sendMessage(ChannelHandlerContext ctx, String message) {
        if (ctx != null) {
            ctx.channel().writeAndFlush(new TextWebSocketFrame(message));
        }
    }

    /**
     * 封装已登陆 踢出 msg
     */
    public void kickOutMsg(Long uId, String msg) {
        ChannelHandlerContext ctx = getCtx(uId);
        if (ctx != null) {
            sendMessage(ctx, msg);
            remove(ctx);
        }
    }


}
