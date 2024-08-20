package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAvalicaoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAvaliacaDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.AvaliacaoEntity;
import com.wingsupenglishacademy.model.ProfessorEntity;
import com.wingsupenglishacademy.repository.AvaliacaoRepository;
import com.wingsupenglishacademy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public List<AvaliacaoEntity> findAll() {return avaliacaoRepository.findAll();}

    public ResponseAvaliacaDTO createdAvalicao(RequestAvalicaoDTO avaliacaoDTO) {

        var prova = DozerMapper.parseObject(avaliacaoDTO, AvaliacaoEntity.class);
        ProfessorEntity professor =  teacherRepository.getReferenceById(avaliacaoDTO.getIdProfesso());

        prova.setProfessor(professor);

        //busco os alunos da classe do professor
        List<AlunoEntity> alunos = professor.getClassEntity().getStudents();

        for(AlunoEntity aluno : alunos){
            aluno.getAvaliacao().add(prova);
        }
        avaliacaoRepository.save(prova);


        return DozerMapper.parseObject(prova, ResponseAvaliacaDTO.class);

    }

    public AvaliacaoEntity saveAvaliacaoEntity (AvaliacaoEntity avaliacaoEntity ){
//        AvaliacaoEntity avalia = avaliacaoEntity;
//        avalia.setProfessor(professorService.findByTeacherIdEntity(avaliacaoEntity.getProfessor().getId()));
        return avaliacaoRepository.save(avaliacaoEntity);
    }

    public AvaliacaoEntity update(AvaliacaoEntity avaliacaoEntity) { return avaliacaoRepository.save(avaliacaoEntity);}

    public void delete(AvaliacaoEntity avaliacaoEntity) {avaliacaoRepository.delete(avaliacaoEntity);}

    public AvaliacaoEntity findById(Long id) {return avaliacaoRepository.findById(id).get();}
}
