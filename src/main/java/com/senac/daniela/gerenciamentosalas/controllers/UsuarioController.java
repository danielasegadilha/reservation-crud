package com.senac.daniela.gerenciamentosalas.controllers;

import com.senac.daniela.gerenciamentosalas.dto.AmbienteDTO;
import com.senac.daniela.gerenciamentosalas.dto.UsuarioDTO;
import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import com.senac.daniela.gerenciamentosalas.entities.Usuario;
import com.senac.daniela.gerenciamentosalas.exceptions.AmbienteNotFoundException;
import com.senac.daniela.gerenciamentosalas.exceptions.UsuarioNotFoundException;
import com.senac.daniela.gerenciamentosalas.services.AmbienteService;
import com.senac.daniela.gerenciamentosalas.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuario = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> getAmbienteById(@PathVariable int id) {
        try {
            Usuario usuario = usuarioService.getUsuarioById(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (UsuarioNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Usuario> createUsuario(@RequestParam Integer criadorId, @RequestBody UsuarioDTO usuarioDTO) {
        try {
            Usuario novoUsuario = usuarioService.createUsuario(criadorId, usuarioDTO);;
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (UsuarioNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody UsuarioDTO usuarioDTO) {
        Usuario atualizarUsuario = usuarioService.updateUsuario(id, usuarioDTO);
        return new ResponseEntity<>(atualizarUsuario, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Ambiente> deleteUsuario(@PathVariable int id) {
        usuarioService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
