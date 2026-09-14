package org.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.example.config.WebConfig;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        String contextPath="";
        String baseDoc=new File("MVCdemo/src/main/webapp").getAbsolutePath();

        Context context=tomcat.addContext(contextPath,baseDoc);

        // IOC container app
        AnnotationConfigWebApplicationContext springContext=new AnnotationConfigWebApplicationContext();

        springContext.register(WebConfig.class);

        DispatcherServlet dispatcherServlet=new DispatcherServlet(springContext);

        Tomcat.addServlet(context,"dispatcherServlet",dispatcherServlet);

        context.addServletMappingDecoded("/","dispatcherServlet");

        tomcat.start();

        System.out.println("Tomcat is started on port 8080");

        tomcat.getServer().await();
    }
}