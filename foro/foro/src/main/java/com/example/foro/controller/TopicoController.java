package com.example.foro.controller;

import com.example.foro.extra.DatosCurso;
import com.example.foro.extra.DatosRespuesta;
import com.example.foro.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico((topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getRespuestas(), new DatosCurso(topico.getId(),
                topico.getCurso().getNombre(), topico.getCurso().getCategoria()), new DatosRespuesta(topico.getRespuestas().getMensaje(),
                topico.getRespuestas().getTopico(), topico.getRespuestas().getFechaCreacion(), topico.getRespuestas().getAutor(),
                topico.getRespuestas().getSolucion()));
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(datosRespuestaTopico);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listaTopico(@PageableDefault(size = 3)Pageable topic){
        return ResponseEntity.ok(topicoRepository.findByTitulo(topic.toString()).map(DatosListadoTopico::new));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.cancelar();
        return ResponseEntity.noContent().build();

    }
    public ResponseEntity<DatosRespuestaTopico> retornarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico((topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getRespuestas(), new DatosCurso(topico.getId(),
                topico.getCurso().getNombre(), topico.getCurso().getCategoria()), new DatosRespuesta(topico.getRespuestas().getMensaje(),
                topico.getRespuestas().getTopico(), topico.getRespuestas().getFechaCreacion(), topico.getRespuestas().getAutor(),
                topico.getRespuestas().getSolucion()));
        return ResponseEntity.ok(datosTopico);
    }

}
