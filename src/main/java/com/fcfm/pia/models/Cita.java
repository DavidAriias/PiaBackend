package com.fcfm.pia.models;

import java.util.Date;
import java.util.List;

public class Cita {
    private Long Id;
    private Long IdMedico;
    private Long IdEstatus;
    private Long IdPaciente;
    private Date fechaCita;

    public Cita(Long id, Long idMedico, Long idEstatus, Long idPaciente, Date fechaCita) {
        Id = id;
        IdMedico = idMedico;
        IdEstatus = idEstatus;
        IdPaciente = idPaciente;
        this.fechaCita = fechaCita;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getIdMedico() {
        return IdMedico;
    }

    public void setIdMedico(Long idMedico) {
        IdMedico = idMedico;
    }

    public Long getIdEstatus() {
        return IdEstatus;
    }

    public void setIdEstatus(Long idEstatus) {
        IdEstatus = idEstatus;
    }

    public Long getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        IdPaciente = idPaciente;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }
}
