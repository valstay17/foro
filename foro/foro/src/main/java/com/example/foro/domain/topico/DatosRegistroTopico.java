package com.example.foro.domain.topico;

import ch.qos.logback.core.status.Status;
import com.example.foro.extra.Curso;
import com.example.foro.domain.usuarios.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotNull
        String mensaje,
        @NotBlank
        Date fechaCreacion,
        @NotBlank
        Status status,
        @NotNull
        Usuario autor,
        @NotNull
        Curso curso
) {
}
