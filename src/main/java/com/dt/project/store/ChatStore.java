package com.dt.project.store;

import com.dt.project.config.JsonData;
import com.dt.project.netty.ChatServiceImpl;
import com.dt.project.netty.ChatType;
import com.dt.project.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName ChatStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/3 10:58
 **/
@Component
public class ChatStore extends JsonData {

    @Autowired
    private ChatServiceImpl chatService;

    /**
     * 封装踢出用户
     *
     * @param uId
     * @param msg
     */
    public void kickOut(String token, Long uId, String msg) {
        String redisToken = redisService.getStringKey(token);
        //如果在线  发送消息
        if (StringUtils.isNotBlank(redisToken)) {
            chatService.kickOutMsg(uId, JsonUtils.getJsonTypeError(msg,
                    ChatType.KICK_OUT));
            redisService.delKey(token);
        }
    }
}
