package com.senai.mamuka.apimamuka.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record TarefaDto(

        @NotBlank String nomeTarefa,

        @NotBlank String statusTarefa,

        LocalDate dataInicio,

        LocalDate dataConclusao,

        String id_dev,

        @NotBlank String id_projeto

) {
}
