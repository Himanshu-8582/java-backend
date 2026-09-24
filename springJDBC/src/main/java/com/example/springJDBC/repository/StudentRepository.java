package com.example.springJDBC.repository;

import com.example.springJDBC.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

//    DataSource dataSource;
//    StudentRepository(DataSource dataSource){
//    this.dataSource=dataSource;
//}
    //    @PostConstruct
//    public void init(){
//        System.out.println(dataSource.getClass().getName());
//    }


    private JdbcTemplate jdbcTemplate;
//    private StudentRowMapper studentRowMapper=new StudentRowMapper();

    // We can also use this because it auto maps all the data similar to the above syntax
    private RowMapper<Student> studentRowMapper =new BeanPropertyRowMapper<>(Student.class);

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createStudent(Student student) {
        String sql = """
                         INSERT INTO students(name, email, age)
                         VALUES(?, ?, ?)
                         """;
        int rowAffected = jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getAge());
        if(rowAffected == 1) {
            System.out.println("Create Student successful");
        }
        else {
            System.out.println("Create Student failed");
        }
    }

    public void updateStudent(Student student, Long id) {
        String sql = """
                     UPDATE students
                     SET name = ?,
                         email = ?,
                         age = ?
                     WHERE id = ?
                     """;
        int rowAffected =  jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getAge(),id);
        if(rowAffected == 1) {
            System.out.println("Update operation successful");
        }
        else {
            System.out.println("Updation failed");
        }
    }

    public void deleteStudent(Long id) {
        String sql = """
            DELETE from students WHERE id = ?
        """;
        int rowAffected = jdbcTemplate.update(sql,id);
        if(rowAffected == 1) {
            System.out.println("Delete operation successful");
        }
        else {
            System.out.println("Deletion failed");
        }
    }

    public Student getStudentById(Long id) {

        String sql = """
                SELECT id, name, email, age FROM students
                WHERE id = ?
                """;
        return jdbcTemplate.queryForObject(sql,studentRowMapper,id);
    }

    public List<Student> getStudent() {

        String sql = """
                SELECT id, name, email, age FROM students
                """;
        List<Student> studentList=jdbcTemplate.query(sql,studentRowMapper);
        return studentList;
    }

}

