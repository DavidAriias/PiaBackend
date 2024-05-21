package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cita_estatus", schema = "public")
public class CitaEstatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita_estatus")
    private Long id;

    @Column(name = "estatus")
    private String estatus;


    //setters y getters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
