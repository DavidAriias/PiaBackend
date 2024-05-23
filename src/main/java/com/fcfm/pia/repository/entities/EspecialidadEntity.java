package com.fcfm.pia.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "especialidades", schema = "public")
public class EspecialidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidad;

    private String especialidad;

    public EspecialidadEntity(Long idEspecialidad, String especialidad){
        this.idEspecialidad = idEspecialidad;
        this.especialidad = especialidad;
    }
    public EspecialidadEntity(){}

    // Getters and setters
    public Long getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Long idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
