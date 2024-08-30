package com.senac.daniela.gerenciamentosalas.services;

import com.senac.daniela.gerenciamentosalas.dto.ambiente.AmbienteCreateDTO;
import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import com.senac.daniela.gerenciamentosalas.exceptions.AmbienteNotFoundException;
import com.senac.daniela.gerenciamentosalas.repository.AmbienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbienteService {

    private final AmbienteRepository ambienteRepository;

    public AmbienteService(AmbienteRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    public Ambiente createAmbiente(AmbienteCreateDTO ambienteCreateDTO) {
        Ambiente ambiente = new Ambiente();

        ambiente.setDescricao(ambienteCreateDTO.getDescricao());
        ambiente.setAndar(ambienteCreateDTO.getAndar());
        ambiente.setTipo(ambienteCreateDTO.getTipo());
        ambiente.setNumero(ambienteCreateDTO.getNumero());
        ambiente.setCapacidade(ambienteCreateDTO.getCapacidade());
        ambiente.setStatus(ambienteCreateDTO.getStatus());

        return ambienteRepository.save(ambiente);
    }

    public List<Ambiente> getAllAmbientes() {
        return ambienteRepository.findAll();

    }

    public Ambiente getAmbienteById(int id) {
        return ambienteRepository.getAmbienteAtivoById(id).orElseThrow(()-> new AmbienteNotFoundException("Ambiente não encontrado"));
    }

    public Ambiente updateAmbiente(Ambiente ambiente) {
        Ambiente ambienteAtual = this.getAmbienteById(ambiente.getId());

        ambienteAtual.setDescricao(ambiente.getDescricao());
        ambienteAtual.setAndar(ambiente.getAndar());
        ambienteAtual.setTipo(ambiente.getTipo());
        ambienteAtual.setNumero(ambiente.getNumero());
        ambienteAtual.setCapacidade(ambiente.getCapacidade());
        ambienteAtual.setStatus(ambiente.getStatus());

        return ambienteRepository.save(ambienteAtual);

    }

}
