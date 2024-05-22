package com.fcfm.pia.controllers.impl;

import com.fcfm.pia.controllers.interfaces.CitasApiController;
import com.fcfm.pia.models.Cita;
import com.fcfm.pia.services.interfaces.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitasApiControllerImpl implements CitasApiController {

    private CitasService citasService;


   
    @Autowired
    CitasApiControllerImpl(CitasService citasService){
        this.citasService = citasService;
    }


    @Override
    public ResponseEntity<?> setCita(Cita cita) {
        try {
            citasService.setCita(cita);
            return ResponseEntity.ok().body("Cita generada con exito");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //este lo voy a dejar para el ultimo xd
    @Override
    public ResponseEntity<?> getCitas(String inicio, String fin) {
        try {
            return ResponseEntity.ok().body(citasService.getCitas(inicio, fin));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }


    @Override
    public ResponseEntity<?> getCita(long idCita) {
        try {
            return ResponseEntity.ok().body(citasService.getCita(idCita));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateCita(int idCita, Cita cita) {
        try {
            return ResponseEntity.ok().body(citasService.updateCita(idCita));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteCita(int idCita) {
        try {
            citasService.deleteCita(idCita);
            return ResponseEntity.ok().body("Cita cancelada con exito");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }


}
