package com.fcfm.pia.services.interfaces;

import com.fcfm.pia.models.request.LoginRequest;
import com.fcfm.pia.models.request.RegisterRequest;
import com.fcfm.pia.models.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    AuthResponse register(RegisterRequest request);
}