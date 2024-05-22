package com.fcfm.pia.repository.impl;

import com.fcfm.pia.repository.entities.*;
import com.fcfm.pia.repository.interfaces.MedicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public class MedicoRepositoryImpl implements MedicoRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<MedicoEntity> getMedicosByEspecialidad(Long idEspecialidad) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MedicoEntity> criteriaQuery = criteriaBuilder.createQuery(MedicoEntity.class);
        Root<MedicoEntity> medicoRoot = criteriaQuery.from(MedicoEntity.class);

        // Joins con las tablas relacionadas
        Join<MedicoEntity, EspecialidadEntity> especialidadJoin = medicoRoot.join("especialidades");
        Join<MedicoEntity, HorarioEntity> horarioJoin = medicoRoot.join("horarios");
        Join<MedicoEntity, CiudadEntity> ciudadJoin = medicoRoot.join("ciudad");

        criteriaQuery.select(medicoRoot).distinct(true);
        criteriaQuery.where(criteriaBuilder.equal(especialidadJoin.get("idEspecialidad"), idEspecialidad));

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<MedicoEntity> getMedicosByRangoHorario(String horarioInicio, String horarioFin) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MedicoEntity> criteriaQuery = criteriaBuilder.createQuery(MedicoEntity.class);
        Root<MedicoEntity> medicoRoot = criteriaQuery.from(MedicoEntity.class);

        // Joins con las tablas relacionadas
        Join<MedicoEntity, EspecialidadEntity> especialidadJoin = medicoRoot.join("especialidades");
        Join<MedicoEntity, HorarioEntity> horarioJoin = medicoRoot.join("horarios");
        Join<MedicoEntity, CiudadEntity> ciudadJoin = medicoRoot.join("ciudad");



        // Añadir las condiciones al CriteriaQuery
        criteriaQuery.select(medicoRoot).distinct(true);

        Predicate predicate = criteriaBuilder.or(
                criteriaBuilder.between(horarioJoin.get("horarioInicio"), horarioInicio, horarioFin),
                criteriaBuilder.between(horarioJoin.get("horarioFin"), horarioInicio, horarioFin)
        );
        criteriaQuery.where(predicate);

        return em.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<MedicoEntity> getMedicosByCiudad(Long idCiudad) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<MedicoEntity> criteriaQuery = criteriaBuilder.createQuery(MedicoEntity.class);
        Root<MedicoEntity> medicoRoot = criteriaQuery.from(MedicoEntity.class);

        // Joins con las tablas relacionadas
        Join<MedicoEntity, EspecialidadEntity> especialidadJoin = medicoRoot.join("especialidades");
        Join<MedicoEntity, HorarioEntity> horarioJoin = medicoRoot.join("horarios");
        Join<MedicoEntity, CiudadEntity> ciudadJoin = medicoRoot.join("ciudad");

        criteriaQuery.select(medicoRoot).distinct(true);
        criteriaQuery.where(criteriaBuilder.equal(ciudadJoin.get("idCiudad"), idCiudad));

        return em.createQuery(criteriaQuery).getResultList();
    }
}
