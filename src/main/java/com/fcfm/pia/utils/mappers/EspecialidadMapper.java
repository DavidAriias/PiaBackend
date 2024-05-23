package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Especialidad;
import com.fcfm.pia.repository.entities.EspecialidadEntity;

public class EspecialidadMapper {

    public static Especialidad EspecilidadEntityToEspecilidadModel(EspecialidadEntity especialidadEntity) {
        return new Especialidad(
                especialidadEntity.getIdEspecialidad(),
                especialidadEntity.getEspecialidad()
        );
    }

    public static EspecialidadEntity EspecialidadModelToEspecialidaEntity(Especialidad especialidad){
         return new EspecialidadEntity(
                 especialidad.getId(),
                 especialidad.getNombre()
         );
    }
}
