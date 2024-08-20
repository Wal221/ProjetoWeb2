package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.repository.DTO.requests.RequestAvalicaoDTO;
import com.wingsupenglishacademy.repository.DTO.responses.ResponseAvaliacaDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.AvaliacaoEntity;
import com.wingsupenglishacademy.model.ProfessorEntity;
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


    public AvaliacaoEntity convertToDTOEntity(RequestAvalicaoDTO avalicaoDTO) {
        AvaliacaoEntity avaliacaoEntity = new AvaliacaoEntity();
        avaliacaoEntity.setId(avalicaoDTO.getKey());
        avaliacaoEntity.setDataAvalicao(avalicaoDTO.getDataAvalicao());
        //busco o professor por ID e adiciono como o professor que realizou a prova
        ProfessorEntity professor = new ProfessorEntity();
        professor.setId(avalicaoDTO.getKey());
        avaliacaoEntity.setProfessor(professor);

        avaliacaoEntity.setValorAvalicao(avalicaoDTO.getValorAvalicao());
        avaliacaoEntity.setTipoAvalicao(avalicaoDTO.getTipoAvalicao());
        for (int i = 0; i < avalicaoDTO.getIdAlunos().size(); i++) {
            //pego os IDs dos alunos eles atraves dos seu Id.
            AlunoEntity aluno = alunoService.findByIdStudent(avalicaoDTO.getIdAlunos().get(i));
            avaliacaoEntity.getAlunos().add(aluno);

        }
        return avaliacaoEntity;

    }

    public ResponseAvaliacaDTO convertEntityToResponse(AvaliacaoEntity avaliacaoEntity){
        ResponseAvaliacaDTO response = new ResponseAvaliacaDTO();

        response.setDataAvalicao(avaliacaoEntity.getDataAvalicao());
        response.setValorAvalicao(avaliacaoEntity.getValorAvalicao());
        response.setTipoAvalicao(avaliacaoEntity.getTipoAvalicao());
        response.setNameProfessor(avaliacaoEntity.getProfessor().getName());
        return response;
    }
}
