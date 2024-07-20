package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.model.AdministradorEntity;
import com.wingsupenglishacademy.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;


    public List<AdministradorEntity> listAll() {return administradorRepository.findAll(); }
}
