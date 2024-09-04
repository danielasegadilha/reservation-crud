package com.senac.daniela.gerenciamentosalas.controllers;

import com.senac.daniela.gerenciamentosalas.dto.PlanejamentoAlocacaoDTO;
import com.senac.daniela.gerenciamentosalas.entities.PlanejamentoAlocacao;
import com.senac.daniela.gerenciamentosalas.exceptions.PlanejamentoAlocacaoNotFoundException;
import com.senac.daniela.gerenciamentosalas.services.PlanejamentoAlocacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/planejamento")
public class PlanejamentoAlocacaoController {

    private final PlanejamentoAlocacaoService planejamentoAlocacaoService;

    public PlanejamentoAlocacaoController(PlanejamentoAlocacaoService planejamentoAlocacaoService) {
        this.planejamentoAlocacaoService = planejamentoAlocacaoService;
    }

    @GetMapping
    public ResponseEntity<List<PlanejamentoAlocacao>> getAllPlanejamentoAlocacoes() {
        List<PlanejamentoAlocacao> planejamentoAlocacao = planejamentoAlocacaoService.getAllPlanejamentoAlocacoes();
        return ResponseEntity.ok(planejamentoAlocacao);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PlanejamentoAlocacao> getRegistroById(@PathVariable int id) {
        try {
            PlanejamentoAlocacao planejamentoAlocacao = planejamentoAlocacaoService.getPlanejamentoAlocacaoById(id);
            return new ResponseEntity<>(planejamentoAlocacao, HttpStatus.OK);
        } catch (PlanejamentoAlocacaoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<PlanejamentoAlocacao> createPlanejamentoAlocacao(@RequestBody PlanejamentoAlocacaoDTO planejamentoAlocacaoDTO) {
        try {
            PlanejamentoAlocacao novoPlanejamentoAlocacao = planejamentoAlocacaoService.createPlanejamentoAlocacao(planejamentoAlocacaoDTO);;
            return new ResponseEntity<>(novoPlanejamentoAlocacao, HttpStatus.CREATED);
        } catch (PlanejamentoAlocacaoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<PlanejamentoAlocacao> updatePlanejamentoAlocacao(@PathVariable int id, @RequestBody PlanejamentoAlocacaoDTO planejamentoAlocacaoDTO) {
        PlanejamentoAlocacao atualizarPlanejamentoAlocacao = planejamentoAlocacaoService.updatePlanejamentoAlocacao(id, planejamentoAlocacaoDTO);
        return new ResponseEntity<>(atualizarPlanejamentoAlocacao, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<PlanejamentoAlocacao> deletePlanejamentoAlocacao(@PathVariable int id) {
        planejamentoAlocacaoService.deletePlanejamentoAlocacao(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
