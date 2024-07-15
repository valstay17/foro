package com.example.foro.domain.topico;

import com.example.foro.extra.Respuesta;
import com.example.foro.domain.usuarios.Usuario;
import org.hibernate.engine.spi.Status;

import java.util.Date;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Date fechaCreacion,
        Status status,
        Usuario autor,
        Respuesta respuestas) {
}
