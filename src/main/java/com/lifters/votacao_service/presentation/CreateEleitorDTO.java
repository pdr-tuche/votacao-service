package com.lifters.votacao_service.presentation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEleitorDTO(
        @NotNull(message = "o campo 'nome' nao pode ter valor null.")
        @NotBlank(message = "o campo 'nome' nao pode ter valor em branco.")
        String nome,
        @NotNull(message = "o campo 'cpf' nao pode ter valor null.")
        @NotBlank(message = "o campo 'cpf' nao pode ter valor em branco.")
        String cpf) {
}
