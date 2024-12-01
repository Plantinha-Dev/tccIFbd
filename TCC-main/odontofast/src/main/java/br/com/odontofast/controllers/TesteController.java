package br.com.odontofast.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teste")
public class TesteController {

    // Endpoint simples para testar a aplicação
    @GetMapping("/hello")
    public String helloWorld() {
        return "Olá, Spring Boot está funcionando!";
    }
}
