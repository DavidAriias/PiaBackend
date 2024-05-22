package com.fcfm.pia.services.interfaces;

import com.fcfm.pia.models.Medico;

import java.util.List;

public interface MedicoService {
    List<Medico> getMedicosByEspecialidad(Long idEspecialidad);
    List<Medico> getMedicosByRangoHorario(String horarioInicio, String horarioFin);
}
