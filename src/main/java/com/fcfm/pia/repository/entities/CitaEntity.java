package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "citas", schema = "public")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long id;

    @Column(name = "fecha_cita")
    private Timestamp fechaCita;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private MedicoEntity medico;

    @ManyToOne
    @JoinColumn(name = "id_estatus")
    private CitaEstatusEntity estatus;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private PacienteEntity paciente;

    public CitaEntity(MedicoEntity medico, CitaEstatusEntity estatus, PacienteEntity paciente,Timestamp fechaCita) {
        this.medico = medico;
        this.estatus = estatus;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
    }

    public CitaEntity() {

    }

    //setters y getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Timestamp fechaCita) {
        this.fechaCita = fechaCita;
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
}
