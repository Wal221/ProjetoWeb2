package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.StudentDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
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

    public StudentDTO createdStudent(StudentEntity studentDTO) {
         var entity = DozerMapper.parseObject(studentDTO, StudentEntity.class);
         studentRepository.save(entity);
         return DozerMapper.parseObject(entity, StudentDTO.class);
    }

    public StudentEntity updateStudent(StudentEntity studentEntity) {
        return studentRepository.save(studentEntity);
    }

    public void deleteStudent(StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
    }
}
