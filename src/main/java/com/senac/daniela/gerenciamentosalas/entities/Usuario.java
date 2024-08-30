package com.senac.daniela.gerenciamentosalas.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "usuario")
@JsonIgnoreProperties({"reserva", "planejamentoAlocacao", "registro", "usuarios"})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false)
    private int id;

    @OneToOne(mappedBy = "usuario")
    private Reserva reserva;

    @OneToOne(mappedBy = "usuario")
    private PlanejamentoAlocacao planejamentoAlocacao;

    @OneToOne(mappedBy = "usuarioRetirada")
    private Registro registro;

    @Column(columnDefinition = "VARCHAR", name = "usuario_nome")
    private String nome;

    @Column(columnDefinition = "VARCHAR", name = "usuario_matricula")
    private String matricula;

    @Column(name = "usuario_tipo")
    private int tipo;

    @Column(name = "usuario_status", nullable = false)
    private int status;

    @Column(columnDefinition = "DATETIME", name = "usuario_log_data_criacao", nullable = false, updatable = false)
    private LocalDateTime logDataCriacao;

    @ManyToOne
    @JoinColumn(name="usuario_lod_responsavel_id")
    private Usuario responsavelId;

    @OneToMany(mappedBy = "responsavelId")
    private Set<Usuario> usuarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getLogDataCriacao() {
        return logDataCriacao;
    }

    @PrePersist
    protected void onCreate() {
        logDataCriacao = LocalDateTime.now();
    }

    public Usuario getResponsavelId() {
        return responsavelId;
    }

    public void setResponsavelId(Usuario responsavelId) {
        this.responsavelId = responsavelId;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
