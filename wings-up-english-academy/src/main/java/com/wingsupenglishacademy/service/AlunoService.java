package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseStudentDTO;
import com.wingsupenglishacademy.mapper.custom.StudentMapper;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.Document;
import com.wingsupenglishacademy.repository.DocumentRepository;
import com.wingsupenglishacademy.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DocumentRepository documentRepository;

    public AlunoEntity findByIdStudent(Long id) {
        return studentRepository.findById(id).get();
    }


    public List<AlunoEntity> findAllStudent() {
        return studentRepository.findAll();
    }

    public ResponseStudentDTO createdStudent(RequestAlunoDTO studentDTO) {
        var entity = studentMapper.convertToStudentDTO(studentDTO);
        studentRepository.save(entity);
        return studentMapper.convertToEntityStudentDTO(entity);
    }

    public AlunoEntity updateStudent(AlunoEntity alunoEntity) {
        return studentRepository.save(alunoEntity);
    }

    public void deleteStudent(AlunoEntity alunoEntity) {
        studentRepository.delete(alunoEntity);
    }


    public ResponseEntity<ByteArrayResource> download(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
        HttpHeaders headers = new HttpHeaders();

        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + document.getName());
        headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
        headers.add(HttpHeaders.CONTENT_LENGTH, String.valueOf(document.getData().length));

        return ResponseEntity.ok()
                .headers(headers)
                .body(new ByteArrayResource(document.getData()));
    }
}
