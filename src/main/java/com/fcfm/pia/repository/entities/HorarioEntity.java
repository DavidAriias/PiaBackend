package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "horarios", schema = "public")
public class HorarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long id;

    @Column(name = "dia_semana")
    private String diaSemana;

    @Column(name = "horario_inicio")
    private String horarioInicio;

    @Column(name = "horario_fin")
    private String horarioFin;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private MedicoEntity medico;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }



}
