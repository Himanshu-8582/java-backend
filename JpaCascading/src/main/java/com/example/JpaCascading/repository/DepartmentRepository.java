package com.example.JpaCascading.repository;


import com.example.JpaCascading.model.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Department department){
        entityManager.persist(department);
    }

    public void removeDepartment(Department department){
        entityManager.remove(department);
    }

    public Department findById(Long id){
        return entityManager.find(Department.class,id);
    }
}
