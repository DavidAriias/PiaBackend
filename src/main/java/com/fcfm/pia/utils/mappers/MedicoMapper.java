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

    public static MedicoEntity MedicoModelToMedicoEntity(Medico medico){
        return new MedicoEntity(
                medico.getId(),
                medico.getNombre(),
                medico.getApellidos(),
                (medico.getCiudad() != null ) ? CiudadMapper.CiudadModelToCiudadEntity(medico.getCiudad()) : null,
                (medico.getEspecialidad() != null) ? medico.getEspecialidad()
                        .stream()
                        .map(EspecialidadMapper::EspecialidadModelToEspecialidaEntity)
                        .collect(Collectors.toList()) : null,
                (medico.getHorario() != null) ? medico.getHorario()
                        .stream()
                        .map(HorarioMapper::HorarioModelToHorarioEntity)
                        .collect(Collectors.toList()) : null
        );
    }
}
