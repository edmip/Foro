package com.alura.forohub.controller;

import com.alura.forohub.topico.Curso;
import com.alura.forohub.topico.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
