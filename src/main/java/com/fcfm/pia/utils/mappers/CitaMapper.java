package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.repository.entities.CitaEntity;

public class CitaMapper {

    public static Cita CitaEntityToCitaModel(CitaEntity citaEntity) {
       return new Cita(
               citaEntity.getIdCita(),
               MedicoMapper.MedicoEntityToMedicoModel(citaEntity.getMedico()),
               CitaEstatusMapper.citaEstatusEntityToCitaEstatus(citaEntity.getEstatus()),
               PacienteMapper.PacienteEntityToPacienteModel(citaEntity.getPaciente()),
               citaEntity.getFechaCita()
       );
    }

    //AYUDAAA
    public static CitaEntity CitaModeltoCitaEntity(Cita cita) {
        return null;
    }
}
