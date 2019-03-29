package com.dt.user.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/29 13:58
 **/
public class MyFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter过滤");
    }
}
