package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Medico;
import com.fcfm.pia.repository.entities.MedicoEntity;

import java.util.stream.Collectors;

public class MedicoMapper {

    public static Medico MedicoEntityToMedicoModel(MedicoEntity medicoEntity){
        return new Medico(
                medicoEntity.getId(),
                medicoEntity.getNombre(),
                medicoEntity.getApellidos(),
                medicoEntity.getEspecialidad().getEspecialidad(),
                medicoEntity.getHorario()
                        .stream()
                        .map(HorarioMapper::HorarioEntityToHorarioModel)
                        .collect(Collectors.toList()),
                medicoEntity.getCiudad().getCiudad()
        );
    }
}
