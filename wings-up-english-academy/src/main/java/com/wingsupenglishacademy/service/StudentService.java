package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.RequestStudentDTO;
import com.wingsupenglishacademy.DTO.ResponseStudentDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.mapper.custom.StudentMapper;
import com.wingsupenglishacademy.model.StudentEntity;
import com.wingsupenglishacademy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    public StudentEntity findByIdStudent(Long id) {
        return studentRepository.findById(id).get();
    }


    public List<StudentEntity> findAllStudent() {
        return studentRepository.findAll();
    }

    public ResponseStudentDTO createdStudent(RequestStudentDTO studentDTO) {
        var entity = studentMapper.convertToStudentDTO(studentDTO);
        studentRepository.save(entity);
        return studentMapper.convertToEntityStudentDTO(entity);
    }

    public StudentEntity updateStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public void deleteStudent(StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
    }
}
