package com.dt.project.ssologin;

import com.dt.project.exception.LsException;
import com.dt.project.model.UserInfo;

import java.util.Date;

/**
 * @ClassName SsoWebLoginHelper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/18 9:03
 **/
public class SsoWebLoginHelper {


    /**
     * client ssologin
     */
    public static void login(UserInfo user, String pwd) {
        if (!user.getPwd().equals(pwd)) {
            throw new LsException("密码错误");
        }
        user.setPwd(null);
        user.setLandingTime(new Date().getTime());
    }
}