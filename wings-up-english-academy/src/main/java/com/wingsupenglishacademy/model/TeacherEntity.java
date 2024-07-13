package com.wingsupenglishacademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "teacher")
public class TeacherEntity extends UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column( nullable = false)
    private Double salary;

    @Column( nullable = false)
    private String especializacao;
    
    @Column( nullable = false)
    private Date horarioAula;


    @JsonIgnore //  não e a melhor solução
    @OneToOne(mappedBy = "teacher")
    private  ClassEntity classEntity;


    public TeacherEntity() {
    }

    public TeacherEntity(Long id, String name, String email, String telephone, Double salary, String especializacao, Date horarioAula, ClassEntity classEntity) {
        super(id, name, email, telephone);
        this.salary = salary;
        this.especializacao = especializacao;
        this.horarioAula = horarioAula;
        this.classEntity = classEntity;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Date getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(Date horarioAula) {
        this.horarioAula = horarioAula;
    }
}