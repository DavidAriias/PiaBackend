package com.fcfm.pia.repository.interfaces;

import com.fcfm.pia.repository.entities.CitaEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CitasRepository {
    @Transactional
    CitaEntity setCita(CitaEntity cita);

    List<CitaEntity> getCitas(String horarioInicio, String horarioFin, Long idPaciente);

    Optional<CitaEntity> getCita(long idCita);

    @Transactional
    CitaEntity updateCita(Long idCita, CitaEntity cita);

    @Transactional
    CitaEntity deleteCita(Long idCita);
}
