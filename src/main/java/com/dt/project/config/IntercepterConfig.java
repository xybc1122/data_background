package com.dt.project.config;

import com.dt.project.interceoter.LoginInterCenter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器配置
 */
@Configuration
public class IntercepterConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterCenter()).addPathPatterns("/**").excludePathPatterns("/api/v1/login/uCount", "/api/v1/login/ajaxLogin","/api/v1/fee/startFee","/druid/*");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
