package com.senac.daniela.gerenciamentosalas.services;

import org.modelmapper.ModelMapper;
import com.senac.daniela.gerenciamentosalas.dto.ambiente.AmbienteDTO;
import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import com.senac.daniela.gerenciamentosalas.exceptions.AmbienteNotFoundException;
import com.senac.daniela.gerenciamentosalas.repository.AmbienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbienteService {

    private final AmbienteRepository ambienteRepository;

    private final ModelMapper modelMapper;

    public AmbienteService(AmbienteRepository ambienteRepository, ModelMapper modelMapper) {
        this.ambienteRepository = ambienteRepository;
        this.modelMapper = modelMapper;
    }

    public Ambiente createAmbiente(AmbienteDTO ambienteDTO) {
        Ambiente ambiente = new Ambiente();

        ambiente.setDescricao(ambienteDTO.getDescricao());
        ambiente.setAndar(ambienteDTO.getAndar());
        ambiente.setTipo(ambienteDTO.getTipo());
        ambiente.setNumero(ambienteDTO.getNumero());
        ambiente.setCapacidade(ambienteDTO.getCapacidade());
        ambiente.setStatus(ambienteDTO.getStatus());

        return ambienteRepository.save(ambiente);
    }

    public List<Ambiente> getAllAmbientes() {
        return ambienteRepository.findAll();

    }

    public Ambiente getAmbienteById(int id) {
        return ambienteRepository.getAmbienteAtivoById(id).orElseThrow(()-> new AmbienteNotFoundException("Ambiente não encontrado"));
    }

    public Ambiente updateAmbiente(int id, AmbienteDTO ambienteDTO) {
        Ambiente ambiente = this.getAmbienteById(id);

        modelMapper.map(ambienteDTO, ambiente);

        // Salvar o recurso atualizado
        return ambienteRepository.save(ambiente);

    }

}
