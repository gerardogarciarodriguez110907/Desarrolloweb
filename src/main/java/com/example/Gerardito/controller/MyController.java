package com.example.Gerardito.controller;

import com.example.Gerardito.controller.dto.RequestBodyDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"}) // todos los origenes
@RequestMapping("/my-services")
public class MyController {

    @GetMapping
    public String miPrimerServicio(){
        return "Hello world";
    }

    @GetMapping("/sevicio2")
    public String servicio2(){
        return "segundo servicio";
    }

    @PostMapping
    public String servicio3(){
        return "este es el servicio 3";
    }

    //
    @GetMapping("/path/{id}")
    public String pathvariable(@PathVariable String id){
        return "el path variable es: " + id;

    }

    @PostMapping("/body")
    public ResponseEntity<RequestBodyDTO> body(@RequestBody @Valid RequestBodyDTO payload){
        System.out.println(payload.getEdad());
        System.out.println(payload.getNombre());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(payload);
    }


    // Variable para tu nombre (la respuesta que pide la tarea)
    private final String nombreAlumno = "Gerardo"; // Cámbialo por tu nombre completo si quieres

    // Servicio 1: FizzBuzz
    @GetMapping("/fizzbuzz/{n}")
    public String fizzBuzz(@PathVariable int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
        return nombreAlumno;
    }

    // Servicio 2: Fibonacci
    @GetMapping("/fibonacci/{n}")
    public String fibonacci(@PathVariable int n) {
        if (n >= 1) {
            long a = 0, b = 1;
            for (int i = 0; i < n; i++) {
                System.out.println(a);
                long next = a + b;
                a = b;
                b = next;
            }
        }
        return nombreAlumno;
    }
}




