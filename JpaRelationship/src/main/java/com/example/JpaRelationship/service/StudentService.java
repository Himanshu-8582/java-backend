package com.example.JpaRelationship.service;


import com.example.JpaRelationship.model.Department;
import com.example.JpaRelationship.model.Student;
import com.example.JpaRelationship.repository.DepartmentRepository;
import com.example.JpaRelationship.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void createStudent(Student student,Long deptId){
        Department department=departmentRepository.getDepartmentById(deptId);
        student.setDepartment(department);

        // For one to many relation
        department.getStudentList().add(student);
        studentRepository.save(student);
    }

    @Transactional
    public void createStudent(Student student,String deptName){
        Department department=new Department();
        department.setName(deptName);

        department.getStudentList().add(student);

        student.setDepartment(department);

        departmentRepository.save(department);

        studentRepository.save(student);
    }

}
