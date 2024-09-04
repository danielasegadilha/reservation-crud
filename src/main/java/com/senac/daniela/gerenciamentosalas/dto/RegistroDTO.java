package com.senac.daniela.gerenciamentosalas.dto;

import com.senac.daniela.gerenciamentosalas.entities.PlanejamentoAlocacao;

import java.time.LocalDateTime;

public class RegistroDTO {

    private LocalDateTime horaEntrada;

    private LocalDateTime horaSaida;

    private int status;

    private String observacao;

    private int planejamentoAlocacaoId;

    private int usuarioRetiradaId;

    private int usuarioDevolucaoId;

    private int ambienteId;

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getPlanejamentoAlocacaoId() {
        return planejamentoAlocacaoId;
    }

    public void setPlanejamentoAlocacaoId(int planejamentoAlocacaoId) {
        this.planejamentoAlocacaoId = planejamentoAlocacaoId;
    }

    public int getUsuarioRetiradaId() {
        return usuarioRetiradaId;
    }

    public void setUsuarioRetiradaId(int usuarioRetiradaId) {
        this.usuarioRetiradaId = usuarioRetiradaId;
    }

    public int getUsuarioDevolucaoId() {
        return usuarioDevolucaoId;
    }

    public void setUsuarioDevolucaoId(int usuarioDevolucaoId) {
        this.usuarioDevolucaoId = usuarioDevolucaoId;
    }

    public int getAmbienteId() {
        return ambienteId;
    }

    public void setAmbienteId(int ambienteId) {
        this.ambienteId = ambienteId;
    }
}
