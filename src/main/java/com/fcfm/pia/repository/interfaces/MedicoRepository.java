package com.fcfm.pia.repository.interfaces;

import com.fcfm.pia.repository.entities.MedicoEntity;

import java.util.List;

public interface MedicoRepository {
    List<MedicoEntity> getMedicosByEspecialidad(Long idEspecialidad);
    List<MedicoEntity> getMedicosByRangoHorario(String horarioInicio, String horarioFin);
    List<MedicoEntity> getMedicosByCiudad(Long idCiudad);
}
