package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.requests.RequestProfessorDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTeacherDTO;
import com.wingsupenglishacademy.model.ProfessorEntity;
import com.wingsupenglishacademy.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/teacher")
public class ProfessorController {

    @Autowired
    private ProfessorService ProfessorService;

    @GetMapping(value = "/DTO/{id}")
    public ResponseEntity<ResponseTeacherDTO> findTeacherByIdDTO(@PathVariable Long id) {
        return new ResponseEntity<>(  ProfessorService.findByIdTeacher(id), HttpStatus.OK);
    }


    @PostMapping(value = "/create-professor")
    public ResponseEntity<ResponseTeacherDTO> createTeacher(@RequestBody RequestProfessorDTO teacher) {
        return new ResponseEntity<>(ProfessorService.createdTeacher(teacher), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update")
    public ResponseEntity<ProfessorEntity> updateTeacher(@RequestBody ProfessorEntity student) {
        return new ResponseEntity<>(ProfessorService.updateTeacher(student), HttpStatus.OK);
    }



    @DeleteMapping
    public ResponseEntity<ResponseTeacherDTO> deleteTeacher(@PathVariable Long id) {
        ResponseTeacherDTO student = ProfessorService.findByIdTeacher(id);
        if(student != null) {
            ProfessorService.deleteTeacher(id);
        }
        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/teaches")
    public ResponseEntity<List<ProfessorEntity>> getAllStudents() {
        return ResponseEntity.ok().body(ProfessorService.getAllTeachers());
    }


}
