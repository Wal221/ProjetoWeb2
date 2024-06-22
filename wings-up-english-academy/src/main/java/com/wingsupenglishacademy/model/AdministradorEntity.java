package com.wingsupenglishacademy.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "administrador")
public class AdministradorEntity extends UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String enroll;

    @Column(nullable = false)
    private Double grade ;

    public AdministradorEntity(Long id, String name, String enroll, Double grade) {
        super(id, name);
        this.enroll = enroll;
        this.grade = grade;
    }
    public AdministradorEntity() {}

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
}
