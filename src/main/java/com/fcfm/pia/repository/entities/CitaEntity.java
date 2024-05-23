package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "citas")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;

    @ManyToOne()
    @JoinColumn(name = "id_medico")
    private MedicoEntity medico;

    @ManyToOne()
    @JoinColumn(name = "id_estatus")
    private CitaEstatusEntity estatus;

    @ManyToOne()
    @JoinColumn(name = "id_paciente")
    private PacienteEntity paciente;

    @Column(name = "fecha_cita", nullable = false)
    private String fechaCita;

    // Constructor vacío y constructor con parámetros
    public CitaEntity(Long idCita, MedicoEntity medico, CitaEstatusEntity estatus, PacienteEntity paciente, String fechaCita) {
        this.idCita = idCita;
        this.medico = medico;
        this.estatus = estatus;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
    }

    public CitaEntity(){}
    // Getters y setters
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
