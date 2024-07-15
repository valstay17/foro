package com.example.foro.extra;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank
        Long id,
        @NotBlank
        String nombre,
        @NotBlank
        Categoria categoria
) {
}
