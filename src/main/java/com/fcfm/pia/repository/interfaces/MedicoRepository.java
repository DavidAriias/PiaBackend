package com.fcfm.pia.repository.interfaces;

import com.fcfm.pia.repository.entities.MedicoEntity;

import java.util.List;

public interface MedicoRepository {
    List<MedicoEntity> getMedicosByEspecialidad(Long idEspecialidad);
}
