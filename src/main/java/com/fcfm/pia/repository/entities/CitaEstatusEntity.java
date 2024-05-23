package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cita_estatus")
public class CitaEstatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita_estatus")
    private Long idCitaEstatus;

    @Column(name = "estatus", nullable = false)
    private String estatus;

    public CitaEstatusEntity(Long idCitaEstatus, String estatus){
        this.idCitaEstatus = idCitaEstatus;
        this.estatus = estatus;
    }
    public CitaEstatusEntity(){}

    // Getters and setters
    public Long getIdCitaEstatus() {
        return idCitaEstatus;
    }

    public void setIdCitaEstatus(Long idCitaEstatus) {
        this.idCitaEstatus = idCitaEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
