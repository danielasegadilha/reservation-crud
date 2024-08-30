package com.senac.daniela.gerenciamentosalas.controllers;

import com.senac.daniela.gerenciamentosalas.dto.ambiente.AmbienteDTO;
import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import com.senac.daniela.gerenciamentosalas.exceptions.AmbienteNotFoundException;
import com.senac.daniela.gerenciamentosalas.services.AmbienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/ambiente")
public class AmbienteController {
    private final AmbienteService ambienteService;

    public AmbienteController(AmbienteService ambienteService) {
        this.ambienteService = ambienteService;
    }

    @GetMapping
    public ResponseEntity<List<Ambiente>> getAllAmbientes() {
        List<Ambiente> ambiente = ambienteService.getAllAmbientes();
        return ResponseEntity.ok(ambiente);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Ambiente> getAmbienteById(@PathVariable int id) {
        try {
            Ambiente ambiente = ambienteService.getAmbienteById(id);
            return new ResponseEntity<>(ambiente, HttpStatus.OK);
        } catch (AmbienteNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Ambiente> createAmbiente(@RequestBody AmbienteDTO ambienteDTO) {

        Ambiente novoAmbiente = ambienteService.createAmbiente(ambienteDTO);;
        return new ResponseEntity<>(novoAmbiente, HttpStatus.CREATED);
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Ambiente> updateAmbiente(@PathVariable int id, @RequestBody AmbienteDTO ambienteDTO) {
        Ambiente atualizarAmbiente = ambienteService.updateAmbiente(id, ambienteDTO);
        return new ResponseEntity<>(atualizarAmbiente, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Ambiente> deleteAmbiente(@PathVariable int id) {
        ambienteService.deleteAmbiente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
