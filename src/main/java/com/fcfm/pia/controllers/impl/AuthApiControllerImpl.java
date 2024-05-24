package com.fcfm.pia.controllers.impl;

import com.fcfm.pia.controllers.interfaces.AuthApiController;
import com.fcfm.pia.models.request.LoginRequest;
import com.fcfm.pia.models.request.RegisterRequest;
import com.fcfm.pia.services.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthApiControllerImpl implements AuthApiController {
    private final AuthService authService;

    @Autowired
    public AuthApiControllerImpl(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<?> login(LoginRequest request) {
        try {
            return ResponseEntity.ok(authService.login(request));
        } catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<?> register(RegisterRequest request) {
        try{
            return ResponseEntity.ok(authService.register(request));
        } catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
