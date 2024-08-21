package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.DTO.requests.RequestProfessorDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseProfessorDTO;
import com.wingsupenglishacademy.model.TurmaEntity;
import com.wingsupenglishacademy.model.ProfessorEntity;
import com.wingsupenglishacademy.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorMapper {

    @Autowired
    private TurmaService turmaService;

    public ResponseProfessorDTO convertToTeacherDTO(ProfessorEntity teacher) {
        ResponseProfessorDTO response = new ResponseProfessorDTO();
        response.setKey(teacher.getId());
        response.setName(teacher.getName());
        response.setSpecialization(teacher.getEspecializacao());
        response.setHorarioAula(teacher.getHorarioAula());

        //criar uma consulta para alterna a tabela e adicona na turma com  o ID refernete , pois da manaiera que esta agora
        //basicamanete estou apenas realizando uma consulta e adiciondo o nome dela a uma variavel.
        response.setTurma(teacher.getClassEntity().getEnglishLevel().toString());
        return response;
    }

    public RequestProfessorDTO convertToRequestTeacherDTO(ProfessorEntity teacher) {
        RequestProfessorDTO request = new RequestProfessorDTO();
        request.setName(teacher.getName());
        request.setEspecializacao(teacher.getEspecializacao());
        request.setHorarioAula(teacher.getHorarioAula());
        request.setKey(teacher.getId());
        request.setEmail(teacher.getEmail());
        request.setClassEntity(teacher.getClassEntity().getId());
        return request;
    }

    public List<ResponseProfessorDTO> convertListEntityForDTO(List<ProfessorEntity> list) {
        List<ResponseProfessorDTO> teacheResponse = new ArrayList<>();
        for(ProfessorEntity teacher : list){
            teacheResponse.add(convertToTeacherDTO(teacher));
        }
        return teacheResponse;
    }


    public ProfessorEntity convertToTeacherEntity(RequestProfessorDTO request) {
        ProfessorEntity teacher = new ProfessorEntity();
        teacher.setName(request.getName());
        teacher.setEspecializacao(request.getEspecializacao());
        teacher.setHorarioAula(request.getHorarioAula());
        teacher.setId(request.getKey());
        teacher.setTelephone(request.getTelephone());
        teacher.setEmail(request.getEmail());
        teacher.setSalary(request.getSalary());
        TurmaEntity turma = this.turmaService.findById(request.getClassEntity());
        teacher.setClassEntity(turma);
        this.turmaService.update(turma);
        return teacher;
    }
}
