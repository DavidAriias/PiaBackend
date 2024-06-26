package com.fcfm.pia.repository.interfaces;


import com.fcfm.pia.repository.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsuarioEntity,Integer> {
    Optional<UsuarioEntity> findByUsername(String username);
}