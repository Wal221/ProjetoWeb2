package com.wingsupenglishacademy.model;

import com.wingsupenglishacademy.model.Enum.TipoAvaliacao;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "avaliacao")
public class AvaliacaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Double nota;

    @Enumerated(EnumType.STRING)
    private TipoAvaliacao tipoAvalicao;

    private Date dataAvalicao;

    private Double valorAvalicao;

    @ManyToOne
    private ProfessorEntity professor;

    @ManyToMany
    @Column(nullable = false)
    private List<AlunoEntity> alunos = new ArrayList<>(); // quais alunos vai ter acesso a essa avaliação  ?




    public AvaliacaoEntity() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double notas) {
        this.nota = notas;
    }

    public TipoAvaliacao getTipoAvalicao() {
        return tipoAvalicao;
    }

    public void setTipoAvalicao(TipoAvaliacao tipoAvalicao) {
        this.tipoAvalicao = tipoAvalicao;
    }

    public Date getDataAvalicao() {
        return dataAvalicao;
    }

    public void setDataAvalicao(Date dataAvalicao) {
        this.dataAvalicao = dataAvalicao;
    }

    public Double getValorAvalicao() {
        return valorAvalicao;
    }

    public void setValorAvalicao(Double valorAvalicao) {
        this.valorAvalicao = valorAvalicao;
    }

    public ProfessorEntity getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorEntity professor) {
        this.professor = professor;
    }

    public List<AlunoEntity> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoEntity> alunos) {
        this.alunos = alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoEntity that = (AvaliacaoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nota, that.nota) && tipoAvalicao == that.tipoAvalicao && Objects.equals(dataAvalicao, that.dataAvalicao) && Objects.equals(valorAvalicao, that.valorAvalicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nota, tipoAvalicao, dataAvalicao, valorAvalicao);
    }

    @Override
    public String toString() {
        return "AvaliacaoEntity{" +
                "id=" + id +
                ", notas=" + nota +
                ", tipoAvalicao=" + tipoAvalicao +
                ", dataAvalicao=" + dataAvalicao +
                ", valorAvalicao=" + valorAvalicao +
                '}';
    }
}
