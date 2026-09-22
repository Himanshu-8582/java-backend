package com.example.AOPpointCuttings.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(com.example.AOPpointCuttings.controller..*)")
    public void controllerLayer(){
        //empty body
    }

    @Pointcut("within(com.example.AOPpointCuttings.service..*)")
    public void serviceLayer(){
        //empty body
    }

    @Pointcut("serviceLayer() && controllerLayer()")
    public void publicServiceMethod(){
        //empty body
    }
}
