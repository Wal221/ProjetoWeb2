package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAvalicaoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAvaliacaDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
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

    public ResponseAvaliacaDTO createdAvalicao(RequestAvalicaoDTO avaliacaoDTO) {
        var prova = DozerMapper.parseObject(avaliacaoDTO, AvaliacaoEntity.class);
        avaliacaoRepository.save(prova);
        return DozerMapper.parseObject(prova, ResponseAvaliacaDTO.class);

    }

    public AvaliacaoEntity update(AvaliacaoEntity avaliacaoEntity) { return avaliacaoRepository.save(avaliacaoEntity);}

    public void delete(AvaliacaoEntity avaliacaoEntity) {avaliacaoRepository.delete(avaliacaoEntity);}

    public AvaliacaoEntity findById(Long id) {return avaliacaoRepository.findById(id).get();}
}
