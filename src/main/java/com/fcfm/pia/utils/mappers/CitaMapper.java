package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.models.CitaEstatus;
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

    //Mapper modelo a entidad
    public static CitaEntity CitaModeltoCitaEntity(Cita cita) {
        CitaEntity citaEntity = new  CitaEntity();

        //aqui tengo una duda, el id se genera solo vdd?
        //citaEntity.setIdCita(cita.getId());

        citaEntity.setFechaCita(cita.getFechaCita());

        citaEntity.setEstatus(
                CitaEstatusMapper.citaEstatusModelToEntity(cita.getEstatus())
        );

        citaEntity.setPaciente(
                PacienteMapper.PacienteModelToPacienteEntity(cita.getPaciente())
        );
        citaEntity.setMedico(
                MedicoMapper.MedicoModelToMedicoEntity(cita.getMedico())
        );

        return citaEntity;
    }
}
