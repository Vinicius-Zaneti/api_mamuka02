package com.senai.mamuka.apimamuka.repositories;

import com.senai.mamuka.apimamuka.models.ProjetoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjetoRepository  extends JpaRepository<ProjetoModel, UUID> {
}
