package com.fcfm.pia.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "especialidades", schema = "public")
public class EspecialidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad", nullable = false)
    private Long idEspecialidad;

    @Column(name = "especialidad")
    private String especialidad;

    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
}
