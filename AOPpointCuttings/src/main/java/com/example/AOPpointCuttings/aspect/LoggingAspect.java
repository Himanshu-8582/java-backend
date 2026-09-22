package com.example.AOPpointCuttings.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    @Before("execution(public String com.example.AOPpointCuttings.service.StudentService.getStudent(String))")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }
//
//    @Before("execution(com.example.AOPpointCuttings.dto.Student com.example.AOPpointCuttings.service.StudentService.createStudent(com.example.AOPpointCuttings.dto.Student))")
//    public void logBeforeMethod2(){
//        System.out.println("Method Intercepted 2");
//    }



    // Wildcard :- Works for both above
//    @Before("execution(* com.example.AOPpointCuttings.service.StudentService.*(..))")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }



    // Within :- for all methods inside a class
//    @Before("within(com.example.AOPpointCuttings.service.StudentService)")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }



    // Annotation
//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }



    // Bean
    @Before("bean(studentService) || bean(studentController)")
    public void logBeforeMethod(){
        System.out.println("Method Intercepted");
    }
}
