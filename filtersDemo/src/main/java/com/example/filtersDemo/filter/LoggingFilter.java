package com.example.filtersDemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterchain) throws IOException, ServletException {
//        System.out.println("Request entered in logging filter");
//
//        filterchain.doFilter(servletRequest,servletResponse);
//
//        System.out.println("Request exiting in logging filter");

        long startTime=System.currentTimeMillis();

        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse) servletResponse;

        String reqId= UUID.randomUUID().toString();

        httpServletResponse.setHeader("X-Request-Id",reqId);

        // req Log
        System.out.println("Incoming Request : "+httpServletRequest.getMethod() + httpServletRequest.getRequestURI());

        filterchain.doFilter(servletRequest,servletResponse);

        long duration=System.currentTimeMillis()-startTime;

        // res log
        System.out.println("Response status : "+httpServletResponse.getStatus());

        System.out.println("API response time : "+duration);
    }
}
