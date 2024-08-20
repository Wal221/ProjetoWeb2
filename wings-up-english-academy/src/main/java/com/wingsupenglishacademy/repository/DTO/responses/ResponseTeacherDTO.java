package com.wingsupenglishacademy.DTO.responses;

import com.github.dozermapper.core.Mapping;
import jakarta.persistence.Id;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ResponseTeacherDTO extends RepresentationModel<ResponseTeacherDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Mapping("id")
    private Long key;
    private String name;
    private String specialization;
    private Date horarioAula;
    private String turma;


    public ResponseTeacherDTO() {

    }

    public ResponseTeacherDTO(String name, String specialization, Date horarioAula, String turma) {
        this.name = name;
        this.specialization = specialization;
        this.horarioAula = horarioAula;
        this.turma = turma;
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "ResponseTeacherDTO{" +
                "name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", horarioAula=" + horarioAula +
                ", turma='" + turma + '\'' +
                "Links" + getLinks();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseTeacherDTO that = (ResponseTeacherDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(specialization, that.specialization) && Objects.equals(horarioAula, that.horarioAula) && Objects.equals(turma, that.turma);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, specialization, horarioAula, turma);
    }

}
