package com.example.springDataJPA.service;

import com.example.springDataJPA.model.Student;
import com.example.springDataJPA.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student fetchStudentById(Long id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.get();
    }

    public List<Student> fetchAll(String name) {


        // Sorting
//        Sort sort = Sort.by("name").descending()
//                .and(
//                        Sort.by("age").ascending()
//                );
//
//        List<Student> studentList =
//                studentRepository.findAll(sort);
//
//        for(Student s : studentList) {
//            System.out.println(s);
//        }
//
//        return studentList;


        // Pagination
        Pageable pageable = PageRequest.of(0, 10);

        Page<Student> studentList =
                studentRepository.findAll(pageable);

        for(Student s : studentList.getContent()) {
            System.out.println(s);
        }

        return studentList.getContent();
    }

    public void updateStudent(Student studentReq,Long id){
        Optional<Student> studentRes=studentRepository.findById(id);
        Student student = studentRes.get();
        student.setAge(studentReq.getAge());
        student.setName(studentReq.getName());
    }
}
