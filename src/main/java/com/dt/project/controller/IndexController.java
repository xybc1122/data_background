package com.dt.project.controller;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
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
public class IndexController {


    @GetMapping("/status")
    public ResponseBase loginStatus() {
        return JsonData.setResultSuccess("已登陆");
    }

}
