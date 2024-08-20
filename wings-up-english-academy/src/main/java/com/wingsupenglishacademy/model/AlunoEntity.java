package com.wingsupenglishacademy.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "students")
public class AlunoEntity extends UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String enroll;
    @Column(nullable = false)
    private Double grade = 0.0;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id")
    private TurmaEntity turma;


    @ManyToMany(fetch = FetchType.LAZY)
    private List<AvaliacaoEntity> avaliacao = new ArrayList<>();

    public AlunoEntity() {
        super();

    }


    public AlunoEntity(Long id, String name, String email, String telephone, String enroll, Double grade) {
        super(id, name, email, telephone);
        this.enroll = enroll;
        this.grade = grade;
    }

    public AlunoEntity(Long id, String name, String email, String telephone , String enroll, Double grade, TurmaEntity turmaEntity) {
        super(id, name, email, telephone);
        this.enroll = enroll;
        this.grade = grade;
        this.turma = turmaEntity;
    }


    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }


    public TurmaEntity getTurma() {
        return turma;
    }

    public void setTurma(TurmaEntity turma) {
        this.turma = turma;
    }

    public List<AvaliacaoEntity> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<AvaliacaoEntity> avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public String toString() {
        return "AlunoEntity{" +
                "enroll='" + enroll + '\'' +
                ", grade=" + grade +
                ", turma=" + turma +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoEntity that = (AlunoEntity) o;
        return Objects.equals(enroll, that.enroll) && Objects.equals(grade, that.grade) && Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enroll, grade, turma);
    }
}