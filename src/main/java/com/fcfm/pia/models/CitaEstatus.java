package com.fcfm.pia.models;

import java.util.List;

public class CitaEstatus {

    private Long Id;
    private String estatus;

    public CitaEstatus(Long id, String estatus) {
        Id = id;
        this.estatus = estatus;
    }

    public CitaEstatus(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
