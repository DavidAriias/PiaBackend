package com.fcfm.pia.models;

import java.util.List;

public class Medico {

    private Long Id;
    private String nombre;
    private String apellidos;
    private List<Especialidad> especialidad;
    private List<Horario> horario;
    private Ciudad ciudad;

    public Medico(Long id, String nombre, String apellidos, List<Especialidad> especialidad, List<Horario> horario, Ciudad ciudad){
        this.Id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
        this.horario = horario;
        this.ciudad = ciudad;
    }

    public void setEspecialidad(List<Especialidad> especialidad) {
        this.especialidad = especialidad;
    }

    public List<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }
}
