package com.example.filtersDemo.service;

import com.example.filtersDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent(Student student){
        System.out.println("Student is created");
        System.out.println(student.getName());
        System.out.println(student.getId());
        System.out.println(student.getEmail());
        try{
            Thread.sleep(3000);
        }catch (Exception e) {
        }
    }
}
