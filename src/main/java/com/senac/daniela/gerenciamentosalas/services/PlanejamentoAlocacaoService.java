package com.senac.daniela.gerenciamentosalas.services;

import com.senac.daniela.gerenciamentosalas.dto.PlanejamentoAlocacaoDTO;
import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import com.senac.daniela.gerenciamentosalas.entities.PlanejamentoAlocacao;
import com.senac.daniela.gerenciamentosalas.entities.Reserva;
import com.senac.daniela.gerenciamentosalas.entities.Usuario;
import com.senac.daniela.gerenciamentosalas.exceptions.PlanejamentoAlocacaoNotFoundException;
import com.senac.daniela.gerenciamentosalas.repository.PlanejamentoAlocacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanejamentoAlocacaoService {

    private final PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository;

    private final UsuarioService usuarioService;

    private final AmbienteService ambienteService;

    private final ReservaService reservaService;

    private final ModelMapper modelMapper;

    public PlanejamentoAlocacaoService(PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository, UsuarioService usuarioService, AmbienteService ambienteService, ReservaService reservaService, ModelMapper modelMapper) {
        this.planejamentoAlocacaoRepository = planejamentoAlocacaoRepository;
        this.usuarioService = usuarioService;
        this.ambienteService = ambienteService;
        this.reservaService = reservaService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public PlanejamentoAlocacao createPlanejamentoAlocacao(PlanejamentoAlocacaoDTO planejamentoAlocacaoDTO) {
        PlanejamentoAlocacao planejamentoAlocacao = new PlanejamentoAlocacao();

        planejamentoAlocacao.setData(planejamentoAlocacaoDTO.getData());
        planejamentoAlocacao.setHoraInicio(planejamentoAlocacaoDTO.getHoraInicio());
        planejamentoAlocacao.setHoraFim(planejamentoAlocacaoDTO.getHoraFim());
        planejamentoAlocacao.setObservacao(planejamentoAlocacaoDTO.getObservacao());
        planejamentoAlocacao.setStatus(planejamentoAlocacaoDTO.getStatus());

        Usuario usuario = usuarioService.getUsuarioById(planejamentoAlocacaoDTO.getUsuarioId());
        Ambiente ambiente = ambienteService.getAmbienteById(planejamentoAlocacaoDTO.getAmbienteId());
        Reserva reserva = reservaService.getReservaById(planejamentoAlocacaoDTO.getReservaId());
        planejamentoAlocacao.setUsuario(usuario);
        planejamentoAlocacao.setAmbiente(ambiente);
        planejamentoAlocacao.setReserva(reserva);

        return planejamentoAlocacaoRepository.save(planejamentoAlocacao);
    }

    public List<PlanejamentoAlocacao> getAllPlanejamentoAlocacoes() {
        return planejamentoAlocacaoRepository.getAllPlanejamentoAlocacoes();
    }

    public PlanejamentoAlocacao getPlanejamentoAlocacaoById(int id) {
        return planejamentoAlocacaoRepository.getPlanejamentoAlocacaoAtivoById(id).orElseThrow(()-> new PlanejamentoAlocacaoNotFoundException("Planejamento não encontrado"));
    }

    @Transactional
    public PlanejamentoAlocacao updatePlanejamentoAlocacao(int id, PlanejamentoAlocacaoDTO planejamentoAlocacaoDTO) {
        PlanejamentoAlocacao planejamentoAlocacao = this.getPlanejamentoAlocacaoById(id);
        modelMapper.map(planejamentoAlocacaoDTO, planejamentoAlocacao);

        return planejamentoAlocacaoRepository.save(planejamentoAlocacao);

    }

    public void deletePlanejamentoAlocacao(int id) {
        this.getPlanejamentoAlocacaoById(id);
        planejamentoAlocacaoRepository.markAsDeletePlanejamentoAlocacao(id);
    }
}
