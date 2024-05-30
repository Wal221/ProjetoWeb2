package com.wingsupenglishacademy.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="student")
public class StudentEntity extends UsuarioEntity implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String enroll;
    @Column(nullable = false)
    private Double grade ;
    @ManyToOne
    private ClassEntity classEntity;
    public StudentEntity() {
        super();
    }

    public StudentEntity(Long id, String name, String email, String telephone, String enroll, Double grade, ClassEntity classEntity) {
        super(id,name,email,telephone);
        this.enroll = enroll;
        this.grade = grade;
        this.classEntity = classEntity;
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

    public ClassEntity getClassEntity() {
        return classEntity;
    }
    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

}
