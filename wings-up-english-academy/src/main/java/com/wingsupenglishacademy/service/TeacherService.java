package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.RequestTeacherDTO;
import com.wingsupenglishacademy.DTO.ResponseTeacherDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.mapper.custom.ProfesorMapper;
import com.wingsupenglishacademy.model.TeacherEntity;
import com.wingsupenglishacademy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
     private ProfesorMapper mapper;

    public TeacherEntity getTeacherById(Long id) {
       return teacherRepository.findById(id).get();
    }

    public List<TeacherEntity> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public TeacherEntity saveTeacher(TeacherEntity teacher) {
        return teacherRepository.save(teacher);
    }

    public TeacherEntity updateTeacher(TeacherEntity teacher) {
        if(getTeacherById(teacher.getId()) != null){
            return teacherRepository.save(teacher);
        }
        return null;

    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }



    public ResponseTeacherDTO createdTeacher(RequestTeacherDTO teacherDTO) {
        // converto o DTO para class para pode Salvalo
       var teacherAux =  DozerMapper.parseObject(teacherDTO, TeacherEntity.class);
       this.teacherRepository.save(teacherAux);

       return this.mapper.convertToTeacherDTO(teacherAux);


    }
}
