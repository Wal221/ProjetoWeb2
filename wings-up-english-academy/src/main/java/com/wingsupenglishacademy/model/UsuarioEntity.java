package com.wingsupenglishacademy.model;

import jakarta.persistence.*;

@MappedSuperclass
public  abstract class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected String email;
    @Column(nullable = false)
    protected String telephone;


    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String name, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
