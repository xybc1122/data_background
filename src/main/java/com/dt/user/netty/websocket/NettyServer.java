package com.dt.user.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName NettyServer
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 10:51
 **/
@Component
public class NettyServer {
    private int port = 3333;

    // 构造方法少了会报错
    public NettyServer() {
    }


    private void startServer() {
        //服务端需要2个线程组  boss处理客户端连接  work进行客服端连接之后的处理
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            long begin = System.currentTimeMillis();
            ServerBootstrap bootstrap = new ServerBootstrap();
            //使用服务端初始化自定义类WebSocketChannelInitaializer
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new ChildChannelHandler());
            long end = System.currentTimeMillis();
            System.out.println("Netty Websocket服务器启动完成，耗时 " + (end - begin) + " ms，已绑定端口 " + port + " 阻塞式等候客户端连接");
            //绑定端口  开启事件驱动
            Channel channel = bootstrap.bind(port).sync().channel();
            channel.closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    @PostConstruct()
    public void init() {
        //需要开启一个新的线程来执行netty server 服务器
        new Thread(new Runnable() {
            public void run() {
                startServer();
            }
        }).start();
    }

}
