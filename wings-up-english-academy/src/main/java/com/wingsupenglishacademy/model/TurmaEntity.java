package com.wingsupenglishacademy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wingsupenglishacademy.model.Enum.EnglishLevel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "turma")
public class TurmaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date classSchedule;//horario aula

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnglishLevel englishLevel;

    @Column(nullable = false)
    private String teachingMaterials; //materiais didaticos

    @JoinColumn(name = "teacherID")
    @OneToOne
    private ProfessorEntity teacher;

    @Transient
    private Boolean disponivel=true;

    private final Integer numVagas = 15;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AlunoEntity> students = new ArrayList<>();


    public TurmaEntity() {
    }

    public TurmaEntity(Long id, Date classSchedule, EnglishLevel englishLevel, String teachingMaterials, ProfessorEntity teacher, List<AlunoEntity> students) {
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

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getTeachingMaterials() {
        return teachingMaterials;
    }

    public void setTeachingMaterials(String teachingMaterials) {
        this.teachingMaterials = teachingMaterials;
    }

    public ProfessorEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(ProfessorEntity teacher) {
        this.teacher = teacher;
    }

    public List<AlunoEntity> getStudents() {
        return students;
    }

    public void setStudents(List<AlunoEntity> students) {
        this.students = students;
    }
}