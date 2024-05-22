package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "medico_especialidades", schema = "public")
public class MedicoEspecialidadEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private MedicoEntity medico;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private EspecialidadEntity especialidad;

    // Getters and setters
    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        this.medico = medico;
    }

    public EspecialidadEntity getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadEntity especialidad) {
        this.especialidad = especialidad;
    }
}
