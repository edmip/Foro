package com.alura.forohub.controller;

import com.alura.forohub.domain.topico.Curso;
import com.alura.forohub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosConsultaTopico(Long id, String titulo,
                                  String mensaje,
                                  LocalDateTime fechaCreacion,
                                  int estatus,
                                  String autor,
                                  Curso curso) {

    public DatosConsultaTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getEstatus(), topico.getAutor(), topico.getCurso());
    }
}
