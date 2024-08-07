package com.wingsupenglishacademy.mapper.custom;

import com.wingsupenglishacademy.DTO.responses.ResponseAdministradorDTO;
import com.wingsupenglishacademy.model.AdministradorEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorMapper {

    public ResponseAdministradorDTO convertToEntity(AdministradorEntity administradorEntity) {
        ResponseAdministradorDTO responseAdministradorDTO = new ResponseAdministradorDTO();
        responseAdministradorDTO.setNome(administradorEntity.getName());
        responseAdministradorDTO.setTelefone(administradorEntity.getTelephone());
        return responseAdministradorDTO;
    }
}
