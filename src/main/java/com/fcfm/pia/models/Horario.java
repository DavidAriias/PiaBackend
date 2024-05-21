package com.fcfm.pia.models;

public class Horario {

    private String horaInicio;
    private String horaFin;
    private String diaSemana;

    public Horario(String horaInicio,String horaFin, String diaSemana){
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.diaSemana = diaSemana;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }
}
