package com.dt.project.netty;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;


/**
 * @ClassName ChatService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 16:58
 **/
public interface ChatService {

    /**
     * 设置连接成功socket对象
     */
    void register(JSONObject object, ChannelHandlerContext ctx);

    /**
     * 服务端推送
     *
     * @param message
     */
    void servicePush(ChannelHandlerContext ctx, String message);

    /**
     * 删除socket对象
     *
     * @param ctx
     */
    void remove(ChannelHandlerContext ctx);

    /**
     * 获得 ChannelHandlerContext对象
     *
     * @param uId
     * @return
     */
    ChannelHandlerContext getCtx(Long uId);
}



