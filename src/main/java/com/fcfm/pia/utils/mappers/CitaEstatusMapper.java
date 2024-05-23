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

    public static CitaEstatusEntity citaEstatusModelToEntity(CitaEstatus citaEstatus){
        CitaEstatusEntity citaEstatusEntity = new CitaEstatusEntity();

        //citaEstatusEntity.setIdCitaEstatus(citaEstatus.getId());
        citaEstatusEntity.setEstatus(citaEstatus.getEstatus());

        return citaEstatusEntity;
    };
}
