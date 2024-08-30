package com.senac.daniela.gerenciamentosalas.dto.ambiente;

import jakarta.validation.constraints.NotBlank;

public class AmbienteCreateDTO {

    @NotBlank(message = "A descricao deve ser informada")
    private String descricao;

    @NotBlank(message = "A descricao deve ser informada")
    private int andar;

    @NotBlank(message = "A descricao deve ser informada")
    private String tipo;

    @NotBlank(message = "A descricao deve ser informada")
    private int numero;

    @NotBlank(message = "A descricao deve ser informada")
    private int capacidade;

    @NotBlank(message = "A descricao deve ser informada")
    private int status;

    public @NotBlank(message = "A descricao deve ser informada") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descricao deve ser informada") String descricao) {
        this.descricao = descricao;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(@NotBlank(message = "A descricao deve ser informada") int andar) {
        this.andar = andar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(@NotBlank(message = "A descricao deve ser informada") String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(@NotBlank(message = "A descricao deve ser informada") int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(@NotBlank(message = "A descricao deve ser informada") int capacidade) {
        this.capacidade = capacidade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "A descricao deve ser informada") int status) {
        this.status = status;
    }
}
