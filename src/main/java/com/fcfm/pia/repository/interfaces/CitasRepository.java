package com.fcfm.pia.repository.interfaces;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.repository.entities.CitaEntity;

import java.util.List;
import java.util.Optional;

public interface CitasRepository {
    void setCita(Cita cita);

    List<CitaEntity> getCitas(String inicio, String fin);

    Optional<CitaEntity> getCita(long idCita);

    CitaEntity updateCita(int idCita);

    void deleteCita(int idCita);
}
