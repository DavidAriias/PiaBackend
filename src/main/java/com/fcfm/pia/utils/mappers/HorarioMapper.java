package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Horario;
import com.fcfm.pia.repository.entities.HorarioEntity;

public class HorarioMapper {
    public static Horario HorarioEntityToHorarioModel(HorarioEntity horarioEntity){
        return new Horario(
                horarioEntity.getIdHorario(),
                horarioEntity.getHorarioInicio(),
                horarioEntity.getHorarioFin()
        );
    }

    public static HorarioEntity HorarioModelToHorarioEntity(Horario horario){
        return new HorarioEntity(
                horario.getId(),
                horario.getHoraInicio(),
                horario.getHoraFin()
        );
    }
}
