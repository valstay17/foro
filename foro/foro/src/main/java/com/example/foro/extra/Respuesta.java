package com.example.foro.extra;

import com.example.foro.domain.topico.Topico;
import com.example.foro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Table(name = "respuestas")
@Entity(name = "Respuesta")
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @Embedded
    private Topico topico;
    private Date fechaCreacion;
    @Embedded
    private Usuario autor;
    private String solucion;

}
