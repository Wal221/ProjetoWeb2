package com.wingsupenglishacademy.model;

import com.wingsupenglishacademy.model.Enum.TipoAvaliacao;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "avaliacao")
public class AvaliacaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double notas;
    private TipoAvaliacao tipoAvalicao;
    private Date dataAvalicao;

    public AvaliacaoEntity() {}



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getNotas() {
        return notas;
    }

    public void setNotas(Double notas) {
        this.notas = notas;
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
}