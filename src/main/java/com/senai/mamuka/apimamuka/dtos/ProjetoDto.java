package com.senai.mamuka.apimamuka.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ProjetoDto(


        @NotBlank String nomeProjeto,

        @NotBlank String statusProjeto,

        LocalDate dataInicio,

        LocalDate dataConclusao,

        String id_gestor


        ) {


}
