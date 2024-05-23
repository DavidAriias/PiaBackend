package com.fcfm.pia.models;

public class Horario {

    private Long id;
    private String horaInicio;
    private String horaFin;

    public Horario(Long id,String horaInicio,String horaFin){
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId() {
        return id;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
