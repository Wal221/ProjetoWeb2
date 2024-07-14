package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.DTO.RequestStudentDTO;
import com.wingsupenglishacademy.DTO.ResponseStudentDTO;
import com.wingsupenglishacademy.model.StudentEntity;
import com.wingsupenglishacademy.service.ClassService;
import com.wingsupenglishacademy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentMapper {
    @Autowired
     private ClassService turmaService;

    public  StudentEntity convertToStudentDTO(RequestStudentDTO dto){
       StudentEntity studentEntity = new StudentEntity();
       studentEntity.setId(dto.getId());
       studentEntity.setName(dto.getName());
       studentEntity.setEnroll(dto.getEnroll());
       studentEntity.setGrade(dto.getGrade());
       studentEntity.setEmail(dto.getEmail());
       studentEntity.setTelephone(dto.getTelephone());
       //busco a turma por ID e ja adiciono na minha respectiva turma que o aluno pertence
       studentEntity.setTurma(turmaService.findById(dto.getTurmaId()));
       return studentEntity;

    }

    public ResponseStudentDTO convertToEntityStudentDTO(StudentEntity studentEntity){
         ResponseStudentDTO  response =   new ResponseStudentDTO();
         response.setName(studentEntity.getName());
         response.setEnroll(studentEntity.getEnroll());
         response.setEmail(studentEntity.getEmail());
         response.setTelephone(studentEntity.getTelephone());

         return response;
    }




}
