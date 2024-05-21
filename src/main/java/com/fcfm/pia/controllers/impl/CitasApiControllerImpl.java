package com.fcfm.pia.controllers.impl;

import com.fcfm.pia.controllers.interfaces.CitasApiController;
import com.fcfm.pia.models.Cita;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CitasApiControllerImpl implements CitasApiController {

    @Override
    public ResponseEntity<?> setCita(Cita cita) {
        return null;
    }

    @Override
    public ResponseEntity<?> getCitas(String inicio, String fin) {
        return null;
    }

    @Override
    public ResponseEntity<?> getCita(int idCita) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateCita(int idCita, Cita cita) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteCita(int idCita) {
        return null;
    }


}
