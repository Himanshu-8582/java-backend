package com.example.AOP.repository;


import com.example.AOP.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public void save(Student student){
        System.out.println("Student saved");
    }
}
