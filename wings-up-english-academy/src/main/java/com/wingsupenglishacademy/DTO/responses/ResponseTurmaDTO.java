package com.wingsupenglishacademy.DTO.responses;

import com.wingsupenglishacademy.model.Enum.EnglishLevel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ResponseTurmaDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private Date classSchedule;

    private String professor;

    private EnglishLevel englishLevel;

    private List<String> students = new ArrayList<>();

    public ResponseTurmaDTO() {
    }

    public ResponseTurmaDTO(Date classSchedule, String professor, EnglishLevel englishLevel, List<String> students) {
        this.classSchedule = classSchedule;
        this.professor = professor;
        this.englishLevel = englishLevel;
        this.students = students;
    }

    public Date getClassSchedule() {
        return classSchedule;
    }

    public void setClassSchedule(Date classSchedule) {
        this.classSchedule = classSchedule;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public java.lang.String toString() {
        return "ResponseTurmaDTO{" +
                "classSchedule=" + classSchedule +
                ", professor=" + professor +
                ", englishLevel=" + englishLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseTurmaDTO that = (ResponseTurmaDTO) o;
        return Objects.equals(classSchedule, that.classSchedule) && Objects.equals(professor, that.professor) && englishLevel == that.englishLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(classSchedule, professor, englishLevel);
    }
}
