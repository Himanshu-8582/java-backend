package com.example.AOP.service;

import com.example.AOP.entity.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class LoggingDecorator implements StudentService{
    private StudentServiceImpl studentServiceImpl;

    public LoggingDecorator(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public void createStudent(Student student) {
       LoggingServiceUtil.logStart("StudentServiceImpl","Create student");
       studentServiceImpl.createStudent(student);
       LoggingServiceUtil.logEnd("StudentServiceImple","createStudent");
    }
}
