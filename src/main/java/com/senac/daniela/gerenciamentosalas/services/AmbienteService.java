package com.senac.daniela.gerenciamentosalas.services;

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

    public Ambiente createAmbiente(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }

    public List<Ambiente> getAllAmbientes() {
        return ambienteRepository.findAll();

    }

    public Ambiente getAmbienteById(int id) {
        return ambienteRepository.getAmbienteAtivoById(id).orElseThrow(()-> new AmbienteNotFoundException("Ambiente não encontrado"));
    }

}
