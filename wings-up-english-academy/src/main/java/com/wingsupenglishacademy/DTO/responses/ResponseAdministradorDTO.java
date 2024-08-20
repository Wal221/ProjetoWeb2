package com.wingsupenglishacademy.DTO.responses;

public class ResponseAdministradorDTO {

    private String nome;
    private String telefone;

    public ResponseAdministradorDTO() {
    }

    public ResponseAdministradorDTO(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
