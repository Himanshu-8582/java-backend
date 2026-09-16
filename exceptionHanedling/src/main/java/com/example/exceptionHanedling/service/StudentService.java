package com.example.exceptionHanedling.service;

import com.example.exceptionHanedling.dto.CreateStudentRequestDto;
import com.example.exceptionHanedling.dto.CreateStudentResponseDto;
import com.example.exceptionHanedling.dto.UpdateStudentReqDto;
import com.example.exceptionHanedling.dto.UpdateStudentResDto;
import com.example.exceptionHanedling.entity.Student;
import com.example.exceptionHanedling.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReq) {

        Student student=mapToEntity(studentReq);

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        Student studentResp = studentRepository.save(student);

        return mapToDto(studentResp);
    }

    public CreateStudentResponseDto getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);

        if(studentResp.isPresent()) {
            return mapToDto(studentResp.get());
        }

        return null;
    }

    public List<CreateStudentResponseDto> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList.stream().map(this::mapToDto).toList();
    }


    public UpdateStudentResDto updateStudent(Long id, UpdateStudentReqDto studentReq) {
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student savedStudent = studentRepository.save(studentToSave);

        return mapToUpdateDto(savedStudent);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent) return false;

        studentRepository.deleteById(id);

        return true;
    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> existingStudent =
                studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return false;
        }

        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);

        return true;
    }

    private Student mapToEntity(CreateStudentRequestDto studentRequestDto){
        Student student=new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setEmail(studentRequestDto.getEmail());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setSubject(studentRequestDto.getSubject());
        student.setDeleted(false);
        return student;
    }

    private CreateStudentResponseDto mapToDto(Student student){
        CreateStudentResponseDto studentResponseDto=new CreateStudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setRollNo(student.getRollNo());
        studentResponseDto.setSubject(student.getSubject());
        studentResponseDto.setCreatedAt(student.getCreatedAt());
        studentResponseDto.setUpdatedAt(student.getUpdatedAt());
        studentResponseDto.setMessage("Student saved Successfully");

        return studentResponseDto;

    }

    private UpdateStudentResDto mapToUpdateDto(Student student){
        UpdateStudentResDto updateStudentResDto=new UpdateStudentResDto();

        updateStudentResDto.setId(student.getId());
        updateStudentResDto.setAge(student.getAge());
        updateStudentResDto.setName(student.getName());
        updateStudentResDto.setEmail(student.getEmail());
        updateStudentResDto.setRollNo(student.getRollNo());
        updateStudentResDto.setSubject(student.getSubject());
        updateStudentResDto.setMessage("Student updated successfully");
        updateStudentResDto.setUpdatedAt(LocalDateTime.now());

        return updateStudentResDto;


    }
}
