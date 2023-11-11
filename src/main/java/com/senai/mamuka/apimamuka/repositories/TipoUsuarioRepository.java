package com.senai.mamuka.apimamuka.repositories;

import com.senai.mamuka.apimamuka.models.TipoUsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoUsuarioRepository  extends JpaRepository<TipoUsuarioModel, UUID> {
}
