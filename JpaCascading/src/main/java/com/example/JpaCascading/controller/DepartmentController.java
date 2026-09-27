package com.example.JpaCascading.controller;


import com.example.JpaCascading.model.Department;
import com.example.JpaCascading.service.DepartmentService;
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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        departmentService.removeDepartment(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
