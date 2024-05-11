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

    public StudentEntity findById(Long id) {
        return studentRepository.findById(id).get();
    }

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    public StudentEntity save(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public StudentEntity update(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public void delete(StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
    }
}
