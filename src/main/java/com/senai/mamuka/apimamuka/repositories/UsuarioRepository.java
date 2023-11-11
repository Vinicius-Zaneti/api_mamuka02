package com.senai.mamuka.apimamuka.repositories;

import com.senai.mamuka.apimamuka.models.UsuariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuariosModel, UUID> {
    UsuariosModel findByEmail(String email);
}