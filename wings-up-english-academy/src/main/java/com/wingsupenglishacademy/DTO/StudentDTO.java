package com.wingsupenglishacademy.DTO;


import com.github.dozermapper.core.Mapping;
import com.wingsupenglishacademy.model.StudentEntity;

public class StudentDTO {

    @Mapping("id")
    private Long id;
    private String name;
    private String email;
    private String telephone;
    private String enroll;



    public StudentDTO() {
    }

    public StudentDTO(Long id, String name, String email, String telephone, String enroll, Double grade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.enroll = enroll;
    }

    public StudentDTO(StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.name = studentEntity.getName();
    }

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
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
