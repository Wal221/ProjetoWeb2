package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAvalicaoDTO;
import com.wingsupenglishacademy.DTO.requests.RequestProfessorDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAvaliacaDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTeacherDTO;
import com.wingsupenglishacademy.exceptions.UserNotFoundException;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.mapper.custom.AvaliacaoMapper;
import com.wingsupenglishacademy.mapper.custom.ProfesorMapper;
import com.wingsupenglishacademy.model.AvaliacaoEntity;
import com.wingsupenglishacademy.model.Document;
import com.wingsupenglishacademy.model.ProfessorEntity;
import com.wingsupenglishacademy.repository.AvaliacaoRepository;
import com.wingsupenglishacademy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public ResponseTeacherDTO findByIdTeacher(Long id) {
        var teacher = teacherRepository.findById(id).get();
        ResponseTeacherDTO responseTeacherDTO = mapper.convertToTeacherDTO(teacher);
        return responseTeacherDTO;
    }

    public ProfessorEntity findByTeacherIdEntity(Long id) {

        var teacher = teacherRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Teacher not Found"));
        return teacher;
    }

    public List<ProfessorEntity> getAllTeachers() {
        return teacherRepository.findAll();
    }


    public ResponseTeacherDTO createdTeacher(RequestProfessorDTO teacherDTO) {
        // converto o DTO para class para pode Salvalo
        ProfessorEntity teacherAux = mapper.convertToTeacherEntity(teacherDTO);

        this.teacherRepository.save(teacherAux);
        ResponseTeacherDTO responseTeacherDTO = this.mapper.convertToTeacherDTO(teacherAux);
        return responseTeacherDTO;


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
