package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.requests.RequestAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseStudentDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.model.TurmaEntity;
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
    public ResponseEntity<RequestAlunoDTO> getStudentByI(@PathVariable Long id) {
      AlunoEntity saved = alunoService.findByIdStudent(id);
        RequestAlunoDTO requestAlunoDTO = new RequestAlunoDTO(saved);
        return new ResponseEntity<>(requestAlunoDTO, HttpStatus.OK);

    }

    @PostMapping(value = "/created")
    public ResponseEntity<ResponseStudentDTO> createStudent(@RequestBody RequestAlunoDTO studentDTO) {

        return new ResponseEntity<>(alunoService.createdStudent(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<AlunoEntity> updateStudent(@RequestBody AlunoEntity student) {
        return new ResponseEntity<>(alunoService.updateStudent(student), HttpStatus.OK);
    }



    @DeleteMapping
    public ResponseEntity<AlunoEntity> deleteStudent(@RequestParam Long id) {
        AlunoEntity student = alunoService.findByIdStudent(id);
        if(student != null) {
            alunoService.deleteStudent(student);
        }
         return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<AlunoEntity>> getAllStudents() {
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

}
