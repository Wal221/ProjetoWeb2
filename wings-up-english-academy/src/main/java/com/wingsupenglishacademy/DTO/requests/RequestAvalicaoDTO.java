package com.wingsupenglishacademy.DTO.requests;

import com.github.dozermapper.core.Mapping;
import com.wingsupenglishacademy.model.Enum.TipoAvaliacao;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RequestAvalicaoDTO {


    @Mapping("id")
    private Long key;
    private Double nota;
    private TipoAvaliacao tipoAvalicao;
    private Date dataAvalicao;
    private Double valorAvalicao;
    private Long idProfesso;
    private List<Long> idAlunos;
    public RequestAvalicaoDTO() {
    }

    public RequestAvalicaoDTO(Long key, Double nota, TipoAvaliacao tipoAvalicao, Date dataAvalicao, Double valorAvalicao, Long idProfesso) {
        this.key = key;
        this.nota = nota;
        this.tipoAvalicao = tipoAvalicao;
        this.dataAvalicao = dataAvalicao;
        this.valorAvalicao = valorAvalicao;
        this.idProfesso = idProfesso;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
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

    public Long getIdProfesso() {
        return idProfesso;
    }

    public void setIdProfesso(Long idProfesso) {
        this.idProfesso = idProfesso;
    }

    public List<Long> getIdAlunos() {
        return idAlunos;
    }

    public void setIdAlunos(List<Long> idAlunos) {
        this.idAlunos = idAlunos;
    }

    @Override
    public String toString() {
        return "RequestAvalicaoDTO{" +
                "key=" + key +
                ", nota=" + nota +
                ", tipoAvalicao=" + tipoAvalicao +
                ", dataAvalicao=" + dataAvalicao +
                ", valorAvalicao=" + valorAvalicao +
                ", idProfesso=" + idProfesso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestAvalicaoDTO that = (RequestAvalicaoDTO) o;
        return Objects.equals(key, that.key) && Objects.equals(nota, that.nota) && tipoAvalicao == that.tipoAvalicao && Objects.equals(dataAvalicao, that.dataAvalicao) && Objects.equals(valorAvalicao, that.valorAvalicao) && Objects.equals(idProfesso, that.idProfesso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, nota, tipoAvalicao, dataAvalicao, valorAvalicao, idProfesso);
    }
}
