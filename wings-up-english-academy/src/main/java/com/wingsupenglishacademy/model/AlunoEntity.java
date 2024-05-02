package com.wingsupenglishacademy.model;


import java.io.Serializable;

public class AlunoEntity extends UsuarioEntity implements Serializable  {
    private static final long serialVersionUID = 1L;

    private String matricula;
    private Double notas;
    //private Turma turma;
}
