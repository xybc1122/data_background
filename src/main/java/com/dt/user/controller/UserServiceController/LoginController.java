package com.dt.user.controller.UserServiceController;

import com.alibaba.fastjson.JSONObject;
import com.dt.user.config.JsonData;
import com.dt.user.config.BaseRedisService;
import com.dt.user.config.ResponseBase;
import com.dt.user.config.WebSocketServer;
import com.dt.user.dto.UserDto;
import com.dt.user.exception.LsException;
import com.dt.user.login.SsoWebLoginHelper;
import com.dt.user.model.UserInfo;
import com.dt.user.service.UserService;
import com.dt.user.store.SsoLoginStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.CookieUtil;
import com.dt.user.utils.JwtUtils;
import com.dt.user.utils.MD5Util;
import com.dt.user.utils.RequestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/login")
public class LoginController extends JsonData {
    @Autowired
    private WebSocketServer socketServer;
    @Autowired
    private UserService userService;

    @Autowired
    private BaseRedisService redisService;
    //并发 hashMap
    private ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();


    /**
     * 每天6点清除 hashMap中的元素
     */
    @Async("executor")
    @Scheduled(cron = "0 0 6 * * ?")
    public void clearHashMap() {
        System.out.println("删除元素");
        hashMap.clear();
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
    @Transactional
    public ResponseBase login(HttpServletResponse response, @RequestBody UserDto userDto) {
        String userKey = userDto.getUserName() + "error";
        String strRedis = baseRedisService.getStringKey(userKey);
        //如果不等于null
        if (StringUtils.isNotEmpty(strRedis)) {
            Long ttlDate = baseRedisService.getTtl(userKey);
            return JsonData.setResultError("账号/或密码错误被锁定/" + ttlDate + "秒后到期!");
        }
        //查询用户信息
        UserInfo user = userService.findByUser(userDto.getUserName());
        try {
            // 账号不存在 异常
            if (user == null) {
                return JsonData.setResultError("未知账户/没找到帐号,登录失败");
            }
            if (user.getAccountStatus() == 1) {
                return JsonData.setResultError("账号已被锁定,请联系管理员");
            }
            if (user.getDelUser() == 1) {
                return JsonData.setResultError("账号凭着已过期/或删除 请联系管理员");
            }
            //更新登陆时间
            userService.upUserLandingTime(user);
            String pwd = MD5Util.MD5(userDto.getPwd());
            // 登陆校验
            SsoWebLoginHelper.login(user, pwd);
            //设置token  Cookie
            JSONObject uJson = put(response, user, userDto.isRememberMe());

            String redisToken = baseRedisService.getStringKey(userDto.getUserName() + "token");
            //如果在线  发送消息
            if (StringUtils.isNotBlank(redisToken)) {
                socketServer.sendInfo("你已被踢下线", user.getUid());
            }
            //登陆成功后 删除Map指定元素
            if (hashMap.get(user.getUserName()) != null) {
                hashMap.entrySet().removeIf(entry -> entry.getKey().equals(user.getUserName()));
            }
            return JsonData.setResultSuccess(uJson);
        } catch (Exception e) {
            return setLockingTime(userDto);
        }
    }

    public JSONObject put(HttpServletResponse response, UserInfo user, boolean ifRemember) {
        long time;
        if (ifRemember) {
            time = 60 * 60 * 24 * 7L;
        } else {
            time = 30 * 60L;
        }
        //设置 JwtToken
        String userToken = JwtUtils.genJsonWebToken(user);
        JSONObject uJson = new JSONObject();
        uJson.put("user", user);
        uJson.put("token", userToken);
        //设置token
        baseRedisService.setString(user.getUserName() + Constants.TOKEN, userToken, time);
        //设置Cookie
        CookieUtil.set(response, Constants.TOKEN, userToken, ifRemember);
        return uJson;
    }


    public ResponseBase setLockingTime(UserDto userDto) {
        int errorNumber = 0;
        errorNumber++;
        Long lockingTime = null;
        //报错后 先进来看看 这个账号有没有在hashMap里 ---如果里面有 进去
        if (hashMap.get(userDto.getUserName()) != null) {
            hashMap.put(userDto.getUserName(), errorNumber + hashMap.get(userDto.getUserName()));
        } else {
            hashMap.put(userDto.getUserName(), errorNumber);
        }
        if (hashMap.get(userDto.getUserName()) >= 4) {
            switch (hashMap.get(userDto.getUserName())) {
                case 4:
                    lockingTime = 6L * 5;
                    break;
                case 5:
                    lockingTime = 60L * 5;
                    break;
                case 6:
                    lockingTime = 60L * 15;
                    break;
                case 7:
                    lockingTime = 60L * 60 * 24;
                    break;
            }
            redisService.setString(userDto.getUserName() + "error", "error", lockingTime);
            return JsonData.setResultError("账号被锁定!" + lockingTime + "秒");
        }
        return JsonData.setResultError("账号或密码错误/你还有" + (4 - hashMap.get(userDto.getUserName()) + "次机会"));
    }

    /**
     * 退出
     *
     * @return
     */
    @GetMapping("/logout")
    public ResponseBase logout() {
        String uName = RequestUtils.getUserName();
        if (uName == null) {
            throw new LsException("注销失败");
        }
        int result = redisService.delKey(uName + Constants.TOKEN);
        if (result == 1) {
            return JsonData.setResultSuccess("注销成功!");
        }
        throw new LsException("注销失败");
    }
}
