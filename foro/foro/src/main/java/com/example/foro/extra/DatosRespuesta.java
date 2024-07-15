package com.example.foro.extra;

import com.example.foro.domain.topico.Topico;
import com.example.foro.domain.usuarios.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosRespuesta(
        @NotBlank
        Long id,
        @NotNull
        String mensaje,
        @NotBlank
        Topico topico,
        @NotBlank
        Date fechaCreacion,
        @NotBlank
        Usuario autor,
        @NotBlank
        String solucion
) {
}
