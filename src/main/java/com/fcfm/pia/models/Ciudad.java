package com.fcfm.pia.models;

public class Ciudad {

    private long Id;
    private String nombre;

    public Ciudad(long id, String nombre){
        this.Id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
