package com.fcfm.pia.repository.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medicos", schema = "public")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medico")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellidos")
    private String apellidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad")
    private CiudadEntity ciudad;

    //Estos son donde se usa id_medico
    @OneToMany(mappedBy = "medico")
    private List<HorarioEntity> horario;
    @OneToMany(mappedBy = "medico")
    private List<EspecialidadEntity> especialidad;

    // Constructor, Getters y Setters

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

    public CiudadEntity getCiudad() {
        return ciudad;
    }

    public void setCiudad(CiudadEntity ciudad) {
        this.ciudad = ciudad;
    }

    public List<HorarioEntity> getHorario() {
        return horario;
    }

    public void setHorario(List<HorarioEntity> horario) {
        this.horario = horario;
    }

    public List<EspecialidadEntity> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(List<EspecialidadEntity> especialidad) {
        this.especialidad = especialidad;
    }
}
