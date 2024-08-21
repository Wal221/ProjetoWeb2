package com.wingsupenglishacademy.service;

import com.wingsupenglishacademy.DTO.requests.RequestAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.mapper.DozerMapper;
import com.wingsupenglishacademy.mapper.custom.AvaliacaoMapper;
import com.wingsupenglishacademy.mapper.custom.AlunoMapper;
import com.wingsupenglishacademy.mapper.custom.TurmaMapper;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.AvaliacaoEntity;
import com.wingsupenglishacademy.model.Document;
import com.wingsupenglishacademy.model.Enum.StatusAvalicao;
import com.wingsupenglishacademy.repository.AvaliacaoRepository;
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
    private AlunoMapper alunoMapper;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private AvaliacaoMapper avali;


    @Autowired
    TurmaService turmaService;

    @Autowired
    TurmaMapper turmaMapper;

    public ResponseAlunoDTO findByIdStudent(Long id) {
        AlunoEntity aluno = alunoRepository.findById(id).get();
       return alunoMapper.convertToEntityStudentDTO(aluno);
    }


    public List<ResponseAlunoDTO> findAllStudent() {
               return alunoMapper.convertListEntityForDTO(alunoRepository.findAll()) ;
    }

    public ResponseAlunoDTO createdStudent(RequestAlunoDTO studentDTO) {
        var entity = alunoMapper.convertToStudentDTO(studentDTO);
        alunoRepository.save(entity);
        return alunoMapper.convertToEntityStudentDTO(entity);
    }

    public AlunoEntity updateStudent(AlunoEntity alunoEntity) {
        return alunoRepository.save(alunoEntity);
    }

    public void deleteStudent(Long id) {
        this.alunoRepository.deleteById(id);

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
            var entity = alunoMapper.convertToStudentDTO(aluno);
            turma.getStudents().add(entity);
            turma.setNumVagas(turma.getNumVagas() - 1);
            turma.setId(idTurma);
            var turmEntity =  this.turmaService.update(turma);
            return turmaMapper.convertEntityForDTO(turmEntity);
        }
        else {
            throw new RuntimeException("Turma sem vagas");
        }
    }

    public void realizarProvar(Long idAluno,Long idProva){
        AlunoEntity aluno = alunoRepository.findById(idAluno).get();

        if(aluno.getAvaliacao() != null){
            AvaliacaoEntity avaliacao = avaliacaoRepository.getReferenceById(idProva);
            this.avaliacaoRepository.save(avaliacao);
            this.alunoRepository.updateStatus(idAluno,idProva, StatusAvalicao.NAO_REALIZADO);


        }
        else{
            throw new RuntimeException("Aluno não possui provas");
        }
    }

    public ResponseAlunoDTO vizualizarHistorico(Long id){
        var estudante= alunoRepository.findById(id).get();


        return alunoMapper.convertToEntityStudentDTO(estudante);

    }
}
