package com.example.foro.extra;

import jakarta.validation.constraints.NotBlank;

public record DatosPerfil(
        @NotBlank
        Long id,
        @NotBlank
        String nombre
) {
}
