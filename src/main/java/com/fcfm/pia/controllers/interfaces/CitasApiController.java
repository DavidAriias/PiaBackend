package com.fcfm.pia.controllers.interfaces;

import com.fcfm.pia.models.Cita;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/citas")
public interface CitasApiController {

    //creacion de  cita para un doctor específico, en un horario específico.
    @PostMapping("/")
    ResponseEntity<?> setCita(@RequestBody Cita cita);


    //listado de citas entre dos fechas (info completa incluyendo estatus)
    @GetMapping("/rango")
    ResponseEntity<?> getCitas(
            @RequestParam("inicio") String inicio,
            @RequestParam("fin") String fin
    );


    //detalle de una cita en especifico
    @GetMapping("/{idCita}")
    ResponseEntity<?> getCita(@PathVariable long idCita);


    //actualizar una cierta cita
    @PutMapping("/{idCita}")
    ResponseEntity<?> updateCita(@PathVariable long idCita, @RequestBody Cita cita);

    //cancelar cierta cita
    @DeleteMapping("/{idCita}")
    ResponseEntity<?> deleteCita(@PathVariable long idCita);



}
