package com.senac.daniela.gerenciamentosalas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(name = "planejamento_alocacao")
public class PlanejamentoAlocacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planejamento_alocacao_id", nullable = false)
    private int id;

    @Column(columnDefinition = "DATE", name = "planejamento_alocacao_data", nullable = false)
    private LocalDate data;

    @Column(columnDefinition = "TIME", name = "planejamento_alocacao_hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(columnDefinition = "TIME", name = "planejamento_alocacao_hora_fim", nullable = false)
    private LocalTime horaFim;

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
