package com.senac.daniela.gerenciamentosalas.services;

import org.modelmapper.ModelMapper;
import com.senac.daniela.gerenciamentosalas.dto.AmbienteDTO;
import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import com.senac.daniela.gerenciamentosalas.exceptions.AmbienteNotFoundException;
import com.senac.daniela.gerenciamentosalas.repository.AmbienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AmbienteService {

    private final AmbienteRepository ambienteRepository;

    private final ModelMapper modelMapper;

    public AmbienteService(AmbienteRepository ambienteRepository, ModelMapper modelMapper) {
        this.ambienteRepository = ambienteRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public Ambiente createAmbiente(AmbienteDTO ambienteDTO) {
        Ambiente ambiente = new Ambiente();
        modelMapper.map(ambienteDTO, ambiente);

        return ambienteRepository.save(ambiente);
    }

    public List<Ambiente> getAllAmbientes() {
        return ambienteRepository.getAllAmbientes();
    }

    public Ambiente getAmbienteById(int id) {
        return ambienteRepository.getAmbienteAtivoById(id).orElseThrow(()-> new AmbienteNotFoundException("Ambiente não encontrado"));
    }

    @Transactional
    public Ambiente updateAmbiente(int id, AmbienteDTO ambienteDTO) {
        Ambiente ambiente = this.getAmbienteById(id);
        modelMapper.map(ambienteDTO, ambiente);

        return ambienteRepository.save(ambiente);

    }

    public void deleteAmbiente(int id) {
        Ambiente ambiente = this.getAmbienteById(id);
        ambienteRepository.markAsDeleteAmbiente(id);
    }

}
