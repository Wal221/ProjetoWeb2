package com.wingsupenglishacademy.DTO.requests;

import com.github.dozermapper.core.Mapping;
import java.io.Serializable;
import java.util.Date;

public class RequestProfessorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    private Long id;
    private String name;
    private String especializacao;
    private String email;
    private Long classEntity;
    private Double salary;
    private Date horarioAula;
    private String telephone;

    public RequestProfessorDTO() {}

    public RequestProfessorDTO(Long id, String name, String specialization, String email, Long classEntity, Double salary, Date horarioAula, String telephone) {
        this.id = id;
        this.name = name;
        this.especializacao = specialization;
        this.email = email;
        this.classEntity = classEntity;
        this.salary = salary;
        this.horarioAula = horarioAula;
        this.telephone = telephone;
    }

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(Long classEntity) {
        this.classEntity = classEntity;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
