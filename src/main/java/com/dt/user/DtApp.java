package com.dt.user;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//配置druid必须加的注解，如果不加，访问页面打不开，
// filter和servlet、listener之类的需要单独进行注册才能使用，spring boot里面提供了该注解起到注册作用
@ServletComponentScan
@EnableTransactionManagement
// 开启异步调用功能 线程池
@EnableAsync
@EnableScheduling
//@EnableFeignClients
@MapperScan("com.dt.user.mapper")
public class DtApp {

    public static void main(String[] args) {
        SpringApplication.run(DtApp.class, args);
    }
}
