package com.wingsupenglishacademy.DTO;

import java.io.Serializable;
import java.util.Date;

public class ResponseTeacherDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String specialization;
    private Date horarioAula;


    public ResponseTeacherDTO() {

    }

    public ResponseTeacherDTO(String name, String specialization, Date horarioAula) {
        this.name = name;
        this.specialization = specialization;
        this.horarioAula = horarioAula;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Date getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(Date horarioAula) {
        this.horarioAula = horarioAula;
    }
}
