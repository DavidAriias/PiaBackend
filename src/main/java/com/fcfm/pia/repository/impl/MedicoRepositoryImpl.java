package com.fcfm.pia.repository.impl;

import com.fcfm.pia.repository.entities.EspecialidadEntity;
import com.fcfm.pia.repository.entities.MedicoEntity;
import com.fcfm.pia.repository.interfaces.MedicoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicoRepositoryImpl implements MedicoRepository {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<MedicoEntity> getMedicosByEspecialidad(Long idEspecialidad) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MedicoEntity> cq = cb.createQuery(MedicoEntity.class);
        Root<MedicoEntity> medicoRoot = cq.from(MedicoEntity.class);

        // Fetch de las asociaciones usando las anotaciones definidas en las entidades
        medicoRoot.fetch("especialidad", JoinType.INNER);
        medicoRoot.fetch("horario", JoinType.INNER);
        medicoRoot.fetch("ciudad", JoinType.INNER);

        cq.select(medicoRoot)
                .distinct(true); // Para evitar resultados duplicados si un médico tiene múltiples especialidades

        TypedQuery<MedicoEntity> query = em.createQuery(cq);
        List<MedicoEntity> medicos = query.getResultList();

        em.close();
        return medicos;
    }
}
