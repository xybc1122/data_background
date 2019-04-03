package com.dt.user.toos;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述: 全局常量
 * 1. USER_TOKEN 用户认证的键，用来匹配http session中的对应userId；
 * 2. webSocketServerHandShaker表，用channelId为键，存放握手实例。用来响应CloseWebSocketFrame的请求；
 * 3. onlineUser表，用userId为键，存放在线的客户端连接上下文；
 * 4. groupInfo表，用groupId为键，存放群信息；
 * 5. userInfo表，用username为键，存放用户信息。
 *
 * @author Kanarien
 * @version 1.0
 * @date 2018年5月18日 下午9:17:35
 */
public class Constant {
    /**
     * 保存webSocket连接对象 用户绑定
     */
    public static Map<Long, ChannelHandlerContext> onLineUserMap =
            new ConcurrentHashMap<Long, ChannelHandlerContext>();

    /**
     * 保存webSocket 握手对象
     */
    public static Map<String, WebSocketServerHandshaker> webSocketHandShakerMap =
            new ConcurrentHashMap<String, WebSocketServerHandshaker>();

    /**
     * 记录用户密码输错次数
     */
    public static ConcurrentHashMap<String, Integer> errorPwdMap = new ConcurrentHashMap<>();

}
