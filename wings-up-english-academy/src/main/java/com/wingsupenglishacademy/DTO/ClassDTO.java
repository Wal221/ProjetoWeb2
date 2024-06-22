package com.wingsupenglishacademy.DTO;



import com.wingsupenglishacademy.model.StudentEntity;
import com.wingsupenglishacademy.model.TeacherEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassDTO {
    private Long id;


    private Date classSchedule;//horario aula


    private String englishLevel;


    private String teachingMaterials; //materiais didaticos

    private TeacherDTO teacher; // tenho que passa apenas o ID do meu professor


    private List<StudentDTO> students = new ArrayList<>(); // passar somente os ID dos alunos

    public ClassDTO() {}


}
