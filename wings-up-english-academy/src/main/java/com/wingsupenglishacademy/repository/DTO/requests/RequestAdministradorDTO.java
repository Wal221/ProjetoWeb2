package com.wingsupenglishacademy.DTO.requests;

import com.github.dozermapper.core.Mapping;

import java.io.Serializable;
import java.util.Objects;

public class RequestAdministradorDTO implements Serializable {

    @Mapping("id")
        private Long id;
        private String name;
        private String email;
        private String telephone;

    public RequestAdministradorDTO() {
    }

    public RequestAdministradorDTO(Long id, String name, String email, String telephone) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestAdministradorDTO that = (RequestAdministradorDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, telephone);
    }
}
