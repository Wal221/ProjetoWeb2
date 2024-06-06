package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.StudentEntity;
import com.wingsupenglishacademy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public StudentEntity findByIdStudent(Long id) {
        return studentRepository.findById(id).get();
    }

    public List<StudentEntity> findAllStudent() {
        return studentRepository.findAll();
    }

    public StudentEntity createdStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity updateStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public void deleteStudent(StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
    }
}
