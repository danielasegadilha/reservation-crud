package com.senac.daniela.gerenciamentosalas.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaDTO {

    private String justificativa;

    private LocalDate data;

    private LocalTime horaInicio;

    private LocalTime horaFim;

    private int status;

    private int usuarioId;
}
