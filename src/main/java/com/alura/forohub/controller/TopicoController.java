package com.alura.forohub.controller;


import com.alura.forohub.topico.DatosActualizarTopico;
import com.alura.forohub.topico.DatosRegistroTopico;
import com.alura.forohub.topico.ITopicoRepositori;
import com.alura.forohub.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private ITopicoRepositori topicoRepository ;


    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        System.out.println(datosRegistroTopico);
        topicoRepository.save(new Topico(datosRegistroTopico));
    }


    @GetMapping
    public Page<DatosConsultaTopico> consultarTopico(@PageableDefault(size = 5, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosConsultaTopico::new);
    }

    @PutMapping("/{id}")
    @Transactional
//    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
//        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
//        topico.actualizarTopico(datosActualizarTopico);
//    }

       public void actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosActualizarTopico){
//       Optional<Topico> topicoOpcional = Optional.ofNullable(topicoRepository.getReferenceById(id));
        Optional<Topico> topicoOpcional = topicoRepository.findById(id);

       if (topicoOpcional.isPresent()){


           Topico topico = topicoOpcional.get();
           System.out.println("el topico encontrado es: " + topico.toString());
           System.out.println("el topico a actualizar es: " + datosActualizarTopico.toString());
           topico.actualizarTopico(datosActualizarTopico);


       }else {
           System.out.println("no existe ese id");
       }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void borrarTopico(@PathVariable Long id){

        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isPresent()){
            Topico topico = optionalTopico.get();
            topicoRepository.deleteById(id);
        }else {
            System.out.println("el topico no existe e la base");
        }

    }



}


