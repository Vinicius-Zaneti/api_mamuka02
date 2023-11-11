package com.senai.mamuka.apimamuka.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "projeto_model")
public class ProjetoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String nomeProjeto;
    private String statusProjeto;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private String id_gestor; // temporario
}