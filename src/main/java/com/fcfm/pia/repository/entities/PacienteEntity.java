package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes", schema = "public")
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;


    //Setters y getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
