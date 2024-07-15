package com.example.foro.domain.topico;

import ch.qos.logback.core.status.Status;
import com.example.foro.extra.Curso;
import com.example.foro.domain.usuarios.Usuario;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        @NotNull Long id,
        String titulo,
        String mensaje,
        Status status,
        Usuario autor,
        Curso curso) {
}
