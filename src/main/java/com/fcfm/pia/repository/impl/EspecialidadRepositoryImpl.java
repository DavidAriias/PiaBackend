package com.fcfm.pia.repository.impl;

import com.fcfm.pia.repository.entities.EspecialidadEntity;
import com.fcfm.pia.repository.interfaces.EspecialidadRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EspecialidadRepositoryImpl implements EspecialidadRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EspecialidadEntity> getEspecialidadList() {
        return em.createQuery("SELECT e FROM EspecialidadEntity e", EspecialidadEntity.class)
                .getResultList();
    }
}
