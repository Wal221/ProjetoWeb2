package com.wingsupenglishacademy.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="students")
public class StudentEntity extends UsuarioEntity implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String enroll;
    @Column(nullable = false)
    private Double grade ;

//    @OneToOne
//    private ClassEntity classEntity;


    public StudentEntity( Long id, String name, String email, String telephone,String enroll, Double grade) {
        super(id,name,email,telephone);
        this.enroll = enroll;
        this.grade = grade;
    }

    public StudentEntity() {
        super();

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

}