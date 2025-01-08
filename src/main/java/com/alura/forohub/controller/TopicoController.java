package com.alura.forohub.controller;


import com.alura.forohub.topico.DatosRegistroTopico;
import com.alura.forohub.topico.ITopicoRepositori;
import com.alura.forohub.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private ITopicoRepositori topicoRrepository ;

    @PostMapping
    public void registrarMedico(@RequestBody DatosRegistroTopico datosRegistroTopico){
        System.out.println(datosRegistroTopico);
        topicoRrepository.save(new Topico(datosRegistroTopico));
    }
}
