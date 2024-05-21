package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ciudades", schema = "public")
public class CiudadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long id;

    @Column(name = "ciudad")
    private String ciudad;

    @OneToMany(mappedBy = "ciudad")
    private List<MedicoEntity> medicos;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<MedicoEntity> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoEntity> medicos) {
        this.medicos = medicos;
    }
}
