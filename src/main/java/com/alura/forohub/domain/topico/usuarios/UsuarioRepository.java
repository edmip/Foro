package com.alura.forohub.domain.topico.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository  extends JpaRepository<Ususario, Long> {
    UserDetails findByUsuario(String username);
}
