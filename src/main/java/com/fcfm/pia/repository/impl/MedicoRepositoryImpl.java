package com.fcfm.pia.repository.impl;

import com.fcfm.pia.repository.entities.MedicoEntity;
import com.fcfm.pia.repository.interfaces.MedicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicoRepositoryImpl implements MedicoRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<MedicoEntity> getMedicosByEspecialidad(Long idEspecialidad) {
        String jpql = "SELECT m " +
                "FROM MedicoEntity m " +
                "JOIN FETCH m.especialidad e " +
                "JOIN FETCH m.ciudad c " +
                "JOIN FETCH m.horarios h " +
                "WHERE e.id = :idEspecialidad " +
                "ORDER BY m.nombre, h.diaSemana";

        TypedQuery<MedicoEntity> query = em.createQuery(jpql, MedicoEntity.class);
        query.setParameter("idEspecialidad", idEspecialidad);

        List<MedicoEntity> medicoEntities = query.getResultList();

        return medicoEntities;
    }
}
