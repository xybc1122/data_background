package com.dt.project.netty.websocket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @ClassName HeartBeatHandler
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 16:23
 **/
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent stateEvent = (IdleStateEvent) evt;
            switch (stateEvent.state()) {
                //读空闲（服务器端）
                case READER_IDLE:
                    System.out.println("【" + ctx.channel().remoteAddress() + "】读空闲（服务器端）");
                    break;
                //写空闲（客户端）
                case WRITER_IDLE:
                    System.out.println("【" + ctx.channel().remoteAddress() + "】写空闲（客户端）");
                    break;
                case ALL_IDLE:
                    System.out.println("【" + ctx.channel().remoteAddress() + "】读写空闲");
                    ctx.channel().close();
                    break;
            }
        }
    }

}
