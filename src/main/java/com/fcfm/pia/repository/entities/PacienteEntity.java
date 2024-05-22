package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pacientes", schema = "public")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long idPaciente;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    // Getters and setters
    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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
