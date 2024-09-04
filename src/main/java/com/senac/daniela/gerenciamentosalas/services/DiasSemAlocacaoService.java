package com.senac.daniela.gerenciamentosalas.services;


import com.senac.daniela.gerenciamentosalas.dto.DiasSemAlocacaoDTO;
import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import com.senac.daniela.gerenciamentosalas.entities.DiasSemAlocacao;
import com.senac.daniela.gerenciamentosalas.exceptions.DiasSemAlocacaoNotFoundException;
import com.senac.daniela.gerenciamentosalas.repository.DiasSemAlocacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiasSemAlocacaoService {

    private final DiasSemAlocacaoRepository diasSemAlocacaoRepository;

    private final AmbienteService ambienteService;

    private final ModelMapper modelMapper;

    public DiasSemAlocacaoService(DiasSemAlocacaoRepository diasSemAlocacaoRepository, AmbienteService ambienteService, ModelMapper modelMapper) {
        this.diasSemAlocacaoRepository = diasSemAlocacaoRepository;
        this.ambienteService = ambienteService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public DiasSemAlocacao createDiasSemAlocacao(Integer ambienteId, DiasSemAlocacaoDTO diaSemAlocacaoDTO) {
        DiasSemAlocacao diaSemAlocacao = new DiasSemAlocacao();

        Ambiente ambiente = ambienteService.getAmbienteById(ambienteId);
        diaSemAlocacao.setAmbiente(ambiente);

        modelMapper.map(diaSemAlocacaoDTO, diaSemAlocacao);

        return diasSemAlocacaoRepository.save(diaSemAlocacao);
    }

    public List<DiasSemAlocacao> getAllDiasSemAlocacao() {
        return diasSemAlocacaoRepository.getAllDiasSemAlocacao();
    }

    public DiasSemAlocacao getDiasSemAlocacaoById(int id) {
        return diasSemAlocacaoRepository.getDiasSemAlocacaoAtivaById(id).orElseThrow(()-> new DiasSemAlocacaoNotFoundException("Dia sem alocação não encontrado"));
    }

    @Transactional
    public DiasSemAlocacao updateDiasSemAlocacao(int id, DiasSemAlocacaoDTO diaSemAlocacaoDTO) {
        DiasSemAlocacao diaSemAlocacao = this.getDiasSemAlocacaoById(id);
        modelMapper.map(diaSemAlocacaoDTO, diaSemAlocacao);

        return diasSemAlocacaoRepository.save(diaSemAlocacao);

    }

    public void deleteDiasSemAlocacao(int id) {
        this.getDiasSemAlocacaoById(id);
        diasSemAlocacaoRepository.markAsDeleteDiasSemAlocacao(id);
    }


}
