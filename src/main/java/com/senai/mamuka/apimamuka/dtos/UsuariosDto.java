package com.senai.mamuka.apimamuka.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UsuariosDto(
        @NotBlank String nome,
        @NotBlank String cpf,
        LocalDate dataNascimento,
        Boolean statusAtividade,
        @NotBlank String departamento,
        @NotBlank String responsavel, //temporario
        @NotBlank String perfil,
        @NotBlank String cargo,
        @NotBlank @Email(message = "O email deve estar em um formato válido") String email,
        String id_tipoUsuario, // temporario ?)

        @NotBlank String senha

) {
}
