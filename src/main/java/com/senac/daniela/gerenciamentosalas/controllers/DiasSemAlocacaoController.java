package com.senac.daniela.gerenciamentosalas.controllers;

import com.senac.daniela.gerenciamentosalas.dto.DiasSemAlocacaoDTO;
import com.senac.daniela.gerenciamentosalas.entities.DiasSemAlocacao;
import com.senac.daniela.gerenciamentosalas.entities.Reserva;
import com.senac.daniela.gerenciamentosalas.exceptions.DiasSemAlocacaoNotFoundException;
import com.senac.daniela.gerenciamentosalas.services.DiasSemAlocacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/dias-sem-alocacao")
public class DiasSemAlocacaoController {

    private final DiasSemAlocacaoService diasSemAlocacaoService;

    public DiasSemAlocacaoController(DiasSemAlocacaoService diasSemAlocacaoService) {
        this.diasSemAlocacaoService = diasSemAlocacaoService;
    }

    @GetMapping
    public ResponseEntity<List<DiasSemAlocacao>> getAllDiasSemAlocacao() {
        List<DiasSemAlocacao> diaSemAlocacao = diasSemAlocacaoService.getAllDiasSemAlocacao();
        return ResponseEntity.ok(diaSemAlocacao);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<DiasSemAlocacao> getDiaSemAlocacaoById(@PathVariable int id) {
        try {
            DiasSemAlocacao diaSemAlocacao = diasSemAlocacaoService.getDiasSemAlocacaoById(id);
            return new ResponseEntity<>(diaSemAlocacao, HttpStatus.OK);
        } catch (DiasSemAlocacaoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<DiasSemAlocacao> createDiasSemAlocacao(@RequestParam Integer ambienteId, @RequestBody DiasSemAlocacaoDTO diaSemAlocacaoDTO) {
        try {
            DiasSemAlocacao novoDiaSemAlocacao = diasSemAlocacaoService.createDiasSemAlocacao(ambienteId, diaSemAlocacaoDTO);;
            return new ResponseEntity<>(novoDiaSemAlocacao, HttpStatus.CREATED);
        } catch (DiasSemAlocacaoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<DiasSemAlocacao> updateDiasSemAlocacao(@PathVariable int id, @RequestBody DiasSemAlocacaoDTO diaSemAlocacaoDTO) {
        DiasSemAlocacao atualizarReserva = diasSemAlocacaoService.updateDiasSemAlocacao(id, diaSemAlocacaoDTO);
        return new ResponseEntity<>(atualizarReserva, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<DiasSemAlocacao> deleteDiasSemAlocacao(@PathVariable int id) {
        diasSemAlocacaoService.deleteDiasSemAlocacao(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
