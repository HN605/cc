package com.example.demo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化中。。。");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("\ndoFilter()开始执行：发往" + ((HttpServletRequest)request).getRequestURL().toString() + "的请求已被拦截");

        System.out.println("检验接口是否被调用，尝试获取contentType如下：" + response.getContentType());

        chain.doFilter(request, response);

        System.out.println("检验接口是否被调用，尝试获取contentType如下：" + response.getContentType());

        System.out.println("doFilter()执行结束。\n");

    }

    @Override
    public void destroy() {
        System.out.println("filter销毁中。。。");
    }
}
