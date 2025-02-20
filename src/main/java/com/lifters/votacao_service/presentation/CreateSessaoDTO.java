package com.lifters.votacao_service.presentation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateSessaoDTO(
        @NotBlank(message = "o campo 'nome' não pode ser em branco.")
        @NotNull(message = "o campo 'nome' nao pode ter valor null")
        String nome
) {
}
