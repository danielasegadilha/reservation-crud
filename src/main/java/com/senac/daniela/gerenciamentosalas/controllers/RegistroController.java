package com.senac.daniela.gerenciamentosalas.controllers;

import com.senac.daniela.gerenciamentosalas.dto.RegistroDTO;
import com.senac.daniela.gerenciamentosalas.entities.Registro;
import com.senac.daniela.gerenciamentosalas.exceptions.RegistroNotFoundException;
import com.senac.daniela.gerenciamentosalas.services.RegistroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/registro")
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @GetMapping
    public ResponseEntity<List<Registro>> getAllRegistros() {
        List<Registro> registro = registroService.getAllRegistros();
        return ResponseEntity.ok(registro);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Registro> getRegistroById(@PathVariable int id) {
        try {
            Registro registro = registroService.getRegistroById(id);
            return new ResponseEntity<>(registro, HttpStatus.OK);
        } catch (RegistroNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Registro> createRegistro(@RequestBody RegistroDTO registroDTO) {
        try {
            Registro novoRegistro = registroService.createRegistro(registroDTO);;
            return new ResponseEntity<>(novoRegistro, HttpStatus.CREATED);
        } catch (RegistroNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Registro> updateRegistro(@PathVariable int id, @RequestBody RegistroDTO registroDTO) {
        Registro atualizarRegistro = registroService.updateRegistro(id, registroDTO);
        return new ResponseEntity<>(atualizarRegistro, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Registro> deleteRegistro(@PathVariable int id) {
        registroService.deleteRegistro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
