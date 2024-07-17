package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.DTO.RequestTeacherDTO;
import com.wingsupenglishacademy.DTO.ResponseTeacherDTO;
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

        return response;
    }

    public RequestTeacherDTO convertToRequestTeacherDTO(ProfessorEntity teacher) {
        RequestTeacherDTO request = new RequestTeacherDTO();
        request.setName(teacher.getName());
        request.setEspecializacao(teacher.getEspecializacao());
        request.setHorarioAula(teacher.getHorarioAula());
        request.setId(teacher.getId());
        request.setEmail(teacher.getEmail());
        request.setClassEntity(teacher.getClassEntity().getId());
        return request;
    }


    public ProfessorEntity convertToTeacherEntity(RequestTeacherDTO request) {
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
