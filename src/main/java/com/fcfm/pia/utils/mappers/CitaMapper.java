package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.models.Especialidad;
import com.fcfm.pia.repository.entities.CitaEntity;
import com.fcfm.pia.repository.entities.EspecialidadEntity;
import com.fcfm.pia.repository.entities.MedicoEntity;

public class CitaMapper {

    public static Cita CitaEntitytoCitaModel(CitaEntity citaEntity) {
        Cita cita = new Cita();
        cita.setId(citaEntity.getId());
        cita.setIdMedico(citaEntity.getMedico().getId());
        cita.setIdEstatus(citaEntity.getEstatus().getId());
        cita.setIdPaciente(citaEntity.getPaciente().getId());
        cita.setFechaCita(citaEntity.getFechaCita());

        return cita;
    }

    //AYUDAAA
    public static CitaEntity CitaModeltoCitaEntity(Cita cita) {
        return null;
    }
}
