package com.wingsupenglishacademy.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aula")
public class AulaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date diaAula;

    @OneToOne
    private ProfessorEntity professor;

    @Column(nullable = false)
    private Date horaAula;

    @Column(nullable = false)
    private String topicosAbordados;

    @Column(nullable = false)
    private Date presenca;

    @OneToMany
    private List<AlunoEntity> alunos = new ArrayList<AlunoEntity>();

    public AulaEntity() {
    }

    public AulaEntity(Date diaAula, Date horaAula, String topicosAbordados, Date presenca) {
    this.diaAula = diaAula;
    this.horaAula = horaAula;
    this.topicosAbordados = topicosAbordados;
    this.presenca = presenca;
    }


    public Date getDiaAula() {
        return diaAula;
    }

    public void setDiaAula(Date diaAula) {
        this.diaAula = diaAula;
    }

    public Date getHoraAula() {
        return horaAula;
    }

    public void setHoraAula(Date horaAula) {
        this.horaAula = horaAula;
    }

    public String getTopicosAbordados() {
        return topicosAbordados;
    }

    public void setTopicosAbordados(String topicosAbordados) {
        this.topicosAbordados = topicosAbordados;
    }

    public Date getPresenca() {
        return presenca;
    }

    public void setPresenca(Date presenca) {
        this.presenca = presenca;
    }
}
