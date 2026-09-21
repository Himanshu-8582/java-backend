package com.example.AOP2nd.aspect;

import com.example.AOP2nd.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Aspect

public class LoggingAspect {
//    @Before("execution(String com.example.AOP2nd.service.StudentService.createStudent())")
//    public void logBefore(){
//        System.out.println("Student is going to be saved");
//    }


//    @AfterReturning(value = "execution(* com.example.AOP2nd.service.StudentService.createStudent(..))",returning = "result")
//    public void logAfterReturningMethod(Student result){
//        System.out.println("Target method returned : "+result );
//        result.setName("Himanshu");
//        result.setAge(21);
//        System.out.println("Intercepted createStudent()");
//    }

//    @AfterThrowing(value = "execution(* com.example.AOP2nd.service.StudentService.createStudent(..))",throwing ="exception")
//    public void logAfterThrowingMethod(Throwable exception){
//        System.out.println("An exception Type : "+exception.getClass().getName());
//        System.out.println("Exception message : "+exception.getMessage());
//    }

//    @After(value = "execution(* com.example.AOP2nd.service.StudentService.createStudent(..))")
//    public void logAfterMethod(){
//        System.out.println("log after method executed");
//
//    }

//    @Around(value = "execution(* com.example.AOP2nd.service.StudentService.createStudent(..))")
//    public Student logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Before target method.");
//        Student student = (Student) joinPoint.proceed();
//        System.out.println("After target method");
//        student.setName("Rohit");
//        student.setAge(31);
//        return student;
//    }

//    @Around(value = "execution(* com.example.AOP2nd.service.StudentService.createStudent(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting : "+joinPoint.getSignature().getName());
//        try {
//            Object result=joinPoint.proceed();
//            System.out.println("Execution successful");
//            return result;
//        }catch (Exception e){
//            System.out.println("Execution Failed: "+e.getMessage());
//            throw e;
//        }finally {
//            System.out.println("Execution completed");
//        }
//    }

    @Around(value = "execution(* com.example.AOP2nd.service.StudentService.dummyMethod(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] arr=joinPoint.getArgs();
        String originalString =(String) arr[0];
        String modifiedString =originalString.toUpperCase();
        Object[] modifiedArr={modifiedString};
        String returnType =  (String) joinPoint.proceed(modifiedArr);
        returnType+=" : String intercepted";
        return returnType;
    }
}
