package com.alura.forohub.infra.security;


import com.alura.forohub.domain.topico.usuarios.Ususario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

        public String generarToken(Ususario usuario){
            try {
                Algorithm algorithm = Algorithm.HMAC256(secret);
                return JWT.create()
                        .withIssuer("foro hub")
                        .withSubject(usuario.getUsuario())
                        .withClaim("id", usuario.getId())
                        //.withExpiresAt(fechaExpiracion())
                        .sign(algorithm);
            } catch (JWTCreationException exception){
                // Invalid Signing configuration / Couldn't convert Claims.
                throw new RuntimeException();
            }
        }

    private Instant fechaExpiracion() {
        return LocalDateTime.now().plusHours(3).toInstant(ZoneOffset.of("-05:00"));
    }
}
