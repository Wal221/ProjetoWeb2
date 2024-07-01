package com.wingsupenglishacademy.DTO;


import com.wingsupenglishacademy.model.ClassEntity;

import java.util.Date;


public class RequestTeacherDTO {
    private Long key;
    private String name;
    private String specialization;
    private String email;
    private ClassEntity classEntity;
    private Double salary;
    private Date horarioAula;

    public RequestTeacherDTO() {
    }


    public RequestTeacherDTO(Long key, String name, String specialization, String email, ClassEntity classEntity, Double salary, Date horarioAula) {
        this.key = key;
        this.name = name;
        this.specialization = specialization;
        this.email = email;
        this.classEntity = classEntity;
        this.salary = salary;
        this.horarioAula = horarioAula;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(Date horarioAula) {
        this.horarioAula = horarioAula;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
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
        this.specialization = specialization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
