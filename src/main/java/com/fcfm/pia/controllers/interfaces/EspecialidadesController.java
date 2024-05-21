package com.fcfm.pia.controllers.interfaces;

import com.fcfm.pia.models.Especialidad;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/especialidades")
public interface EspecialidadesController {
    @GetMapping("/")
    ResponseEntity<?> getEspecialidades();
}
