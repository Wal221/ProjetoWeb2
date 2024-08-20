package com.wingsupenglishacademy.DTO.requests;



import com.github.dozermapper.core.Mapping;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.Enum.EnglishLevel;
import com.wingsupenglishacademy.model.ProfessorEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestTurmaDTO {

    @Mapping("id")
    private Long key;

    private Date classSchedule;//horario aula

    private EnglishLevel englishLevel;

    private String teachingMaterials; //materiais didaticos

    private ProfessorEntity teacher;

   // private Integer numVagas;

    private List<AlunoEntity> students = new ArrayList<>(); // passar somente os ID dos alunos

    public RequestTurmaDTO() {}


    public Long getKey() {
        return key;
    }

    public void setKey(Long Key) {
        this.key = key;
    }

    public Date getClassSchedule() {
        return classSchedule;
    }

    public void setClassSchedule(Date classSchedule) {
        this.classSchedule = classSchedule;
    }

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getTeachingMaterials() {
        return teachingMaterials;
    }

    public void setTeachingMaterials(String teachingMaterials) {
        this.teachingMaterials = teachingMaterials;
    }


    public ProfessorEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(ProfessorEntity teacher) {
        this.teacher = teacher;
    }

    public List<AlunoEntity> getStudents() {
        return students;
    }

    public void setStudents(List<AlunoEntity> students) {
        this.students = students;
    }

//    public Integer getNumVagas() {
//        return numVagas;
//    }
//
//    public void setNumVagas(Integer numVagas) {
//        this.numVagas = numVagas;
//    }
}
