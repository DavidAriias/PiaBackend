package com.fcfm.pia.controllers.impl;

import com.fcfm.pia.controllers.interfaces.MedicosApiController;
import com.fcfm.pia.services.interfaces.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicosApiControllerImpl implements MedicosApiController {

    private MedicoService medicoService;

    @Autowired
    public MedicosApiControllerImpl(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @Override
    public ResponseEntity<?> getMedicosByEspecialidad(Long idEspecialidad) {

        if (idEspecialidad <= 0) return ResponseEntity.badRequest().body("El id debe ser mayor a cero");
        try {
            return ResponseEntity.ok().body(
                    medicoService.getMedicosByEspecialidad(idEspecialidad)
            );
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
