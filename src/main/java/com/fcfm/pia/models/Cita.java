package com.fcfm.pia.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Cita {
    private Long Id;
    private Long idMedico;
    private Long idEstatus;
    private Long idPaciente;
    private Timestamp fechaCita;

    public Cita(Long idMedico, Long idEstatus, Long idPaciente, Timestamp fechaCita) {
        this.idMedico = idMedico;
        this.idEstatus = idEstatus;
        this.idPaciente = idPaciente;
        this.fechaCita = fechaCita;
    }

    public Cita() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(Long idEstatus) {
        this.idEstatus = idEstatus;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Timestamp getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Timestamp fechaCita) {
        this.fechaCita = fechaCita;
    }
}
