package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.models.CitaEstatus;
import com.fcfm.pia.models.Medico;
import com.fcfm.pia.models.Paciente;
import com.fcfm.pia.models.enums.CitaEstatusEnum;
import com.fcfm.pia.models.request.CitaRequest;
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

    public static Cita CitaRequestToCitaModel(CitaRequest request, CitaEstatusEnum citaEstatusEnum){
        //Creando instancia de cita model
        Cita cita = new Cita();

        //Setteando fecha de la cita en base a como funciona en el model
        cita.setFechaCita(request.getHorario());

        //Creando instancia del estatus que es como lo pide el model de cita
        CitaEstatus citaEstatus = new CitaEstatus();

        //Setteando el id del estatus
        citaEstatus.setId(Long.parseLong(citaEstatusEnum.getValor()));

        cita.setEstatus(citaEstatus);

        //Setteando el id del medico y creando isntancia de medico
        Medico medico = new Medico();
        medico.setId(request.getIdMedico());

        cita.setMedico(medico);

        //Creando instancia y setteando valor para paciente
        Paciente paciente = new Paciente();

        paciente.setId(request.getIdPaciente());

       cita.setPaciente(paciente);

        return cita;
    }

    //AYUDAAA
    public static CitaEntity CitaModeltoCitaEntity(Cita cita) {
        return new CitaEntity(
                cita.getId(),
                MedicoMapper.MedicoModelToMedicoEntity(cita.getMedico()),
                CitaEstatusMapper.citaEstatusModelToCitaEstatusEntity(cita.getEstatus()),
                PacienteMapper.PacienteModelToPacienteEntity(cita.getPaciente()),
                cita.getFechaCita()
        );
    }
}
