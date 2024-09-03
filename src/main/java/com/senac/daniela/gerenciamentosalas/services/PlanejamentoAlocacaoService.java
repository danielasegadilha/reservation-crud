package com.senac.daniela.gerenciamentosalas.services;

import com.senac.daniela.gerenciamentosalas.dto.PlanejamentoAlocacaoDTO;
import com.senac.daniela.gerenciamentosalas.entities.*;
import com.senac.daniela.gerenciamentosalas.repository.PlanejamentoAlocacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlanejamentoAlocacaoService {

    private final PlanejamentoAlocacaoRepository planejamentoAlocacaoRepository;

    private UsuarioService usuarioService;

    private AmbienteService ambienteService;

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
    public Registro createPlanejamentoAlocacao(PlanejamentoAlocacaoDTO planejamentoAlocacaoDTO) {
        PlanejamentoAlocacao planejamentoAlocacao = new PlanejamentoAlocacao();

        Usuario usuario = usuarioService.getUsuarioById(planejamentoAlocacaoDTO.getUsuario());
        Ambiente ambiente = ambienteService.getAmbienteById(planejamentoAlocacaoDTO.getAmbiente());
        Reserva reserva = reservaService.getReservaById(planejamentoAlocacaoDTO.getReserva());
        PlanejamentoAlocacao.setUsuario(usuario);
        PlanejamentoAlocacao.setAmbiente(ambiente);
        PlanejamentoAlocacao.setReserva(reserva);

        modelMapper.map(planejamentoAlocacaoDTO, planejamentoAlocacao);

        return planejamentoAlocacaoRepository.save(planejamentoAlocacao);
    }

    public List<PlanejamentoAlocacao> getAllPlanejamentoAlocacoes() {
        return planejamentoAlocacaoRepository.getAllPlanejamentoAlocacoes();
    }

    public PlanejamentoAlocacao getPlanejamentoAlocacaoById(int id) {
        return planejamentoAlocacaoRepository.getPlanejamentoAlocacaoAtivoById(id).orElseThrow(()-> new RegistroNotFoundException("Registro não encontrado"));
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
