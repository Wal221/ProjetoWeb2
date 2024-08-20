package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.requests.RequestTurmaDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.model.TurmaEntity;
import com.wingsupenglishacademy.service.TurmaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
@Tag(name = "turma-controller", description = "Controller para gerenciamento de turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca uma turma pelo ID", description = "Retorna os detalhes da turma com base no ID fornecido")
    @ApiResponse(description = "Sucesso", responseCode = "200", content = @Content(schema = @Schema(implementation = ResponseTurmaDTO.class)))
    public ResponseEntity<ResponseTurmaDTO> getClassById(@PathVariable Long id) {
        return new ResponseEntity<>( turmaService.findByIdTurma(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Cria uma nova turma", description = "Recebe os detalhes da turma e a cria no sistema")
    @ApiResponse(description = "Turma criada com sucesso", responseCode = "201", content = @Content(schema = @Schema(implementation = RequestTurmaDTO.class)))
    public ResponseEntity<ResponseTurmaDTO> createClass(@RequestBody RequestTurmaDTO turmaEntity) {
        return new ResponseEntity<>(turmaService.createdTurma(turmaEntity), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update")
    @Operation(summary = "Atualiza as informações de uma turma", description = "Atualiza os dados de uma turma existente")
    @ApiResponse(description = "Turma atualizada com sucesso", responseCode = "200", content = @Content(schema = @Schema(implementation = RequestTurmaDTO.class)))
    public ResponseEntity<TurmaEntity> updateClass(@RequestBody TurmaEntity turmaEntity) {
        return new ResponseEntity<>(turmaService.update(turmaEntity), HttpStatus.OK);
    }

    @Operation(summary = "Busca todas as turmas", description = "Retorna a lista de todas as turmas cadastradas")
    @ApiResponse(description = "Sucesso", responseCode = "200", content = @Content(schema = @Schema(implementation = ResponseTurmaDTO.class)))
    @GetMapping(value = "/classes")
    public ResponseEntity<List<ResponseTurmaDTO>> getAllClasses() {
        return new ResponseEntity<>(turmaService.findAll(), HttpStatus.OK);
    }
}
