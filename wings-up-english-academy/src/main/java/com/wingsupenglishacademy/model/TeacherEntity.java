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
    @Column( nullable = true)
    private String specialization;
    @Column( nullable = false)
    private Date horarioAula;


    @JsonIgnore //  não e a melhor solução 
    @OneToOne(mappedBy = "teacher")
    private  ClassEntity classEntity;


    public TeacherEntity() {
    }

    public TeacherEntity(Long id, String name, String email, String telephone,Double salary, String specialization, Date horarioAula) {
        super(id, name, email, telephone);
        this.salary = salary;
        this.specialization = specialization;
        this.horarioAula = horarioAula;
    }

    public TeacherEntity(Long id, String name, String email, String telephone, Double salary, String specialization, Date horarioAula, ClassEntity classEntity) {
        super(id, name, email, telephone);
        this.salary = salary;
        this.specialization = specialization;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        specialization = specialization;
    }

    public Date getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(Date horarioAula) {
        this.horarioAula = horarioAula;
    }
}