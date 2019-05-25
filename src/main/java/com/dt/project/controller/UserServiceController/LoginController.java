package com.dt.project.controller.UserServiceController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.dto.UserDto;
import com.dt.project.exception.LsException;
import com.dt.project.netty.service.ChatService;
import com.dt.project.service.UserService;
import com.dt.project.store.SsoLoginStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.*;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController extends JsonData {
    @Autowired
    private UserService userService;

    @Autowired
    private ChatService chatService;


    /**
     * 每天6点清除 redis中账号的key
     */
    @Async("executor")
    @Scheduled(cron = "0 0 6 * * ?")
    public void clearHashMap() {
        System.out.println("删除key");
        //Constant.errorPwdMap.clear();
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
        String ttlDateKey = Constants.TTL_DATE + userDto.getUserName();
        Long ttlDate = redisService.getTtl(ttlDateKey);
        //如果不等于null
        if (ttlDate != -1 && ttlDate != -2) {
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
        //删除redis token
        Boolean result = redisService.delKey(Constants.TOKEN + ":" + ReqUtils.getUid());
        //删除 cookie里的  token
        SsoLoginStore.removeTokenByCookie(request, response);
        //删除webSocket
        ChannelHandlerContext ctx = chatService.getCtx(ReqUtils.getUid());
        if (ctx != null) {
            ctx.channel().close();
        }
        if (result) {
            return JsonData.setResultSuccess("注销成功!");
        }
        throw new LsException("注销失败");
    }
}
