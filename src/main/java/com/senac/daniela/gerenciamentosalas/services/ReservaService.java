package com.senac.daniela.gerenciamentosalas.services;

import com.senac.daniela.gerenciamentosalas.dto.ReservaDTO;
import com.senac.daniela.gerenciamentosalas.entities.Reserva;
import com.senac.daniela.gerenciamentosalas.entities.Usuario;
import com.senac.daniela.gerenciamentosalas.exceptions.ReservaNotFoundException;
import com.senac.daniela.gerenciamentosalas.repository.ReservaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    private UsuarioService usuarioService;

    private final ModelMapper modelMapper;

    public ReservaService(ReservaRepository reservaRepository, UsuarioService usuarioService, ModelMapper modelMapper) {
        this.reservaRepository = reservaRepository;
        this.usuarioService = usuarioService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Reserva createReserva(Integer usuarioId, ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();

        Usuario usuario = usuarioService.getUsuarioById(usuarioId);
        reserva.setUsuario(usuario);


        modelMapper.map(reservaDTO, reserva);

        return reservaRepository.save(reserva);
    }

    public List<Reserva> getAllReservas() {
        return reservaRepository.getAllReservas();
    }

    public Reserva getReservaById(int id) {
        return reservaRepository.getReservaAtivaById(id).orElseThrow(()-> new ReservaNotFoundException("Reserva não encontrada"));
    }

    @Transactional
    public Reserva updateReserva(int id, ReservaDTO reservaDTO) {
        Reserva reserva = this.getReservaById(id);
        modelMapper.map(reservaDTO, reserva);

        return reservaRepository.save(reserva);

    }

    public void deleteReserva(int id) {
        this.getReservaById(id);
        reservaRepository.markAsDeleteReserva(id);
    }
}
