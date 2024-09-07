package com.senac.daniela.gerenciamentosalas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "planejamento_alocacao")
@JsonIgnoreProperties({"registro"})
public class PlanejamentoAlocacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planejamento_alocacao_id", nullable = false)
    private int id;

    @Column(name = "planejamento_alocacao_data")
    private LocalDate data;

    @Column(name = "planejamento_alocacao_hora_inicio")
    private java.sql.Time horaInicio;

    @Column(name = "planejamento_alocacao_hora_fim")
    private java.sql.Time horaFim;

    @Column(columnDefinition = "VARCHAR", name = "planejamento_alocacao_observacao", nullable = false)
    private String observacao;

    @Column(name = "planejamento_alocacao_status", nullable = false)
    private int status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ambiente_id", referencedColumnName = "ambiente_id")
    private Ambiente ambiente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="reserva_alocacao_id", nullable=false)
    private Reserva reserva;

    @OneToMany(mappedBy= "planejamentoAlocacao")
    private Set<Registro> registro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Set<Registro> getRegistro() {
        return registro;
    }

    public void setRegistro(Set<Registro> registro) {
        this.registro = registro;
    }
}
