package com.senac.daniela.gerenciamentosalas.entities;

import java.sql.Time;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva_alocacao")
@JsonIgnoreProperties({"planejamentoAlocacao"})
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_alocacao_id", nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy= "reserva")
    private Set<PlanejamentoAlocacao> planejamentoAlocacao;

    @Column(columnDefinition = "VARCHAR", name = "reserva_alocacao_justificativa", nullable = false)
    private String justificativa;

    @Column(name = "reserva_alocacao_data", nullable = false)
    private LocalDate data;

    @Column(name = "reserva_alocacao_hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "reserva_alocacao_hora_fim", nullable = false)
    private LocalTime horaFim;

    @Column(name = "reserva_alocacao_status", nullable = false)
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public  void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<PlanejamentoAlocacao> getPlanejamentoAlocacao() {
        return planejamentoAlocacao;
    }

    public void setPlanejamentoAlocacao(Set<PlanejamentoAlocacao> planejamentoAlocacao) {
        this.planejamentoAlocacao = planejamentoAlocacao;
    }

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

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
