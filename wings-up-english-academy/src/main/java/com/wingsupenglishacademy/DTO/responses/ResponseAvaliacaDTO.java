package com.wingsupenglishacademy.DTO.responses;

import com.wingsupenglishacademy.model.Enum.TipoAvaliacao;

import java.util.Date;
import java.util.Objects;

public class ResponseAvaliacaDTO {

    //private Double nota;
    private TipoAvaliacao tipoAvalicao;
    private Date dataAvalicao;
    private Double valorAvalicao;
    private String nameProfessor;

    public ResponseAvaliacaDTO() {
    }

    public ResponseAvaliacaDTO(Double nota, TipoAvaliacao tipoAvalicao, Date dataAvalicao, Double valorAvalicao) {
        //this.nota = nota;
        this.tipoAvalicao = tipoAvalicao;
        this.dataAvalicao = dataAvalicao;
        this.valorAvalicao = valorAvalicao;
    }


    public String getNameProfessor() {
        return nameProfessor;
    }

    public void setNameProfessor(String nameProfessor) {
        this.nameProfessor = nameProfessor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseAvaliacaDTO that = (ResponseAvaliacaDTO) o;
        return  tipoAvalicao == that.tipoAvalicao && Objects.equals(dataAvalicao, that.dataAvalicao) && Objects.equals(valorAvalicao, that.valorAvalicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash( tipoAvalicao, dataAvalicao, valorAvalicao);
    }

    @Override
    public String toString() {
        return "ResponseAvaliacaDTO{" +
                ", tipoAvalicao=" + tipoAvalicao +
                ", dataAvalicao=" + dataAvalicao +
                ", valorAvalicao=" + valorAvalicao +
                '}';
    }
}
