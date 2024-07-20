package com.wingsupenglishacademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "aula")
public class AulaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    @Column(nullable = false)
    private String enroll;

    @Column(nullable = false)
    private Double grade;

    @Column(nullable = false)
    private Date diaAula;

    @Column(nullable = false)
    private Date horaAula;

    @Column(nullable = false)
    private String topicosAbordados;

    @Column(nullable = false)
    private Date presenca;

    public AulaEntity() {
    }

    public AulaEntity(Date diaAula, Date horaAula, String topicosAbordados, Date presenca) {
        this.diaAula = diaAula;
        this.horaAula = horaAula;
        this.topicosAbordados = topicosAbordados;
        this.presenca = presenca;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Date getDiaAula() {
        return diaAula;
    }

    public void setDiaAula(Date diaAula) {
        this.diaAula = diaAula;
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
}
