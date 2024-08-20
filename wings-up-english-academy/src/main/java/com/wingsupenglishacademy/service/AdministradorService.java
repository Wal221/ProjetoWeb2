package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAdministradorDTO;
import com.wingsupenglishacademy.DTO.requests.RequestAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAdministradorDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAlunoDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.mapper.custom.AdministradorMapper;
import com.wingsupenglishacademy.model.AdministradorEntity;
import com.wingsupenglishacademy.model.AlunoEntity;
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

    @Autowired
    AlunoService alunoService;
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

    public ResponseAlunoDTO criarNovoAluno(RequestAlunoDTO aluno){
        return alunoService.createdStudent(aluno);
    }

    public ResponseAlunoDTO findByIdStudent(Long id) {
         return alunoService.findByIdStudent(id);

    }


    public List<ResponseAlunoDTO> findAllStudent() {
       return alunoService.findAllStudent();
    }



}
