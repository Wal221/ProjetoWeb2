package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.AulaEntity;
import com.wingsupenglishacademy.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {
    @Autowired
    AulaRepository aulaRepository;

    public AulaEntity create(AulaEntity aula){
        return aulaRepository.save(aula);
    }

    public List<AulaEntity> findAll(){
        return aulaRepository.findAll();
    }
}
