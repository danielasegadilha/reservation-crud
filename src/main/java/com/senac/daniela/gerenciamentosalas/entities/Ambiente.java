package com.senac.daniela.gerenciamentosalas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ambiente")
@JsonIgnoreProperties({"planejamentoAlocacao", "registro", "diasSemAlocacao"})
public class Ambiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ambiente_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int id;

    @OneToOne(mappedBy = "ambiente")
    private PlanejamentoAlocacao planejamentoAlocacao;

    @OneToOne(mappedBy = "ambiente")
    private Registro registro;

    @OneToOne(mappedBy = "ambiente")
    private DiasSemAlocacao diasSemAlocacao;

    @Column(columnDefinition = "VARCHAR", name = "ambiente_descricao", nullable = false)
    private String descricao;

    @Column(name = "ambiente_andar", nullable = false)
    private int andar;

    @Column(columnDefinition = "VARCHAR", name = "ambiente_tipo", nullable = false)
    private String tipo;

    @Column(name = "ambiente_numero_pcs", nullable = false)
    private int numero;

    @Column(name = "ambiente_capacidade", nullable = false)
    private int capacidade;

    @Column(name = "ambiente_status", nullable = false)
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlanejamentoAlocacao getPlanejamentoAlocacao() {
        return planejamentoAlocacao;
    }

    public void setPlanejamentoAlocacao(PlanejamentoAlocacao planejamentoAlocacao) {
        this.planejamentoAlocacao = planejamentoAlocacao;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public DiasSemAlocacao getDiasSemAlocacao() {
        return diasSemAlocacao;
    }

    public void setDiasSemAlocacao(DiasSemAlocacao diasSemAlocacao) {
        this.diasSemAlocacao = diasSemAlocacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
