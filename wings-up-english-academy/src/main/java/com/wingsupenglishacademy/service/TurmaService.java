package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestTurmaDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.mapper.custom.TurmaMapper;
import com.wingsupenglishacademy.model.TurmaEntity;
import com.wingsupenglishacademy.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {


    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    TurmaMapper turmaMapper;



    public List<ResponseTurmaDTO> findAll() {
        List<TurmaEntity> turmas = turmaRepository.findAll();
        return turmaMapper.convertListEntityForDTO(turmas);

    }

    public ResponseTurmaDTO createdTurma(RequestTurmaDTO turma) {
        var entity = DozerMapper.parseObject(turma, TurmaEntity.class);
        turmaRepository.save(entity);
        return turmaMapper.convertEntityForDTO(entity);
    }

    public TurmaEntity update(TurmaEntity turmaEntity) {
        return turmaRepository.save(turmaEntity);
    }

    public void delete(TurmaEntity turmaEntity) {
        turmaRepository.delete(turmaEntity);
    }


    /**
     * Esse metodo existe para ser possivel relacionar algumas turmas com as classes professsor, e Estudante
     * Ja que as mesmas depedem desses metodo para realizar alguns parsers
     * @param id
     * @return
     */
    public TurmaEntity findById(Long id) {
        return turmaRepository.findById(id).get();
    }


    /**
     * Esse metodo existe para se ter como respostas somente oque for necessario
     * ou seja esse e o nosso ResponseDTO da classe turma
     * @param id
     * @return
     */
    public ResponseTurmaDTO findByIdTurma(Long id) {
        var turma =  turmaRepository.findById(id).get();
        return turmaMapper.convertEntityForDTO(turma);
    }
}
