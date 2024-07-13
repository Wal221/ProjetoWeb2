package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.model.ClassEntity;
import com.wingsupenglishacademy.repository.ClassRepository;
import com.wingsupenglishacademy.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClassEntity> getClassById(@PathVariable Long id) {
        return new ResponseEntity<>( classService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassEntity> createClass(@RequestBody ClassEntity classEntity) {
        return new ResponseEntity<>(classService.save(classEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<ClassEntity> updateClass(@RequestBody ClassEntity classEntity) {
        return new ResponseEntity<>(classService.update(classEntity), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<ClassEntity> deleteClass(@RequestBody ClassEntity classEntity) {
        classService.delete(classEntity);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/classes")
    public ResponseEntity<List<ClassEntity>> getAllClasses() {
        return new ResponseEntity<>(classService.findAll(), HttpStatus.OK);
    }
}
