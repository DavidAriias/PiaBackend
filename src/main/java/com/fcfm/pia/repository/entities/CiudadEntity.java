package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;
@Entity
@Table(name = "ciudades", schema = "public")
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;

    private String ciudad;

    public CiudadEntity(Long idCiudad, String ciudad){
        this.idCiudad = idCiudad;
        this.ciudad = ciudad;
    }
    public CiudadEntity(){}

    // Getters and setters
    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
