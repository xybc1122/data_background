package com.dt.user.controller.UserServiceController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.UserDto;
import com.dt.user.exception.LsException;
import com.dt.user.netty.ChatService;
import com.dt.user.service.UserService;
import com.dt.user.store.ChatStore;
import com.dt.user.store.SsoLoginStore;
import com.dt.user.toos.Constant;
import com.dt.user.toos.Constants;
import com.dt.user.utils.*;
import io.netty.channel.ChannelHandlerContext;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController extends JsonData {
    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;


    /**
     * 每天6点清除 hashMap中的元素
     */
    @Async("executor")
    @Scheduled(cron = "0 0 6 * * ?")
    public void clearHashMap() {
        System.out.println("删除元素");
        Constant.errorPwdMap.clear();
    }

    /**
     * 获得在线用户总数
     *
     * @return
     */
    @GetMapping("/uCount")
    public ResponseBase userCount() {
        return JsonData.setResultSuccess(redisService.userCount());
    }

    /**
     * 登陆
     *
     * @param userDto
     * @return
     */
    @PostMapping("/ajaxLogin")
    public ResponseBase login(HttpServletResponse response, @RequestBody UserDto userDto) {
        String userKey = userDto.getUserName() + "error";
        String strRedis = redisService.getStringKey(userKey);
        //如果不等于null
        if (StringUtils.isNotEmpty(strRedis)) {
            Long ttlDate = redisService.getTtl(userKey);
            return JsonData.setResultError("账号/或密码错误被锁定/" + ttlDate + "秒后到期!");
        }
        return userService.doGetAuthenticationInfo(response, userDto);
    }


    /**
     * 退出
     *
     * @return
     */
    @GetMapping("/logout")
    public ResponseBase logout(HttpServletRequest request, HttpServletResponse response) {
        String uName = ReqUtils.getUserName();
        Long uId = ReqUtils.getUid();
        if (uName == null || uId == null) {
            throw new LsException("注销失败");
        }
        //删除redis token
        int result = redisService.delKey(uName + Constants.TOKEN);
        //删除 cookie里的  token
        SsoLoginStore.removeTokenByCookie(request, response);
        //删除webSocket
        ChannelHandlerContext ctx = chatService.getCtx(uId);
        if (ctx != null) {
            ctx.channel().close();
        }
        if (result == 1) {
            return JsonData.setResultSuccess("注销成功!");
        }
        throw new LsException("注销失败");
    }
}
