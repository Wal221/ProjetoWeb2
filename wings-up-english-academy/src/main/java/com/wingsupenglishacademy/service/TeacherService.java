package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.TeacherEntity;
import com.wingsupenglishacademy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


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
}
