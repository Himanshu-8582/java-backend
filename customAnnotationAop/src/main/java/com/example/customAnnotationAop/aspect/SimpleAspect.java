package com.example.customAnnotationAop.aspect;

import com.example.customAnnotationAop.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

//    @Around("@annotation(com.example.customAnnotationAop.annotation.TrackExecutionTime)")
//    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
//        long startTime=System.currentTimeMillis();
//        try{
//            return proceedingJoinPoint.proceed();
//        }finally {
//            long endTime=System.currentTimeMillis()-startTime;
//            String methodName=proceedingJoinPoint.getSignature().getName();
//            System.out.println("Time taken by "+methodName+" : "+endTime);
//        }
//    }

    // Second way :-
    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint proceedingJoinPoint, TrackExecutionTime trackExecutionTime)throws Throwable{
        long startTime=System.currentTimeMillis();
        try{
            return proceedingJoinPoint.proceed();
        }finally {
            long endTime=System.currentTimeMillis()-startTime;

            String operation=trackExecutionTime.operation();

            if(operation.isBlank()){
                operation=proceedingJoinPoint.getSignature().getName();
            }

            long warningThresHold=trackExecutionTime.warnAfter();

            String methodName=proceedingJoinPoint.getSignature().getName();

            if(endTime>=warningThresHold){
                System.out.println("SLOW OPERATION ALERT"+" Time taken by "+methodName+" : "+endTime);
            }
            else System.out.println("Time taken by "+methodName+" : "+endTime);
        }
    }
}
