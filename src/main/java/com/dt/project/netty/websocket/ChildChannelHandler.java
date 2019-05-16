package com.dt.project.netty.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ChildChannelHandler
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 10:52
 **/
@Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel e) throws Exception {
        ChannelPipeline pipeline = e.pipeline();
        // HttpServerCodec：将请求和应答消息解码为HTTP消息
        pipeline.addLast("http-codec", new HttpServerCodec());
        /**
         * 作用是将一个Http的消息组装成一个完成的HttpRequest或者HttpResponse，那么具体的是什么
         * 取决于是请求还是响应, 该Handler必须放在HttpServerCodec后的后面
         */
        pipeline.addLast("aggregator", new HttpObjectAggregator(1024 * 64));
        //对写大数据流的支持
        pipeline.addLast("http-chunked", new ChunkedWriteHandler());
        //===================增加心跳===================
        /**
         * 如果是读写空闲  不处理
         * readerIdleTime读空闲超时时间设定
         * writerIdleTime写空闲超时时间设定
         * allIdleTime所有类型的空闲超时时间设定，包括读空闲和写空闲；
         */
        pipeline.addLast(new IdleStateHandler(60, 30, 60 * 30, TimeUnit.SECONDS));
        //自定义空闲状态检测
        pipeline.addLast(new HeartBeatHandler());
        /**
         * websocket 服务器处理的协议 ，用于指定给客户端连接访问的路由 :/ws
         * 本handler 会帮你处理一些繁重的复杂的事
         * 会帮你处理握手动作 ：handshaking （close，ping，pong）ping+pong=心跳
         * 对于websocket来讲， 都是以frams进行传输的不同的数据类型对应的frames也不同
         * */
//        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //自定义的处理器
        pipeline.addLast(new HttpRequestHandler());
    }


}

