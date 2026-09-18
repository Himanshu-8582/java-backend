package com.example.interceptors.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler){

//        if(handler instanceof HandlerMethod handlerMethod){
//            String controllerName=handlerMethod.getBeanType().getName();
//            String methodName=handlerMethod.getMethod().getName();
//
//            System.out.println("PreHandle called");
//            System.out.println("Controller name "+controllerName);
//            System.out.println("Controller method "+methodName );
//        }
//        return true;

        System.out.println("Incoming request ---------");

        System.out.println("HTTP Method: "+request.getMethod());
        System.out.println("Request URI: "+request.getRequestURI());
        System.out.println("Request parameter: "+request.getQueryString());
        System.out.println("Client IP: "+request.getRemoteAddr());
        System.out.println("Token Header: "+request.getHeader("token"));
        if(handler instanceof HandlerMethod handlerMethod){
            System.out.println("Controller name "+handlerMethod.getBeanType().getName());
            System.out.println("Controller method "+handlerMethod.getMethod().getName());
        }

        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response,
//                           Object handler, ModelAndView modelAndView){
//        System.out.println("Post handle called");
//    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex)throws Exception{
        System.out.println("Response Status: "+response.getStatus());
    }
}
