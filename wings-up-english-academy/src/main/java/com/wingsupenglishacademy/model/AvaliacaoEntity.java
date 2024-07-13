package com.wingsupenglishacademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "avaliacao")
public class AvaliacaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(nullable = false)
    private String enroll;

    @Column(nullable = false)
    private Double grade ;

    @Column(nullable = false)
    private Double provas;

    @Column(nullable = false)
    private String trabalhoGrupo;

    @Column(nullable = false)
    private String participacaoAula;

    public AvaliacaoEntity() {}

    public AvaliacaoEntity(Double provas, String enroll, Double grade, String trabalhoGrupo, String participacaoAula) {
    this.provas = provas;
    this.enroll = enroll;
    this.grade = grade;
    this.trabalhoGrupo = trabalhoGrupo;
    this.participacaoAula = participacaoAula;
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

    public Double getProvas() {
        return provas;
    }

    public void setProvas(Double provas) {
        this.provas = provas;
    }

    public String getTrabalhoGrupo() {
        return trabalhoGrupo;
    }

    public void setTrabalhoGrupo(String trabalhoGrupo) {
        this.trabalhoGrupo = trabalhoGrupo;
    }

    public String getParticipacaoAula() {
        return participacaoAula;
    }

    public void setParticipacaoAula(String participacaoAula) {
        this.participacaoAula = participacaoAula;
    }
}
