package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Horario;
import com.fcfm.pia.repository.entities.HorarioEntity;

public class HorarioMapper {
    public static Horario HorarioEntityToHorarioModel(HorarioEntity horarioEntity){
        return new Horario(
                horarioEntity.getHorarioInicio(),
                horarioEntity.getHorarioFin(),
                horarioEntity.getDiaSemana()
        );
    }
    public static HorarioEntity HorarioModelToHorarioEntity(Horario horario){
        HorarioEntity horarioEntity = new HorarioEntity();

        horarioEntity.setHorarioInicio(horario.getHoraInicio());
        horarioEntity.setHorarioFin(horario.getHoraFin());
        horarioEntity.setDiaSemana(horario.getDiaSemana());

        return horarioEntity;
    };
}
