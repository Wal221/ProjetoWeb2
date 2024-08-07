package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.DTO.requests.RequestProfessorDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTeacherDTO;
import com.wingsupenglishacademy.model.TurmaEntity;
import com.wingsupenglishacademy.model.ProfessorEntity;
import com.wingsupenglishacademy.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorMapper {

    @Autowired
    private TurmaService turmaService;

    public ResponseTeacherDTO convertToTeacherDTO(ProfessorEntity teacher) {
        ResponseTeacherDTO response = new ResponseTeacherDTO();
        response.setName(teacher.getName());
        response.setSpecialization(teacher.getEspecializacao());
        response.setHorarioAula(teacher.getHorarioAula());

        //criar uma consulta para alterna a tabela e adicona na turma com  o ID refernete , pois da manaiera que esta agora
        //basicamanete estou apenas realizando uma consulta e adiciondo o nome dela euma varival.
        response.setTurma(teacher.getClassEntity().getEnglishLevel().toString());
        return response;
    }

    public RequestProfessorDTO convertToRequestTeacherDTO(ProfessorEntity teacher) {
        RequestProfessorDTO request = new RequestProfessorDTO();
        request.setName(teacher.getName());
        request.setEspecializacao(teacher.getEspecializacao());
        request.setHorarioAula(teacher.getHorarioAula());
        request.setId(teacher.getId());
        request.setEmail(teacher.getEmail());
        request.setClassEntity(teacher.getClassEntity().getId());
        return request;
    }


    public ProfessorEntity convertToTeacherEntity(RequestProfessorDTO request) {
        ProfessorEntity teacher = new ProfessorEntity();
        teacher.setName(request.getName());
        teacher.setEspecializacao(request.getEspecializacao());
        teacher.setHorarioAula(request.getHorarioAula());
        teacher.setId(request.getId());
        teacher.setTelephone(request.getTelephone());
        teacher.setEmail(request.getEmail());
        teacher.setSalary(request.getSalary());
        TurmaEntity turma = this.turmaService.findById(request.getClassEntity());
        teacher.setClassEntity(turma);
        return teacher;
    }
}
