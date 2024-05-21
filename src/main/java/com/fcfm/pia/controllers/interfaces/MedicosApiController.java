package com.fcfm.pia.controllers.interfaces;

import com.fcfm.pia.models.Medico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/medicos")
public interface MedicosApiController {

    @GetMapping
    ResponseEntity<?> getMedicosByEspecialidad(@RequestParam("especialidad") Long idEspecialidad);
}
