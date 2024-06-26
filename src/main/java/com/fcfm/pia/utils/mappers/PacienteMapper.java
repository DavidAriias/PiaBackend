package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Paciente;
import com.fcfm.pia.repository.entities.PacienteEntity;

public class PacienteMapper {

    public static Paciente PacienteEntityToPacienteModel(PacienteEntity pacienteEntity){
        return new Paciente(
                pacienteEntity.getIdPaciente(),
                pacienteEntity.getNombre(),
                pacienteEntity.getApellidos()
        );
    }

    public static PacienteEntity PacienteModelToPacienteEntity(Paciente paciente){
        return new PacienteEntity(
                paciente.getId(),
                paciente.getNombre(),
                paciente.getApellidos()
        );
    }
}
