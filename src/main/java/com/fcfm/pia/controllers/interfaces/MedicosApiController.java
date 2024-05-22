package com.fcfm.pia.controllers.interfaces;

import io.swagger.v3.oas.annotations.media.SchemaProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;

@RequestMapping("/medicos")
public interface MedicosApiController {

    @GetMapping("/especialidad/{idEspecialidad}")
    ResponseEntity<?> getMedicosByEspecialidad(@PathVariable("idEspecialidad") Long idEspecialidad);

    @GetMapping("disponibilidad")
    ResponseEntity<?> getMedicosByRangoHorario(
            @RequestParam("horaInicio") String horaInicio,
            @RequestParam("horaFin") String horaFin
            );

    @GetMapping("/ciudad/{idCiudad}")
    ResponseEntity<?> getMedicosByCiudad(@PathVariable("idCiudad") Long idCiudad);

    @GetMapping
    ResponseEntity<?> getMedicosByFiltros(
            @RequestParam(value = "idEspecialidad", required = false) Long idEspecialidad,
            @RequestParam(value = "horaInicio", required = false) String horaInicio,
            @RequestParam(value = "horaFin", required = false) String horaFin,
            @RequestParam(value = "idCiudad", required = false) Long idCiudad
    );
}
