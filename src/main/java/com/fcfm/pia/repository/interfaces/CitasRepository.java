package com.fcfm.pia.repository.interfaces;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.repository.entities.CitaEntity;

import java.util.List;

public interface CitasRepository {
    void setCita(Cita cita);

    List<CitaEntity> getCitas(String inicio, String fin);

    CitaEntity getCita(long idCita);

    CitaEntity updateCita(int idCita);

    void deleteCita(int idCita);
}
