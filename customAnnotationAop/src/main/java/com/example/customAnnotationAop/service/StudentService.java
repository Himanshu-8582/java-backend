package com.example.customAnnotationAop.service;

import com.example.customAnnotationAop.annotation.TrackExecutionTime;
import com.example.customAnnotationAop.dto.Student;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @TrackExecutionTime(
            warnAfter = 2000,
            operation = "Creating New Student"
    )

//    @TrackExecutionTime
    public Student createStudent(Student student) {
        System.out.println("Student saved");
        return student;
    }

    @TrackExecutionTime(
            warnAfter = 1500,
            operation = "Get Student Data"
    )
//    @TrackExecutionTime
    public String getStudent(String s) {
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}

        System.out.println(s);
        return s;
    }

    public int dummyMethod() {
        return 0;
    }
}