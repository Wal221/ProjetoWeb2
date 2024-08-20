package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAvalicaoDTO;
import com.wingsupenglishacademy.DTO.requests.RequestProfessorDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAvaliacaDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseProfessorDTO;
import com.wingsupenglishacademy.controller.ProfessorController;
import com.wingsupenglishacademy.exceptions.UserNotFoundException;
import com.wingsupenglishacademy.mapper.custom.ProfesorMapper;
import com.wingsupenglishacademy.model.ProfessorEntity;
import com.wingsupenglishacademy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class
ProfessorService {

    @Autowired
    private TeacherRepository teacherRepository;


    @Autowired
    private ProfesorMapper mapper;

    @Autowired
    AvaliacaoService avaliacaoService;


    @Autowired
    DocumentService documentService;

    public ResponseProfessorDTO findByIdTeacher(Long id) {
        var teacher = teacherRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Teacher Not found"));
        ResponseProfessorDTO responseProfessorDTO = mapper.convertToTeacherDTO(teacher);

        responseProfessorDTO.add(linkTo(methodOn(ProfessorController.class).findTeacherByIdDTO(responseProfessorDTO.getKey())).withSelfRel());
        return responseProfessorDTO;
    }

    public ProfessorEntity findByTeacherIdEntity(Long id) {

        var teacher = teacherRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Teacher not Found"));
        return teacher;
    }

    public List<ResponseProfessorDTO> getAllTeachers() {
      List<ProfessorEntity> teachers = teacherRepository.findAll();
      List<ResponseProfessorDTO> responseProfessorDTOS = mapper.convertListEntityForDTO(teachers);

      responseProfessorDTOS
              .stream()
              .forEach(p -> p.add(linkTo(methodOn(ProfessorController.class).findTeacherByIdDTO(p.getKey())).withSelfRel()));

      return responseProfessorDTOS;

    }


    public ResponseProfessorDTO createdTeacher(RequestProfessorDTO teacherDTO) {
        // converto o DTO para class para pode Salvalo
        ProfessorEntity teacherAux = mapper.convertToTeacherEntity(teacherDTO);

        this.teacherRepository.save(teacherAux);
        ResponseProfessorDTO responseProfessorDTO = this.mapper.convertToTeacherDTO(teacherAux);
        return responseProfessorDTO;


    }

    public ProfessorEntity updateTeacher(ProfessorEntity teacher) {
        if (this.teacherRepository.findById(teacher.getId()) != null) {
            return teacherRepository.save(teacher);
        }
        return null;

    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }


    public ResponseAvaliacaDTO criarAvaliacao(RequestAvalicaoDTO avaliacaoDTO){
      return  this.avaliacaoService.createdAvalicao(avaliacaoDTO);
    }


    public String exportaMeterial(Long id,MultipartFile file) throws IOException {
        // busca o id do professor que esta adicionando esse documento;
        var professor = teacherRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Teacher not Found"));
        // crio uum documento em seguida adiciono a lista de um referente professor indicando que esse documento esta associado
        // a um professor

        //depois de adicionar
        professor.getMateDidaticos().add(documentService.upload(file));
        //atualizo o meu professor
        teacherRepository.save(professor);
        return "Documento Criado";
    }


}
