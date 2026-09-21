package com.example.AOP2nd.controller;

import com.example.AOP2nd.dto.Student;
import com.example.AOP2nd.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student s = studentService.createStudent(student);
        return ResponseEntity.ok(s);
    }

    @GetMapping
    public ResponseEntity<String> dummyMethod() {
        String s = "aditya";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
