package com.fcfm.pia.services.interfaces;

import com.fcfm.pia.models.Cita;

import java.util.List;
import java.util.Optional;

public interface CitasService {
    void setCita(Cita cita);

    List<Cita> getCitas(String inicio, String fin);

    Optional<Cita> getCita(long idCita);

    Cita updateCita(int idCita);

    void deleteCita(int idCita);
}
