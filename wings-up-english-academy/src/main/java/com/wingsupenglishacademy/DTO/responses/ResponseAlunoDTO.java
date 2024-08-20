package com.wingsupenglishacademy.DTO.responses;

import java.util.List;
import java.util.Objects;

public class ResponseAlunoDTO {

    private String name;
    private String email;
    private String telephone;
    private String enroll;

    public ResponseAlunoDTO() {
    }

    public ResponseAlunoDTO(String name, String email, String telephone, String enroll) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.enroll = enroll;
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

    @Override
    public String toString() {
        return "ResponseAlunoDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", enroll='" + enroll + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseAlunoDTO that = (ResponseAlunoDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(telephone, that.telephone) && Objects.equals(enroll, that.enroll);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, telephone, enroll);
    }
}
