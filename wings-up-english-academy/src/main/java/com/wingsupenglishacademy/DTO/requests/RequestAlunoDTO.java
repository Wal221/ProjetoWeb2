package com.wingsupenglishacademy.DTO.requests;


import com.github.dozermapper.core.Mapping;
import com.wingsupenglishacademy.model.AlunoEntity;

import java.io.Serializable;
import java.util.Objects;

public class RequestAlunoDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @Mapping("id")
    private Long key;
    private String name;
    private String email;
    private String telephone;
    private String enroll;
    private Double grade = 0.0;
    private Long turmaId;


    public RequestAlunoDTO() {
    }

    public RequestAlunoDTO(Long id, String name, String email, String telephone, String enroll, Double grade) {
        this.key = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.enroll = enroll;
    }

    public RequestAlunoDTO(AlunoEntity alunoEntity) {
        this.key = alunoEntity.getId();
        this.name = alunoEntity.getName();
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public Long getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(Long turmaId) {
        this.turmaId = turmaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestAlunoDTO that = (RequestAlunoDTO) o;
        return Objects.equals(key, that.key) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(telephone, that.telephone) && Objects.equals(enroll, that.enroll) && Objects.equals(grade, that.grade) && Objects.equals(turmaId, that.turmaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, email, telephone, enroll, grade, turmaId);
    }
}
