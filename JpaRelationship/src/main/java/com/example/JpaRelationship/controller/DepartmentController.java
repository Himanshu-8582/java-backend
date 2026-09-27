package com.example.JpaRelationship.controller;

import com.example.JpaRelationship.model.Department;
import com.example.JpaRelationship.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("Done");
    }

    @PostMapping("/withStudent")
    public ResponseEntity<String> createDepartment(@RequestBody Department department, @RequestParam String studentName){
        departmentService.createDepartment(department,studentName);
        return ResponseEntity.ok("Done");
    }


}
