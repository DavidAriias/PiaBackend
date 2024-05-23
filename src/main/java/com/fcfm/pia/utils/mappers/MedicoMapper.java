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
        MedicoEntity medicoEntity = new MedicoEntity();

        //medicoEntity.setIdMedico(medico.getId());
        medicoEntity.setNombre(medico.getNombre());
        medicoEntity.setApellidos(medico.getApellidos());

        medicoEntity.setCiudad(CiudadMapper.CiudadModelToCiudadEntity(medico.getCiudad()));
        medicoEntity.setHorarios(
                medico.getHorario()
                        .stream()
                        .map(HorarioMapper::HorarioModelToHorarioEntity)
                        .collect(Collectors.toList())
        );
        medicoEntity.setEspecialidades(
                medico.getEspecialidad()
                        .stream()
                        .map(EspecialidadMapper::EspecialidModelToEspecialidadEntity)
                        .collect(Collectors.toList())
        );


        return medicoEntity;
    };

}
