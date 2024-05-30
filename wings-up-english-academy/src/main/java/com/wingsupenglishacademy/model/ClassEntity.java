package com.wingsupenglishacademy.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="class")
public class ClassEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    private TeacherEntity teacherEntity;

    @OneToOne
    private StudentEntity studentEntity;

    //private MateriaisDidaticos materiasididaticos;

    public ClassEntity() {

    }

    public ClassEntity(Long id, String name, TeacherEntity teacherEntity,  StudentEntity studentEntity ){
        this.id = id;
        this.name = name;
        this.teacherEntity = teacherEntity;
        this.studentEntity = studentEntity;
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

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity( StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

}
