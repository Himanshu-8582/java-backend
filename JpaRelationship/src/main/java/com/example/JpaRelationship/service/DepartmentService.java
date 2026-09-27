package com.example.JpaRelationship.service;

import com.example.JpaRelationship.model.Department;
import com.example.JpaRelationship.model.Student;
import com.example.JpaRelationship.repository.DepartmentRepository;
import com.example.JpaRelationship.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository=studentRepository;
    }

    @Transactional
    public void createDepartment(Department department){
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department,String studentName){
        Student student=new Student();
        student.setName(studentName);
        student.setDepartment(department);
        department.getStudentList().add(student);
        studentRepository.save(student);
        departmentRepository.save(department);
    }
}
