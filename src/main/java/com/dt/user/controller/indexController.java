package com.dt.user.controller;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName indexController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/2 12:44
 **/
@RestController
@RequestMapping("/api/v1/index")
public class indexController {


    @GetMapping("/status")
    public ResponseBase loginStatus() {
        return JsonData.setResultSuccess("已登陆");
    }

}
