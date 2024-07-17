package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.TurmaEntity;
import com.wingsupenglishacademy.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {


    @Autowired
    private TurmaRepository turmaRepository;

    public List<TurmaEntity> findAll() {
        return turmaRepository.findAll();
    }

    public TurmaEntity save(TurmaEntity turmaEntity) {
        return turmaRepository.save(turmaEntity);
    }

    public TurmaEntity update(TurmaEntity turmaEntity) {
        return turmaRepository.save(turmaEntity);
    }

    public void delete(TurmaEntity turmaEntity) {
        turmaRepository.delete(turmaEntity);
    }

    public TurmaEntity findById(Long id) {
        return turmaRepository.findById(id).get();
    }
}
