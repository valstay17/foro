package com.example.foro.domain.topico;

import com.example.foro.extra.Curso;
import com.example.foro.domain.usuarios.Usuario;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        Usuario autor,
        Curso curso
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());
    }
}
