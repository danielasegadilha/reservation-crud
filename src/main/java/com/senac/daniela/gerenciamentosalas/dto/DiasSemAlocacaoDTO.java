package com.senac.daniela.gerenciamentosalas.dto;

import com.senac.daniela.gerenciamentosalas.entities.Ambiente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;
import java.time.LocalTime;

public class DiasSemAlocacaoDTO {

    private LocalDate data;

    private int diaSemana;

    private LocalTime horarioInicio;

    private LocalTime horarioFim;

    private int status;

    private int ambiente;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(int ambiente) {
        this.ambiente = ambiente;
    }
}
