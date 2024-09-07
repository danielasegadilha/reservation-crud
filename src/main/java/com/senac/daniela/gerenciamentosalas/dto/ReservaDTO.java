package com.senac.daniela.gerenciamentosalas.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {

    private String justificativa;

    private LocalDate data;

    private java.sql.Time horaInicio;

    private java.sql.Time horaFim;

    private int status;


    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public java.sql.Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(java.sql.Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public java.sql.Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(java.sql.Time horaFim) {
        this.horaFim = horaFim;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
