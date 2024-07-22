package com.wingsupenglishacademy.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "franquia")
public class FranquiaEntity implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id //id para franquia?????
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    private String nomeCidade;
    @Column(nullable = false)
    private String Endereco;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private Long numAlunos;
    @Column(nullable = false)
    private String desepenhoGeral;

    public FranquiaEntity() {
    }

    public FranquiaEntity(Long id, String nomeCidade,String endereco, String telefone, Long numAlunos, String desepenhoGeral ) {
    this.id = id;
    this.nomeCidade = nomeCidade;
    this.Endereco = endereco;
    this.telefone = telefone;
    this.numAlunos = numAlunos;
    this.desepenhoGeral = desepenhoGeral;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getNumAlunos() {
        return numAlunos;
    }

    public void setNumAlunos(Long numAlunos) {
        this.numAlunos = numAlunos;
    }

    public String getDesepenhoGeral() {
        return desepenhoGeral;
    }

    public void setDesepenhoGeral(String desepenhoGeral) {
        this.desepenhoGeral = desepenhoGeral;
    }
}
