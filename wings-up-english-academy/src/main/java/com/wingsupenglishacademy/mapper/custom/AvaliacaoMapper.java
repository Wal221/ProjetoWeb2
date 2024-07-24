package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.DTO.requests.RequestAvalicaoDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.AvaliacaoEntity;
import com.wingsupenglishacademy.service.AlunoService;
import com.wingsupenglishacademy.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoMapper {

   @Autowired
   ProfessorService professorService;

   @Autowired
   AlunoService alunoService;



    public AvaliacaoEntity convertToDTOEntity(RequestAvalicaoDTO avalicaoDTO){
        AvaliacaoEntity avaliacaoEntity = new AvaliacaoEntity();
        avaliacaoEntity.setId(avalicaoDTO.getKey());
        avaliacaoEntity.setDataAvalicao(avalicaoDTO.getDataAvalicao());
        //busco o professor por ID e adiciono como o professor que realizou a prova
        avaliacaoEntity.setProfessor(professorService.findByTeacherIdEntity(avalicaoDTO.getIdProfesso()));
        avaliacaoEntity.setValorAvalicao(avalicaoDTO.getValorAvalicao());
        avaliacaoEntity.setTipoAvalicao(avalicaoDTO.getTipoAvalicao());
        avaliacaoEntity.setNota(avalicaoDTO.getNota());
        for(int i = 0 ; i < avalicaoDTO.getIdAlunos().size(); i++){
                                                            //pego os IDs dos alunos eles atraves dos seu Id.
            AlunoEntity aluno = alunoService.findByIdStudent(avalicaoDTO.getIdAlunos().get(i));
            avaliacaoEntity.getAlunos().add(aluno);

        }
        return avaliacaoEntity;

    }
}
