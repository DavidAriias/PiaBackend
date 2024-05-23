package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "horarios", schema = "public")
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long idHorario;

    @Column(name = "horario_inicio", nullable = false)
    private String horarioInicio;

    @Column(name = "horario_fin", nullable = false)
    private String horarioFin;

    public HorarioEntity(Long idHorario, String horarioInicio, String horarioFin){
        this.idHorario = idHorario;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
    }
    public HorarioEntity(){

    }

    // Getters y Setters
    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }

}
