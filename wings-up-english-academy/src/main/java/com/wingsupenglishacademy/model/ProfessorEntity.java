package com.wingsupenglishacademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "teacher")
public class ProfessorEntity extends UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column( nullable = false)
    private Double salary;

    @Column( nullable = false)
    private String especializacao;
    
    @Column( nullable = false)
    private Date horarioAula;

    @JsonIgnore //  não e a melhor solução
    @OneToOne(mappedBy = "teacher")
    private TurmaEntity turmaEntity;

    @Column( nullable = true)
    @ManyToMany
    private List<Document> mateDidaticos = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<AvaliacaoEntity> avaliacao = new ArrayList<>();

    public ProfessorEntity() {
    }

    public ProfessorEntity(Long id, String name, String email, String telephone, Double salary, String especializacao, Date horarioAula, TurmaEntity turmaEntity) {
        super(id, name, email, telephone);
        this.salary = salary;
        this.especializacao = especializacao;
        this.horarioAula = horarioAula;
        this.turmaEntity = turmaEntity;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public TurmaEntity getClassEntity() {
        return turmaEntity;
    }

    public void setClassEntity(TurmaEntity turmaEntity) {
        this.turmaEntity = turmaEntity;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public Date getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(Date horarioAula) {
        this.horarioAula = horarioAula;
    }

    public TurmaEntity getTurmaEntity() {
        return turmaEntity;
    }

    public List<Document> getMateDidaticos() {
        return mateDidaticos;
    }

    public void setMateDidaticos(List<Document> mateDidaticos) {
        this.mateDidaticos = mateDidaticos;
    }

    public void setTurmaEntity(TurmaEntity turmaEntity) {
        this.turmaEntity = turmaEntity;
    }

    public List<AvaliacaoEntity> getAvaliacao() {
        return avaliacao;
    }


    public void setAvaliacao(List<AvaliacaoEntity> avaliacao) {
        this.avaliacao = avaliacao;
    }
}