package com.fcfm.pia.repository.impl;

import com.fcfm.pia.repository.entities.CitaEntity;
import com.fcfm.pia.repository.entities.CitaEstatusEntity;
import com.fcfm.pia.repository.entities.EspecialidadEntity;
import com.fcfm.pia.repository.interfaces.CitasRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CitasRepositoyImpl implements CitasRepository {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void setCita(CitaEntity cita) {
        em.persist(cita);
    }

    @Override
    public List<CitaEntity> getCitas(String inicio, String fin) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<CitaEntity> criteriaQuery = criteriaBuilder.createQuery(CitaEntity.class);
        Root<CitaEntity> citaRoot = criteriaQuery.from(CitaEntity.class);

        Predicate predicate = criteriaBuilder.between(citaRoot.get("fechaCita"), inicio, fin);
        criteriaQuery.select(citaRoot).where(predicate);

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public Optional<CitaEntity> getCita(long idCita) {
        CitaEntity cita = em.find(CitaEntity.class, idCita);
        return Optional.ofNullable(cita);
    }

    @Override
    public CitaEntity updateCita(long idCita, CitaEntity cita) {
        CitaEntity citaEntity = em.find(CitaEntity.class, idCita);
        if (cita != null) {
            citaEntity.setFechaCita(cita.getFechaCita());
            citaEntity.setMedico(cita.getMedico());
            citaEntity.setEstatus(cita.getEstatus());
            em.merge(cita);
            return citaEntity;
        }
        return null;
    }

    @Override
    @Transactional
    public void deleteCita(long idCita) {
        CitaEntity citaEntity = em.find(CitaEntity.class, idCita);
        CitaEstatusEntity nuevoEstatus = em.find(CitaEstatusEntity.class, 3);

        try{
            if (citaEntity != null && nuevoEstatus != null){

                citaEntity.setEstatus(nuevoEstatus);
                em.merge(citaEntity);
            }

        }
        catch(Exception exception){
            throw new RuntimeException(exception.getMessage());
        }
    }
}
