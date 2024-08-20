package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.repository.DTO.requests.RequestAlunoDTO;
import com.wingsupenglishacademy.repository.DTO.responses.ResponseStudentDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentMapper {
    @Autowired
     private TurmaService turmaService;

    public AlunoEntity convertToStudentDTO(RequestAlunoDTO dto){
       AlunoEntity alunoEntity = new AlunoEntity();
       alunoEntity.setId(dto.getKey());
       alunoEntity.setName(dto.getName());
       alunoEntity.setEnroll(dto.getEnroll());
       alunoEntity.setGrade(dto.getGrade());
       alunoEntity.setEmail(dto.getEmail());
       alunoEntity.setTelephone(dto.getTelephone());
       //busco a turma por ID e ja adiciono na minha respectiva turma que o aluno pertence
       alunoEntity.setTurma(turmaService.findById(dto.getTurmaId()));
       return alunoEntity;

    }

    public ResponseStudentDTO convertToEntityStudentDTO(AlunoEntity alunoEntity){
         ResponseStudentDTO  response =   new ResponseStudentDTO();
         response.setName(alunoEntity.getName());
         response.setEnroll(alunoEntity.getEnroll());
         response.setEmail(alunoEntity.getEmail());
         response.setTelephone(alunoEntity.getTelephone());

         return response;
    }




}
