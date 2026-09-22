package com.example.AOPpointCuttings.service;

import com.example.AOPpointCuttings.dto.Student;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

//    @Timestamp
    public Student createStudent(Student student) {
        System.out.println("Student saved");
//        throw new RuntimeException("Some error happened");
        return student;
    }

    public String getStudent(String s){;
        System.out.println(s);
        return s;
    }
}
