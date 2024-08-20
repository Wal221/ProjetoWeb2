package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.repository.DTO.requests.RequestTurmaDTO;
import com.wingsupenglishacademy.repository.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.model.TurmaEntity;
import com.wingsupenglishacademy.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseTurmaDTO> getClassById(@PathVariable Long id) {
        return new ResponseEntity<>( turmaService.findByIdTurma(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseTurmaDTO> createClass(@RequestBody RequestTurmaDTO turmaEntity) {
        return new ResponseEntity<>(turmaService.createdTurma(turmaEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<TurmaEntity> updateClass(@RequestBody TurmaEntity turmaEntity) {
        return new ResponseEntity<>(turmaService.update(turmaEntity), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<TurmaEntity> deleteClass(@RequestBody TurmaEntity turmaEntity) {
        turmaService.delete(turmaEntity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/classes")
    public ResponseEntity<List<ResponseTurmaDTO>> getAllClasses() {
        return new ResponseEntity<>(turmaService.findAll(), HttpStatus.OK);
    }
}
