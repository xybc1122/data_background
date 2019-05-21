package com.dt.project.filter;

import javax.servlet.*;

/**
 * @ClassName MyFilter
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/29 13:58
 * 这里没用上
 **/
public class MyFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain){
        System.out.println("Filter过滤");
    }
}
