package com.example.JpaCascading.repository;


import com.example.JpaCascading.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Student student){
        entityManager.persist(student);
    }

    public Student findById(Long id){
        return entityManager.find(Student.class,id);
    }
}
