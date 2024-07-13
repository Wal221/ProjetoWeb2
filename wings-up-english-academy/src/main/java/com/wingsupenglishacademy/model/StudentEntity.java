package com.wingsupenglishacademy.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "students")
public class StudentEntity extends UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String enroll;
    @Column(nullable = false)
    private Double grade = 0.0;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id")
    private ClassEntity turma;



    public StudentEntity() {
        super();

    }


    public StudentEntity(Long id, String name, String email, String telephone, String enroll, Double grade) {
        super(id, name, email, telephone);
        this.enroll = enroll;
        this.grade = grade;
    }

    public StudentEntity(Long id, String name, String email, String telephone ,String enroll, Double grade, ClassEntity classEntity) {
        super(id, name, email, telephone);
        this.enroll = enroll;
        this.grade = grade;
        this.turma = classEntity;
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


    public ClassEntity getTurma() {
        return turma;
    }

    public void setTurma(ClassEntity turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
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
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(enroll, that.enroll) && Objects.equals(grade, that.grade) && Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enroll, grade, turma);
    }
}