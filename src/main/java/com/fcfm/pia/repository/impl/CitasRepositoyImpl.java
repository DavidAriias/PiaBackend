package com.fcfm.pia.repository.impl;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.repository.entities.CitaEntity;
import com.fcfm.pia.repository.entities.EspecialidadEntity;
import com.fcfm.pia.repository.interfaces.CitasRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CitasRepositoyImpl implements CitasRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void setCita(Cita cita) {

    }

    @Override
    public List<CitaEntity> getCitas(String inicio, String fin) {
        return null;
    }

    @Override
    public Optional<CitaEntity> getCita(long idCita) {
        CitaEntity cita = em.find(CitaEntity.class, idCita);
        return Optional.ofNullable(cita);
    }

    @Override
    public CitaEntity updateCita(int idCita) {
        return null;
    }

    @Override
    public void deleteCita(int idCita) {

    }
}
