package com.fcfm.pia.controllers.interfaces;

import com.fcfm.pia.models.request.LoginRequest;
import com.fcfm.pia.models.request.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthApiController {
    @PostMapping("login")
    ResponseEntity<?> login(@RequestBody LoginRequest request);
    @PostMapping("registro")
    ResponseEntity<?> register(@RequestBody RegisterRequest request);
}
