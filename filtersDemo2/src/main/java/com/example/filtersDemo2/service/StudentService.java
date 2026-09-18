package com.example.filtersDemo2.service;

import com.example.filtersDemo2.dto.Student;
import com.example.filtersDemo2.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponseDto createStudent(Student student){
        System.out.println("Student is created");
        System.out.println(student.getName());
        System.out.println(student.getId());
        System.out.println(student.getEmail());

        StudentResponseDto studentResponseDto=new StudentResponseDto();
        studentResponseDto.setName(student.getName());
        studentResponseDto.setMessage("Student is saved successfully");

        return studentResponseDto;
    }
}