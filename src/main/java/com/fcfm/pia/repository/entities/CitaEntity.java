package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;

    @ManyToOne
    @JoinColumn(name = "id_medico", nullable = false)
    private MedicoEntity medico;

    @ManyToOne
    @JoinColumn(name = "id_estatus", nullable = false)
    private CitaEstatusEntity estatus;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private PacienteEntity paciente;

    @Column(name = "fecha_cita", nullable = false)
    private String fechaCita;

    // Getters and setters
    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public CitaEstatusEntity getEstatus() {
        return estatus;
    }

    public void setEstatus(CitaEstatusEntity estatus) {
        this.estatus = estatus;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        this.paciente = paciente;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
}
