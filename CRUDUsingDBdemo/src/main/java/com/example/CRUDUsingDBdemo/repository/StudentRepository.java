package com.example.CRUDUsingDBdemo.repository;

import com.example.CRUDUsingDBdemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
