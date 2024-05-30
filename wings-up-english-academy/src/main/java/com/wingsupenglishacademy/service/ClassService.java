package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.ClassEntity;
import com.wingsupenglishacademy.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

    public List<ClassEntity> findAll() {
        return classRepository.findAll();
    }
    public ClassEntity save(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }
    public ClassEntity update(ClassEntity classEntity) {
        return classRepository.save(classEntity);
    }
    public void delete(ClassEntity classEntity) {
        classRepository.delete(classEntity);
    }
    public ClassEntity findById(Long id) {
        return classRepository.findById(id).get();
    }
}
