package com.wingsupenglishacademy.DTO.requests;

import com.github.dozermapper.core.Mapping;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.ProfessorEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestAulaDTO {


    @Mapping("id")
    private Long key;


    private Date diaAula;


    private ProfessorEntity professor;


    private Date horaAula;


    private String topicosAbordados;


    private Date presenca;

    private List<AlunoEntity> alunos = new ArrayList<AlunoEntity>();


    public RequestAulaDTO() {
    }

    public RequestAulaDTO(Long id, Date diaAula, ProfessorEntity professor_id, Date horaAula, String topicosAbordados, Date presenca) {
        this.key = id;
        this.diaAula = diaAula;
        this.professor = professor_id;
        this.horaAula = horaAula;
        this.topicosAbordados = topicosAbordados;
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

    public ProfessorEntity getProfessor() {
        return professor;
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


    public Date getPresenca() {
        return presenca;
    }

    public void setPresenca(Date presenca) {
        this.presenca = presenca;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public List<AlunoEntity> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoEntity> alunos) {
        this.alunos = alunos;
    }
}
