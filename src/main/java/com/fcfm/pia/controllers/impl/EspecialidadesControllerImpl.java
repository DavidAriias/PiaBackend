package com.fcfm.pia.controllers.impl;

import com.fcfm.pia.controllers.interfaces.EspecialidadesController;
import com.fcfm.pia.models.Especialidad;
import com.fcfm.pia.services.interfaces.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EspecialidadesControllerImpl implements EspecialidadesController {

    private EspecialidadService especialidadService;
    @Autowired
    EspecialidadesControllerImpl(EspecialidadService especialidadService){
        this.especialidadService = especialidadService;
    }
    @Override
    public ResponseEntity<?> getEspecialidades() {
        try {
            return ResponseEntity.ok().body(
                    especialidadService.getEspecialidadList()
            );
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
