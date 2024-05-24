package com.fcfm.pia.services.impl;

import com.fcfm.pia.models.request.LoginRequest;
import com.fcfm.pia.models.request.RegisterRequest;
import com.fcfm.pia.models.response.AuthResponse;
import com.fcfm.pia.repository.entities.UsuarioEntity;
import com.fcfm.pia.repository.enums.Role;
import com.fcfm.pia.repository.interfaces.UserRepository;
import com.fcfm.pia.services.interfaces.AuthService;
import com.fcfm.pia.services.interfaces.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthResponse login(LoginRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getContra()));

        UserDetails usuario = userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(usuario);

        return new AuthResponse(token);
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        UsuarioEntity usuario = new UsuarioEntity(
                request.getUsername(),
                request.getPassword(),
                Role.USER
        );

        userRepository.save(usuario);

        return new AuthResponse(jwtService.getToken(usuario));
    }
}
