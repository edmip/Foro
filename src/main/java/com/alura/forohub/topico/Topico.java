package com.alura.forohub.topico;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "topico")

@AllArgsConstructor
@EqualsAndHashCode
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private int estatus;
    private String autor;
    @Enumerated(EnumType.STRING)
    private Curso curso;


    public Topico() {
    }

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo = datosRegistroTopico.titulo();
        this.mensaje = datosRegistroTopico.mensaje();
        this.autor = datosRegistroTopico.autor();
        fechaCreacion = LocalDateTime.now();
        this.estatus = 1;
        this.curso = datosRegistroTopico.curso();

    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public int getEstatus() {
        return estatus;
    }

    public String getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {

        this.titulo = datosActualizarTopico.titulo();
        this.mensaje = datosActualizarTopico.mensaje();
        this.autor = datosActualizarTopico.autor();
        fechaCreacion = LocalDateTime.now();
        this.estatus = 1;
        this.curso = datosActualizarTopico.curso();
    }
}
