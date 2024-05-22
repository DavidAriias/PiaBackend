package com.fcfm.pia.services.interfaces;

import com.fcfm.pia.models.Cita;

import java.util.List;

public interface CitasService {
    void setCita(Cita cita);

    List<Cita> getCitas(String inicio, String fin);

    Cita getCita(long idCita);

    Cita updateCita(int idCita);

    void deleteCita(int idCita);
}
