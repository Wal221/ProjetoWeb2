package com.wingsupenglishacademy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "relatorioDesempenho")
public class relatorioDesepenho extends AulaEntity implements Serializable {
    @Column(nullable = false)
    private String enroll;

    @Column(nullable = false)
    private Double grade;

    @Column(nullable = false)
    private Double frequenciaAula;

    @Column(nullable = false)
    private Double resultadoAvaliacao;
    @Id
    private Long id;

    public relatorioDesepenho (){

   }

    public relatorioDesepenho(Double grade, Double frequenciaAula, Double resultadoAvaliacao) {
        this.grade = grade;
        this.frequenciaAula = frequenciaAula;
        this.resultadoAvaliacao = resultadoAvaliacao;
    }

    //
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getEnroll() {
        return enroll;
    }

    public void setEnroll(String enroll) {
        this.enroll = enroll;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getFrequenciaAula() {
        return frequenciaAula;
    }

    public void setFrequenciaAula(Double frequenciaAula) {
        this.frequenciaAula = frequenciaAula;
    }

    public Double getResultadoAvaliacao() {
        return resultadoAvaliacao;
    }

    public void setResultadoAvaliacao(Double resultadoAvaliacao) {
        this.resultadoAvaliacao = resultadoAvaliacao;
    }


}
