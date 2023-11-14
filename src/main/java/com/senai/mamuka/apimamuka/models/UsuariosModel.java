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
@Table(name = "usuarios_model")
public class UsuariosModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String nome;
    private String cpf;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private LocalDate dataNascimento;
    private Boolean statusAtividade;
    private String departamento;
    private String responsavel; //temporario
    private String perfil;
    private String cargo;
    private String email;
    private String id_tipoUsuario; // temporario ?
    private String senha;

}