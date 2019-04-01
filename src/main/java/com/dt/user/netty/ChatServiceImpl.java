package com.dt.user.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dt.user.model.RealTimeData;
import com.dt.user.toos.Constant;
import com.dt.user.utils.CrrUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        Constant.onLineUserMap.put(uId.longValue(), ctx);
        String responseJson = new ResponseJson().success()
                .setData("type", ChatType.REGISTER)
                .toString();
        sendMessage(ctx, responseJson);
        LOGGER.info(MessageFormat.format("userId为 {0} 的用户登记到在线用户表，当前在线人数为：{1}"
                , uId, Constant.onLineUserMap.size()));
    }

    @Override
    public void servicePush(ChannelHandlerContext ctx, String message) {
        sendMessage(ctx, message);
    }

    @Override
    public void remove(ChannelHandlerContext ctx) {
        Iterator<Map.Entry<Long, ChannelHandlerContext>> iterator =
                Constant.onLineUserMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, ChannelHandlerContext> entry = iterator.next();
            if (entry.getValue() == ctx) {
                iterator.remove();
                LOGGER.info(MessageFormat.format("userId为 {0} 的用户已退出聊天，当前在线人数为：{1}"
                        , entry.getKey(), Constant.onLineUserMap.size()));
                break;
            }
        }
    }

    @Override
    public ChannelHandlerContext getCtx(Long uId) {
        if (Constant.onLineUserMap.get(uId) != null) {
            return Constant.onLineUserMap.get(uId);
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
        if (intMap.size() == 0) {
            intMap.put("current", currentCount);
        }
        //如果值不一样 发送webSocket给前端
        if (intMap.get("current") != currentCount) {
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
    private void sendMessage(ChannelHandlerContext ctx, String message) {
        ctx.channel().writeAndFlush(new TextWebSocketFrame(message));
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
