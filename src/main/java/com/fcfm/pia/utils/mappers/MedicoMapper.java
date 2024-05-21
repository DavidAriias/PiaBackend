package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Medico;
import com.fcfm.pia.repository.entities.MedicoEntity;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MedicoMapper {

    public static Medico MedicoEntityToMedicoModel(MedicoEntity medicoEntity){
        return new Medico(
                medicoEntity.getId(),
                medicoEntity.getNombre(),
                medicoEntity.getApellidos(),


                //creo que no deberia ser asi pero luego lo cambio
                medicoEntity.getEspecialidad().toString(),
                /*medicoEntity.getEspecialidad()
                        .stream()
                        .map(EspecialidadMapper::EspecilidadEntityToEspecilidadModel)
                        .collect(Collectors.toList()),*/


                medicoEntity.getHorario()
                        .stream()
                        .map(HorarioMapper::HorarioEntityToHorarioModel)
                        .collect(Collectors.toList()),
                medicoEntity.getCiudad().getCiudad()
        );
    }
}
