package com.wingsupenglishacademy.model;

import com.wingsupenglishacademy.model.Enum.StatusAvalicao;
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

    @Enumerated(EnumType.STRING)
    private TipoAvaliacao tipoAvalicao;

    @Enumerated(EnumType.STRING)
    private StatusAvalicao status;

    private Date dataAvalicao;

    private Double valorAvalicao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professor_id", nullable = true)
    private ProfessorEntity professor;

    @ManyToMany
    @JoinTable(
            name = "students_avaliacao",
            joinColumns = @JoinColumn(name = "avaliacao_id"),
            inverseJoinColumns = @JoinColumn(name = "AlunoEntity_id")
    )
    private List<AlunoEntity> students = new ArrayList<>(); // quais alunos vai ter acesso a essa avaliação  ?


    public AvaliacaoEntity(Long id, TipoAvaliacao tipoAvalicao, Date dataAvalicao, Double valorAvalicao, ProfessorEntity professor, List<AlunoEntity> alunos) {
        this.id = id;
        this.tipoAvalicao = tipoAvalicao;
        this.dataAvalicao = dataAvalicao;
        this.valorAvalicao = valorAvalicao;
        this.professor = professor;
        this.students = alunos;
    }

    public AvaliacaoEntity() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return students;
    }

    public void setAlunos(List<AlunoEntity> alunos) {
        this.students = alunos;
    }

    public StatusAvalicao getStatus() {
        return status;
    }

    public void setStatus(StatusAvalicao status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoEntity that = (AvaliacaoEntity) o;
        return Objects.equals(id, that.id) && tipoAvalicao == that.tipoAvalicao && Objects.equals(dataAvalicao, that.dataAvalicao) && Objects.equals(valorAvalicao, that.valorAvalicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoAvalicao, dataAvalicao, valorAvalicao);
    }

    @Override
    public String toString() {
        return "AvaliacaoEntity{" +
                "id=" + id +
                ", tipoAvalicao=" + tipoAvalicao +
                ", dataAvalicao=" + dataAvalicao +
                ", valorAvalicao=" + valorAvalicao +
                '}';
    }
}
