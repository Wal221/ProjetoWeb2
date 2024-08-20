package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.requests.RequestAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<AlunoEntity> getStudentById(@PathVariable Long id) {
//        return new ResponseEntity<>(  studentService.findByIdStudent(id), HttpStatus.OK);
//    }

    @GetMapping(value = "/{id}",  produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    public ResponseEntity<ResponseAlunoDTO> getStudentByI(@PathVariable Long id) {
        return new ResponseEntity<>(alunoService.findByIdStudent(id), HttpStatus.OK);

    }

    @PostMapping(value = "/created")
    public ResponseEntity<ResponseAlunoDTO> createStudent(@RequestBody RequestAlunoDTO studentDTO) {

        return new ResponseEntity<>(alunoService.createdStudent(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<AlunoEntity> updateStudent(@RequestBody AlunoEntity student) {
        return new ResponseEntity<>(alunoService.updateStudent(student), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<AlunoEntity> deleteStudent(@RequestParam Long id) {
        alunoService.deleteStudent(id);
         return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<ResponseAlunoDTO>> getAllStudents() {
        return ResponseEntity.ok().body(alunoService.findAllStudent());
    }

    @GetMapping("/material/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable Long id) {
        return alunoService.download(id);
    }

    @PostMapping("/matricula/{idTurma}")
    public ResponseEntity<ResponseTurmaDTO> matriculaTurma(@RequestBody RequestAlunoDTO requestAlunoDTO , @PathVariable Long idTurma) {
        return new ResponseEntity<>(this.alunoService.matricularTurma(requestAlunoDTO,idTurma), HttpStatus.OK);
    }


    @PutMapping("/realiza-avaliaca/{idAluno}/{idProva}")
        public ResponseEntity<String> realizarAvaliacao(@PathVariable Long idAluno, @PathVariable Long idProva) {
         this.alunoService.realizarProvar(idAluno, idProva);
         return ResponseEntity.ok("Avaliação realizada com sucesso!");
        }


        @GetMapping("/historico/{id}")
    public ResponseEntity<ResponseAlunoDTO>buscahistoricoProvas(@PathVariable Long id){
        return ResponseEntity.ok(this.alunoService.vizualizarHistorico(id));
    }

}
