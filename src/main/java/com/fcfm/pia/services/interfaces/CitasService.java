package com.fcfm.pia.services.interfaces;

import com.fcfm.pia.models.Cita;

import java.util.List;
import java.util.Optional;

public interface CitasService {
    Cita setCita(Cita cita);

    List<Cita> getCitas(String horarioInicio, String horarioFin,Long idPaciente);

    Optional<Cita> getCita(long idCita);

    Cita updateCita(Long idCita, Cita citaRequest);

    Cita deleteCita(Long idCita);
}
