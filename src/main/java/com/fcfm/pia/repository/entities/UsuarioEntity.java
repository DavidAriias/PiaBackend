package com.fcfm.pia.repository.entities;

import com.fcfm.pia.repository.enums.Role;

import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String username;
    String password;

    Role role;

    public UsuarioEntity(String username, String password, Role role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public UsuarioEntity(){}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    public Role getRole() {return  this.role; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}