package com.wingsupenglishacademy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


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

    @JsonIgnore
    @OneToOne(mappedBy = "professor")
    private AvaliacaoEntity avaliacao;

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
}