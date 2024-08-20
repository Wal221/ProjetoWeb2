package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.requests.RequestAdministradorDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAdministradorDTO;
import com.wingsupenglishacademy.model.AdministradorEntity;
import com.wingsupenglishacademy.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseAdministradorDTO> getAdministradorById(@PathVariable Long id) {
        return new ResponseEntity<>(administradorService.getByIdAdm(id), HttpStatus.OK);
    }

    @PostMapping(value = "/created")
    public ResponseEntity<ResponseAdministradorDTO> createAdministrador(@RequestBody RequestAdministradorDTO request) {
        return new ResponseEntity<>(administradorService.createAdministradorDTO(request), HttpStatus.CREATED);
    }
}
