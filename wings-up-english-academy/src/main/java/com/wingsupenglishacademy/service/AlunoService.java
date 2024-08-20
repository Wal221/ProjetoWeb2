package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseStudentDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.mapper.custom.StudentMapper;
import com.wingsupenglishacademy.mapper.custom.TurmaMapper;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.Document;
import com.wingsupenglishacademy.repository.DocumentRepository;
import com.wingsupenglishacademy.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {


    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    TurmaService turmaService;

    @Autowired
    TurmaMapper turmaMapper;

    public AlunoEntity findByIdStudent(Long id) {
        return alunoRepository.findById(id).get();
    }


    public List<AlunoEntity> findAllStudent() {
        return alunoRepository.findAll();
    }

    public ResponseStudentDTO createdStudent(RequestAlunoDTO studentDTO) {
        var entity = studentMapper.convertToStudentDTO(studentDTO);
        alunoRepository.save(entity);
        return studentMapper.convertToEntityStudentDTO(entity);
    }

    public AlunoEntity updateStudent(AlunoEntity alunoEntity) {
        return alunoRepository.save(alunoEntity);
    }

    public void deleteStudent(AlunoEntity alunoEntity) {
        alunoRepository.delete(alunoEntity);
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

    public ResponseTurmaDTO matricularTurma(RequestAlunoDTO aluno, Long idTurma) {
        var turma = turmaService.findById(idTurma);
        if(turma.getStudents().size() < turma.getNumVagas()){
            var entity = studentMapper.convertToStudentDTO(aluno);
            turma.getStudents().add(entity);
            turma.setNumVagas(turma.getNumVagas() - 1);

            var turmEntity =  this.turmaService.update(turma);
            return turmaMapper.convertEntityForDTO(turmEntity);
        }
        else {
            throw new RuntimeException("Turma sem vagas");
        }
    }
}
