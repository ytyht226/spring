package com.jd58.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by yht on 2018/12/11.
 */
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("UserFilter...doFilter...");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}