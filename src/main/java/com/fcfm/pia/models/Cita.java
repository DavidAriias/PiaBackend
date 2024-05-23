package com.fcfm.pia.models;


public class Cita {
    private Long Id;
    private Medico medico;
    private CitaEstatus estatus;
    private Paciente paciente;
    private String fechaCita;

    public Cita (Long id, Medico medico, CitaEstatus estatus, Paciente paciente, String fechaCita){
        this.Id = id;
        this.medico = medico;
        this.estatus = estatus;
        this.paciente = paciente;
        this.fechaCita = fechaCita;
    }

    public Cita(){

    }
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public CitaEstatus getEstatus() {
        return estatus;
    }

    public void setEstatus(CitaEstatus estatus) {
        this.estatus = estatus;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
