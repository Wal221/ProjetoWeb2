package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.RequestTeacherDTO;
import com.wingsupenglishacademy.DTO.ResponseTeacherDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.mapper.custom.ProfesorMapper;
import com.wingsupenglishacademy.model.ClassEntity;
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
    private ClassService classService;

    @Autowired
    private ProfesorMapper mapper;

    public ResponseTeacherDTO findByIdTeacher(Long id) {
        var teacher = teacherRepository.findById(id).get();
        ResponseTeacherDTO responseTeacherDTO = mapper.convertToTeacherDTO(teacher);
        return responseTeacherDTO;
    }

    public List<TeacherEntity> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public ResponseTeacherDTO createdTeacher(RequestTeacherDTO teacherDTO) {

        // converto o DTO para class para pode Salvalo
        TeacherEntity teacherAux = mapper.convertToTeacherEntity(teacherDTO);

        this.teacherRepository.save(teacherAux);
        ResponseTeacherDTO responseTeacherDTO = this.mapper.convertToTeacherDTO(teacherAux);
        return responseTeacherDTO;





    }

    public TeacherEntity updateTeacher(TeacherEntity teacher) {
        if (getTeacherById(teacher.getId()) != null) {
            return teacherRepository.save(teacher);
        }
        return null;

    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }







}
