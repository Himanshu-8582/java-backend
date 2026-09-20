package com.example.AOP.service;

import com.example.AOP.entity.Student;
import com.example.AOP.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student){
//        LoggingServiceUtil.logStart("StudentService","createStudent");
        try {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        studentRepository.save(student);
//        LoggingServiceUtil.logEnd("StudentService","createStudent");
    }
}
