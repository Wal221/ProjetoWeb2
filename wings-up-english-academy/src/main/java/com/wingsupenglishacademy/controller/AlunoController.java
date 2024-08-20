package com.wingsupenglishacademy.controller;

import com.wingsupenglishacademy.DTO.requests.RequestAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAlunoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseTurmaDTO;
import com.wingsupenglishacademy.model.AlunoEntity;
import com.wingsupenglishacademy.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@Tag(name = "aluno-controller", description = "Controller para gerenciamento de alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

//    @GetMapping(value = "/{id}")
//    public ResponseEntity<AlunoEntity> getStudentById(@PathVariable Long id) {
//        return new ResponseEntity<>(  studentService.findByIdStudent(id), HttpStatus.OK);
//    }

    @GetMapping(value = "/{id}", produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    @Operation(summary = "Busca um aluno pelo ID", description = "Retorna os detalhes do aluno com base no ID fornecido")
    @ApiResponse(description = "Sucesso", responseCode = "200", content = @Content(schema = @Schema(implementation = ResponseAlunoDTO.class)))
    public ResponseEntity<ResponseAlunoDTO> getStudentByI(@PathVariable Long id) {
        return new ResponseEntity<>(alunoService.findByIdStudent(id), HttpStatus.OK);

    }

    @PostMapping(value = "/created")
    @Operation(summary = "Cria um novo aluno", description = "Recebe os detalhes do aluno e o cria no sistema")
    @ApiResponse(description = "Aluno criado com sucesso", responseCode = "201", content = @Content(schema = @Schema(implementation = RequestAlunoDTO.class)))
    public ResponseEntity<ResponseAlunoDTO> createStudent(@RequestBody RequestAlunoDTO studentDTO) {

        return new ResponseEntity<>(alunoService.createdStudent(studentDTO), HttpStatus.CREATED);
    }


    @PutMapping(value = "/update")
    @Operation(summary = "Atualiza as informações de um aluno", description = "Atualiza os dados de um aluno existente")
    @ApiResponse(description = "Aluno atualizado com sucesso", responseCode = "200", content = @Content(schema = @Schema(implementation = AlunoEntity.class)))
    public ResponseEntity<AlunoEntity> updateStudent(@RequestBody AlunoEntity student) {
        return new ResponseEntity<>(alunoService.updateStudent(student), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um aluno", description = "Exclui um aluno do sistema pelo ID fornecido")
    @ApiResponse(description = "Aluno excluído com sucesso", responseCode = "200", content = @Content)
    public ResponseEntity<AlunoEntity> deleteStudent(@RequestParam Long id) {
        alunoService.deleteStudent(id);
        return ResponseEntity.ok().build();

    }

    @GetMapping("")
    @Operation(summary = "Finds a people", description = "Busca todos os Alunos", tags = {"aluno-controller"}, responses = {
            @ApiResponse(description = "Success", responseCode = "200",
                    content = @Content(schema = @Schema(implementation = ResponseAlunoDTO.class))
            ),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal  Error", responseCode = "500", content = @Content),
    })
    public ResponseEntity<List<ResponseAlunoDTO>> getAllStudents() {
        return ResponseEntity.ok().body(alunoService.findAllStudent());
    }

    @GetMapping("/material/{id}")
    @Operation(summary = "Faz download de material", description = "Permite o download de material didático associado a um aluno")
    @ApiResponse(description = "Material baixado com sucesso", responseCode = "200", content = @Content(schema = @Schema(implementation = ByteArrayResource.class)))
    public ResponseEntity<ByteArrayResource> download(@PathVariable Long id) {
        return alunoService.download(id);
    }

    @PostMapping("/matricula/{idTurma}")
    @Operation(summary = "Matrícula aluno em uma turma", description = "Matrícula um aluno em uma turma específica")
    @ApiResponse(description = "Aluno matriculado com sucesso", responseCode = "200", content = @Content(schema = @Schema(implementation = ResponseTurmaDTO.class)))
    public ResponseEntity<ResponseTurmaDTO> matriculaTurma(@RequestBody RequestAlunoDTO requestAlunoDTO, @PathVariable Long idTurma) {
        return new ResponseEntity<>(this.alunoService.matricularTurma(requestAlunoDTO, idTurma), HttpStatus.OK);
    }


    @PutMapping("/realiza-avaliaca/{idAluno}/{idProva}")
    @Operation(summary = "Realiza uma avaliação", description = "Marca uma avaliação como realizada por um aluno")
    @ApiResponse(description = "Avaliação realizada com sucesso", responseCode = "200", content = @Content)
    public ResponseEntity<String> realizarAvaliacao(@PathVariable Long idAluno, @PathVariable Long idProva) {
        this.alunoService.realizarProvar(idAluno, idProva);
        return ResponseEntity.ok("Avaliação realizada com sucesso!");
    }


}
