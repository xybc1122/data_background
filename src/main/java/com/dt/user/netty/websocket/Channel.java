package com.dt.user.netty.websocket;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @ClassName Channel
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/1 13:24
 **/
public class Channel {
    /**
     * webSocket
     * 用户全局对象
     */
    public static ChannelGroup clients =
            new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
