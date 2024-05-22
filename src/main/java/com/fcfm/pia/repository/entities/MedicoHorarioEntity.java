package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "medico_horarios", schema = "public")
public class MedicoHorarioEntity {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private MedicoEntity medico;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_horario")
    private HorarioEntity horario;

    // Constructores, getters y setters

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public HorarioEntity getHorario() {
        return horario;
    }

    public void setHorario(HorarioEntity horario) {
        this.horario = horario;
    }
}
