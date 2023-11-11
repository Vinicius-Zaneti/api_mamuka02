package com.senai.mamuka.apimamuka.repositories;

import com.senai.mamuka.apimamuka.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TarefaRepository  extends JpaRepository<TarefaModel, UUID> {
}
