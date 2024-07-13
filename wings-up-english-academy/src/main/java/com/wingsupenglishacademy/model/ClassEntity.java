package com.wingsupenglishacademy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "turma")
public class ClassEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date classSchedule;//horario aula

    @Column(nullable = false)
    private String englishLevel;

    @Column(nullable = false)
    private String teachingMaterials; //materiais didaticos



    @JoinColumn(name = "teacherID")
    @OneToOne
    private TeacherEntity teacher;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentEntity> students = new ArrayList<>();


    public ClassEntity() {
    }

    public ClassEntity(Long id, Date classSchedule, String englishLevel, String teachingMaterials, TeacherEntity teacher, List<StudentEntity> students) {
        this.id = id;
        this.classSchedule = classSchedule;
        this.englishLevel = englishLevel;
        this.teachingMaterials = teachingMaterials;
        this.teacher = teacher;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getclassSchedule() {
        return classSchedule;
    }

    public void setClassSchedule(Date classSchedule) {
        this.classSchedule = classSchedule;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getTeachingMaterials() {
        return teachingMaterials;
    }

    public void setTeachingMaterials(String teachingMaterials) {
        this.teachingMaterials = teachingMaterials;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}