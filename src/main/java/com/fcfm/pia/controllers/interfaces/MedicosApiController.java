package com.fcfm.pia.controllers.interfaces;

import com.fcfm.pia.models.Medico;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@RequestMapping("/medicos")
public interface MedicosApiController {

    @GetMapping("{idEspecialidad}")
    ResponseEntity<?> getMedicosByEspecialidad(@PathVariable("idEspecialidad") Long idEspecialidad);

    @GetMapping
    ResponseEntity<?> getMedicosByRangoHorario(
            @RequestParam("horaInicio") @DateTimeFormat(pattern = "HH:mm") LocalTime horaInicio,
            @RequestParam("horaFin") @DateTimeFormat(pattern = "HH:mm") LocalTime horaFin
            );
}
