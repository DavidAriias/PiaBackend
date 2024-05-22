package com.fcfm.pia.controllers.interfaces;

import com.fcfm.pia.models.Medico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RequestMapping("/medicos")
public interface MedicosApiController {

    @GetMapping("{idEspecialidad}")
    ResponseEntity<?> getMedicosByEspecialidad(@PathVariable("idEspecialidad") Long idEspecialidad);
}
