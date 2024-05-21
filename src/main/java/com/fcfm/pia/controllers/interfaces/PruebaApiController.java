package com.fcfm.pia.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/prueba")
public interface PruebaApiController {

    @GetMapping
    ResponseEntity<String> getTexto();
}
