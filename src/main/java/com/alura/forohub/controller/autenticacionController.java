package com.alura.forohub.controller;


import com.alura.forohub.domain.topico.usuarios.Ususario;
import com.alura.forohub.domain.usuarios.DatosAutenticacionUsuario;
import com.alura.forohub.infra.security.DatosJWTtoken;
import com.alura.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class autenticacionController {

    @Autowired
    private AuthenticationManager autenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){

        Authentication athToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.usuario(), datosAutenticacionUsuario.clave());


        var usuarioAutenticado = autenticationManager.authenticate(athToken);
        var JWTtoken = tokenService.generarToken((Ususario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken) );
    }
}
