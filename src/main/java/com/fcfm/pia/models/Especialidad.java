package com.fcfm.pia.models;

public class Especialidad {
    private Long Id;
    private String nombre;

    public Especialidad(Long id, String nombre){
        this.Id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
