package com.fcfm.pia.models;

import java.util.List;

public class Paciente {

    private Long Id;
    private String nombre;
    private String apellidos;

    //constructor
    public Paciente(Long id, String nombre, String apellidos) {
        Id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Paciente(){}

    //getters y setters
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
