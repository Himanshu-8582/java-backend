package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();

//        studentRepository.createStudent(new Student("Rohit", "rohit@gmail.com", 21));

//        studentRepository.updateStudent(
//                new Student("Rohit Negi", "rohit@gmail.com", 26), 2L);

//        studentRepository.deleteStudent(2L);

        studentRepository.getStudent();
    }
}