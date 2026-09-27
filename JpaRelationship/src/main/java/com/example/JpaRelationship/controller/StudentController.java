package com.example.JpaRelationship.controller;


import com.example.JpaRelationship.model.Student;
import com.example.JpaRelationship.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam Long deptId){
        studentService.createStudent(student,deptId);
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withDept")
    public ResponseEntity<String> createStudent(@RequestBody Student student, @RequestParam String deptName){
        studentService.createStudent(student,deptName);
        return ResponseEntity.ok("Done");
    }
}
