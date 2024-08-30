package com.senac.daniela.gerenciamentosalas.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {

    private String nome;

    private String matricula;

    private int tipo;

    @NotBlank(message = "O status deve ser informada")
    private int status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "O status deve ser informada") int status) {
        this.status = status;
    }
}
