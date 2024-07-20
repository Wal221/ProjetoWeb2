package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAdministradorDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAdministradorDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.mapper.custom.AdministradorMapper;
import com.wingsupenglishacademy.model.AdministradorEntity;
import com.wingsupenglishacademy.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;
    @Autowired
    private AdministradorMapper administradorMapper;

    public List<AdministradorEntity> listAll() {return administradorRepository.findAll(); }

    public ResponseAdministradorDTO getByIdAdm(Long id) {
        var adm = administradorRepository.findById(id).get();
        return administradorMapper.convertToEntity(adm);
    }

    public ResponseAdministradorDTO createAdministradorDTO(RequestAdministradorDTO administradorDTO){
        var adm = DozerMapper.parseObject(administradorDTO, AdministradorEntity.class);

        administradorRepository.save(adm);
        return administradorMapper.convertToEntity(adm);
    }


}
