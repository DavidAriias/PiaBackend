package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Medico;
import com.fcfm.pia.repository.entities.MedicoEntity;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MedicoMapper {

    public static Medico MedicoEntityToMedicoModel(MedicoEntity medicoEntity){
        return new Medico(
                medicoEntity.getIdMedico(),
                medicoEntity.getNombre(),
                medicoEntity.getApellidos(),
                medicoEntity.getEspecialidades()
                        .stream()
                        .map(EspecialidadMapper::EspecilidadEntityToEspecilidadModel)
                        .collect(Collectors.toList()),
                medicoEntity.getHorarios()
                                .stream()
                                .map(HorarioMapper::HorarioEntityToHorarioModel)
                                .collect(Collectors.toList()),
                CiudadMapper.CiudadEntityToCiudadModel(medicoEntity.getCiudad())
        );
    }
}
