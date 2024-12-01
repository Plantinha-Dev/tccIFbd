package br.com.odontofast.controllers;

import br.com.odontofast.models.Recepcionista;
import br.com.odontofast.models.Status;
import br.com.odontofast.service.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping("/Recepcionista")
public class RecepcionistaController {

    @Autowired
    private RecepcionistaService recepcionistaService;

    // Endpoint para adicionar um novo recepcionista
    @PostMapping
    public Recepcionista adicionarFuncionario(@RequestBody Recepcionista recepcionista) {
        return recepcionistaService.salvarRecepcionista(recepcionista);  // Salva o recepcionista
    }

    // Endpoint para listar todos os recepcionistas
    @GetMapping
    public List<Recepcionista> listarRecepcionista() {
        return recepcionistaService.listarRecepcionista();  // Lista todos os recepcionistas
    }

    // Endpoint para buscar um recepcionista pelo ID
    @GetMapping("/{id}")
    public Recepcionista buscarRecepcionista(@PathVariable Long id) {
        return recepcionistaService.buscarRecepcionista(id);  // Busca um recepcionista pelo ID
    }

    // Endpoint para alterar o status de um recepcionista
    @PutMapping("/{id}/status")
    public Recepcionista alterarStatusRecepcionista(@PathVariable Long id, @RequestParam Status status) {
        return recepcionistaService.alterarStatusRecepcionista(id, status);  // Altera o status do recepcionista
    }
}
