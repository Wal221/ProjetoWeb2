package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.AvaliacaoEntity;
import com.wingsupenglishacademy.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<AvaliacaoEntity> findAll() {return avaliacaoRepository.findAll();}

    public AvaliacaoEntity save(AvaliacaoEntity avaliacaoEntity) {return avaliacaoRepository.save(avaliacaoEntity);}

    public AvaliacaoEntity update(AvaliacaoEntity avaliacaoEntity) { return avaliacaoRepository.save(avaliacaoEntity);}

    public void delete(AvaliacaoEntity avaliacaoEntity) {avaliacaoRepository.delete(avaliacaoEntity);}

    public AvaliacaoEntity findById(Long id) {return avaliacaoRepository.findById(id).get();}
}
