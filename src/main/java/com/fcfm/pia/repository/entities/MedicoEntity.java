package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicos",  schema = "public")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long idMedico;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @ManyToOne
    @JoinColumn(name = "id_ciudad")
    private CiudadEntity ciudad;

    @ManyToMany
    @JoinTable(
            name = "medico_especialidades",
            joinColumns = @JoinColumn(name = "id_medico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad")
    )
    private List<EspecialidadEntity> especialidades;

    @ManyToMany
    @JoinTable(
            name = "medico_horarios",
            joinColumns = @JoinColumn(name = "id_medico"),
            inverseJoinColumns = @JoinColumn(name = "id_horario")
    )
    private List<HorarioEntity> horarios;

    // Getters and setters
    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
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

    public CiudadEntity getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadEntity ciudad) {
        this.ciudad = ciudad;
    }

    public List<EspecialidadEntity> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<EspecialidadEntity> especialidades) {
        this.especialidades = especialidades;
    }

    public List<HorarioEntity> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioEntity> horarios) {
        this.horarios = horarios;
    }
}
