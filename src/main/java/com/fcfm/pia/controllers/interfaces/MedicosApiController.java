package com.fcfm.pia.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/medicos")
public interface MedicosApiController {

    @GetMapping
    ResponseEntity<String> getTexto();
}
