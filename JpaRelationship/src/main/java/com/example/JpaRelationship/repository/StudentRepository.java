package com.example.JpaRelationship.repository;


import com.example.JpaRelationship.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void createStudent(Student student){
        entityManager.persist(student);
    }

    public void save(Student student){
        entityManager.persist(student);
    }
}
