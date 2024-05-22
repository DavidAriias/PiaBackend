package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "ciudades", schema = "public")
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCiudad;

    private String ciudad;

    // Getters and setters
    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
