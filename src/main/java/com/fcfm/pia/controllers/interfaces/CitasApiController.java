package com.fcfm.pia.controllers.interfaces;

import com.fcfm.pia.models.Cita;
import com.fcfm.pia.models.request.CitaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/citas")
public interface CitasApiController {

    //creacion de  cita para un doctor específico, en un horario específico.
    @PostMapping("/")
    ResponseEntity<?> setCita(@RequestBody CitaRequest cita);


    //listado de citas entre dos fechas (info completa incluyendo estatus)
    @GetMapping("/")
    ResponseEntity<?> getCitas(
            @RequestParam("horarioInicio") String horarioInicio,
            @RequestParam("horarioFin") String horarioFin
    );


    //detalle de una cita en especifico
    @GetMapping("/{idCita}")
    ResponseEntity<?> getCita(@PathVariable long idCita);


    //actualizar una cierta cita
    @PutMapping("/{idCita}")
    ResponseEntity<?> updateCita(Long idCita,CitaRequest citaRequest);

    //cancelar cierta cita
    @DeleteMapping("/{idCita}")
    ResponseEntity<?> deleteCita(@PathVariable Long idCita);



}
