package com.dt.user.config;

import com.dt.user.interceoter.LoginInterCenter;
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
        registry.addInterceptor(new LoginInterCenter()).addPathPatterns("/**").excludePathPatterns("/login/uCount", "/login/ajaxLogin", "/druid/*");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
