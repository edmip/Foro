package com.alura.forohub.topico;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(@NotBlank String titulo,
                                  @NotBlank String mensaje,
                                  @NotBlank String autor,
                                  @NotBlank Curso curso) {
}
