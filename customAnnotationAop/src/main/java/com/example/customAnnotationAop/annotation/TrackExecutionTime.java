package com.example.customAnnotationAop.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// marker annotation doesnt contain any method

// Configuration annotation contains methods
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackExecutionTime {
    long warnAfter() default 2000;
    String operation() default "";
}
