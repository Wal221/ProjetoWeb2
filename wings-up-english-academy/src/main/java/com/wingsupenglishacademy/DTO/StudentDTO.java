package com.wingsupenglishacademy.DTO;


import com.wingsupenglishacademy.model.StudentEntity;

public class StudentDTO {

    private Long id;
    private String name;
    //private String email;
   // private String telephone;
    //private String enroll;
    private Double grade;


    public StudentDTO() {
    }

    public StudentDTO(StudentEntity studentEntity) {
        this.id = studentEntity.getId();
        this.name = studentEntity.getName();
        this.grade = studentEntity.getGrade();
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

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTelephone() {
//        return telephone;
//    }
//
//    public void setTelephone(String telephone) {
//        this.telephone = telephone;
//    }
//
//    public String getEnroll() {
//        return enroll;
//    }
//
//    public void setEnroll(String enroll) {
//        this.enroll = enroll;
//    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
