package com.alura.forohub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helo")
public class hello {

    @GetMapping
    public String helloWord(){
        return "hola edmi perez";
    }
}
