package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.CitaEstatus;
import com.fcfm.pia.repository.entities.CitaEstatusEntity;

public class CitaEstatusMapper {

    public static CitaEstatus citaEstatusEntityToCitaEstatus(CitaEstatusEntity citaEstatusEntity){
        return new CitaEstatus(
          citaEstatusEntity.getIdCitaEstatus(),
          citaEstatusEntity.getEstatus()
        );
    }
}
