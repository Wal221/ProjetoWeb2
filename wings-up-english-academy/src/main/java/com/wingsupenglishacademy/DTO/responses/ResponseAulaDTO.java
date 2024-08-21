package com.wingsupenglishacademy.DTO.responses;

import com.github.dozermapper.core.Mapping;
import com.wingsupenglishacademy.model.Enum.EnglishLevel;
import com.wingsupenglishacademy.model.ProfessorEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResponseAulaDTO {

    @Mapping("id")
    private Long key;


    private Date diaAula;


    private String professor;


    private Date horaAula;


    private String topicosAbordados;


    private Date presenca;

    private List<String> students = new ArrayList<>();


    public ResponseAulaDTO() {
    }

    public ResponseAulaDTO(Long key, Date diaAula, Date horaAula, String topicosAbordados, List<String> students, Date presenca) {
        this.key = key;
        this.diaAula = diaAula;
        this.horaAula = horaAula;
        this.topicosAbordados = topicosAbordados;
        this.students = students;
        this.presenca = presenca;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Date getDiaAula() {
        return diaAula;
    }

    public void setDiaAula(Date diaAula) {
        this.diaAula = diaAula;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public Date getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(Date horaAula) {
        this.horaAula = horaAula;
    }

    public String getTopicosAbordados() {
        return topicosAbordados;
    }

    public void setTopicosAbordados(String topicosAbordados) {
        this.topicosAbordados = topicosAbordados;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public Date getPresenca() {
        return presenca;
    }

    public void setPresenca(Date presenca) {
        this.presenca = presenca;
    }
}
