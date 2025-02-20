package com.lifters.votacao_service.presentation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCargoDTO(
        @NotBlank(message = "O campo 'nome' é obrigatório.")
        @NotNull(message = "O campo 'nome' é obrigatório")
        String nome) {
}
