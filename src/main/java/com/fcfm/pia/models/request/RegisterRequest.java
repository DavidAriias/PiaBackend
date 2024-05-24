package com.fcfm.pia.models.request;

public class RegisterRequest {
    private String username;
    private String password;

    public RegisterRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
