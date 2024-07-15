package com.example.foro.domain.topico;

import com.example.foro.extra.Curso;
import com.example.foro.extra.Respuesta;
import com.example.foro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.engine.spi.Status;

import java.util.Date;
@Table(name = "topicos")
@Entity(name = "Topico")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private Date fechaCreacion;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private Usuario autor;
    @Embedded
    private Curso curso;
    @Embedded
    private Respuesta respuestas;
    private Boolean activo;

    public void cancelar(){
        this.activo = false;
    }


}
