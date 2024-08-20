package com.wingsupenglishacademy.controller;


import com.wingsupenglishacademy.DTO.requests.RequestAvalicaoDTO;
import com.wingsupenglishacademy.DTO.responses.ResponseAvaliacaDTO;
import com.wingsupenglishacademy.model.AvaliacaoEntity;
import com.wingsupenglishacademy.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacao")
@Tag(name = "avaliacao-controller", description = "Controller para gerenciamento de avaliações")
public class AvalicaoController {

    @Autowired
    AvaliacaoService avaliacaoService;

    @PostMapping(value="/created-avaliacao" , produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })

    @Operation(summary = "Cria uma nova avaliação", description = "Recebe os detalhes da avaliação e a cria no sistema")
    @ApiResponse(description = "Avaliação criada com sucesso", responseCode = "201", content = @Content(schema = @Schema(implementation = ResponseAvaliacaDTO.class)))
    public ResponseEntity<ResponseAvaliacaDTO> createdAvalicao(@RequestBody RequestAvalicaoDTO avaliacaoDTO){
        return new ResponseEntity<>(avaliacaoService.createdAvalicao(avaliacaoDTO), HttpStatus.CREATED);

    }

    @PostMapping("/salvar")
    @Operation(summary = "Salva uma entidade de avaliação", description = "Recebe uma entidade de avaliação e a salva no sistema")
    @ApiResponse(description = "Entidade de avaliação salva com sucesso", responseCode = "201", content = @Content(schema = @Schema(implementation = AvaliacaoEntity.class)))
    public ResponseEntity<AvaliacaoEntity> saveAvalicao (@RequestBody AvaliacaoEntity avaliacaoEntity){
        return new ResponseEntity<>(avaliacaoService.saveAvaliacaoEntity(avaliacaoEntity), HttpStatus.CREATED);
    }
}
