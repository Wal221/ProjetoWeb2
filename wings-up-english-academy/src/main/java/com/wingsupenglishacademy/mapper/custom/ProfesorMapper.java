package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.DTO.RequestTeacherDTO;
import com.wingsupenglishacademy.DTO.ResponseTeacherDTO;
import com.wingsupenglishacademy.model.ClassEntity;
import com.wingsupenglishacademy.model.TeacherEntity;
import com.wingsupenglishacademy.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorMapper {

    @Autowired
    private ClassService classService;

    public ResponseTeacherDTO convertToTeacherDTO(TeacherEntity teacher) {
        ResponseTeacherDTO response = new ResponseTeacherDTO();
        response.setName(teacher.getName());
        response.setSpecialization(teacher.getEspecializacao());
        response.setHorarioAula(teacher.getHorarioAula());

        return response;
    }

    public RequestTeacherDTO convertToRequestTeacherDTO(TeacherEntity teacher) {
        RequestTeacherDTO request = new RequestTeacherDTO();
        request.setName(teacher.getName());
        request.setEspecializacao(teacher.getEspecializacao());
        request.setHorarioAula(teacher.getHorarioAula());
        request.setId(teacher.getId());
        request.setEmail(teacher.getEmail());
        request.setClassEntity(teacher.getClassEntity().getId());
        return request;
    }


    public TeacherEntity convertToTeacherEntity(RequestTeacherDTO request) {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName(request.getName());
        teacher.setEspecializacao(request.getEspecializacao());
        teacher.setHorarioAula(request.getHorarioAula());
        teacher.setId(request.getId());
        teacher.setTelephone(request.getTelephone());
        teacher.setEmail(request.getEmail());
        teacher.setSalary(request.getSalary());
        ClassEntity turma = this.classService.findById(request.getClassEntity());
        teacher.setClassEntity(turma);
        return teacher;
    }
}
