package com.wingsupenglishacademy.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "administrador")
public class AdministradorEntity extends UsuarioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public AdministradorEntity(Long id, String name, String enroll, Double grade, String email, String telephone) {
        super(id, name, email, telephone);
    }
    public AdministradorEntity() {}

}
