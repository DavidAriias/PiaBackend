package com.fcfm.pia.models.request;

public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getContra() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
