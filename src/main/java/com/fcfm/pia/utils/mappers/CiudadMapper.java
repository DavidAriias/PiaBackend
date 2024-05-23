package com.fcfm.pia.utils.mappers;

import com.fcfm.pia.models.Ciudad;
import com.fcfm.pia.repository.entities.CiudadEntity;

public class CiudadMapper {

    public static Ciudad CiudadEntityToCiudadModel(CiudadEntity ciudadEntity){
        return new Ciudad(
                ciudadEntity.getIdCiudad(),
                ciudadEntity.getCiudad()
        );
    }

    public static CiudadEntity CiudadModelToCiudadEntity(Ciudad ciudad){
        return new CiudadEntity(
                ciudad.getId(),
                ciudad.getNombre()
        );
    }
}
