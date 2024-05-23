package com.fcfm.pia.controllers.impl;

import com.fcfm.pia.controllers.interfaces.CitasApiController;
import com.fcfm.pia.models.Cita;
import com.fcfm.pia.models.enums.CitaEstatusEnum;
import com.fcfm.pia.models.request.CitaRequest;
import com.fcfm.pia.services.interfaces.CitasService;
import com.fcfm.pia.utils.helpers.ValidateHour;
import com.fcfm.pia.utils.mappers.CitaMapper;
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
    public ResponseEntity<?> setCita(CitaRequest cita) {
        try {

            if (cita.getIdMedico() <= 0 || cita.getIdPaciente() <= 0)
                return ResponseEntity.badRequest().body("Alguno de los ids proporcionados es menor o igual a cero, debe proporcionarse de uno hacia arriba");

            if (!ValidateHour.validarFormatoHora(cita.getHorario()))
                return ResponseEntity.badRequest().body("El horario debe ser en formato HH:mm");

            citasService.setCita(CitaMapper.CitaRequestToCitaModel(cita, CitaEstatusEnum.AGENDADA));
            return ResponseEntity.ok().body("Cita generada con exito");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    //este lo voy a dejar para el ultimo xd
    @Override
    public ResponseEntity<?> getCitas(String horarioInicio, String horarioFin) {
        try {
            if (!ValidateHour.validarFormatoHora(horarioInicio) || !ValidateHour.validarFormatoHora(horarioFin))
                return ResponseEntity.badRequest().body("No es valido el formato de hora, debe ser HH:mm");

            return ResponseEntity.ok().body(citasService.getCitas(horarioInicio, horarioFin, Long.parseLong("1")));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> getCita(long idCita) {
        try {
            if (idCita <= 0) return ResponseEntity.badRequest().body("El id de la cita no puede ser igual o menor a cero");

            var citaResponse = citasService.getCita(idCita);

            if (citaResponse.isPresent()) return ResponseEntity.ok().body(citaResponse);
            else return ResponseEntity.badRequest().body("No se ha encontrado la cita con ese id");

        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> updateCita(Long idCita,CitaRequest citaRequest) {
        try {
            return ResponseEntity.ok().body(citasService.updateCita(
                    idCita,
                    CitaMapper.CitaRequestToCitaModel(citaRequest, CitaEstatusEnum.REPROGRAMADA))
            );
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> deleteCita(Long idCita) {
        try {
            if (idCita <= 0) return ResponseEntity.badRequest().body("El id no puede ser menor o igual a cero");

            return ResponseEntity.ok().body( citasService.deleteCita(idCita) );
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }


}
