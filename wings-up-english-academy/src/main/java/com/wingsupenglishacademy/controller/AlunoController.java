package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.RequestStudentDTO;
import com.wingsupenglishacademy.DTO.ResponseStudentDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<RequestStudentDTO> getStudentByI(@PathVariable Long id) {
      AlunoEntity saved = alunoService.findByIdStudent(id);
        RequestStudentDTO requestStudentDTO = new RequestStudentDTO(saved);
        return new ResponseEntity<>(requestStudentDTO, HttpStatus.OK);

    }
   


    @PostMapping(value = "/created")
    public ResponseEntity<ResponseStudentDTO> createStudent(@RequestBody RequestStudentDTO studentDTO) {

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


}
