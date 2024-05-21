package com.fcfm.pia.controllers.impl;

import com.fcfm.pia.controllers.interfaces.PruebaApiController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PruebaApiControllerImpl implements PruebaApiController {
    @Override
    public ResponseEntity<String> getTexto() {
        return null;
    }
}
