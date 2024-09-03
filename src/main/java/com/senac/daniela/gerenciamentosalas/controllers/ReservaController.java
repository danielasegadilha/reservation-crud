package com.senac.daniela.gerenciamentosalas.controllers;

import com.senac.daniela.gerenciamentosalas.dto.ReservaDTO;
import com.senac.daniela.gerenciamentosalas.entities.Reserva;
import com.senac.daniela.gerenciamentosalas.exceptions.ReservaNotFoundException;
import com.senac.daniela.gerenciamentosalas.services.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reserva = reservaService.getAllReservas();
        return ResponseEntity.ok(reserva);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable int id) {
        try {
            Reserva reserva = reservaService.getReservaById(id);
            return new ResponseEntity<>(reserva, HttpStatus.OK);
        } catch (ReservaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Reserva> createReserva(@RequestParam Integer criadorId, @RequestBody ReservaDTO reservaDTO) {
        try {
            Reserva novaReserva = reservaService.createReserva(criadorId, reservaDTO);;
            return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
        } catch (ReservaNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable int id, @RequestBody ReservaDTO reservaDTO) {
        Reserva atualizarReserva = reservaService.updateReserva(id, reservaDTO);
        return new ResponseEntity<>(atualizarReserva, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Reserva> deleteReserva(@PathVariable int id) {
        reservaService.deleteReserva(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
