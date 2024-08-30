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

    private final ModelMapper modelMapper;

    public ReservaService(ReservaRepository reservaRepository, ModelMapper modelMapper) {
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Reserva createReserva(Integer usuarioId, ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();

        Usuario usuario = UsuarioService.getUsuarioById(usuarioId);
        Reserva.setUsuario(usuario);

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
    public Reserva updateUsuario(int id, ReservaDTO reservaDTO) {
        Reserva reserva = this.getReservaById(id);
        modelMapper.map(reservaDTO, reserva);

        return reservaRepository.save(reserva);

    }

    public void deleteUsuario(int id) {
        this.getReservaById(id);
        reservaRepository.markAsDeleteReserva(id);
    }
}
