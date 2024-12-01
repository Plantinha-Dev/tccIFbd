package br.com.odontofast.controllers;

import br.com.odontofast.models.Associado;
import br.com.odontofast.models.Status;
import br.com.odontofast.service.AssociadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping("/associados")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;

    @PostMapping
    public ResponseEntity<Associado> adicionarAssociado(@RequestBody Associado associado) {
        // Salvar o associado no banco de dados
        Associado salvo = associadoService.salvarAssociado(associado);

        // Retorna a resposta com status HTTP 201 Created e o corpo da resposta com o objeto 'salvo'
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public List<Associado> listarAssociados() {
        return associadoService.listarAssociados();
    }

    @GetMapping("/{id}")
    public Associado buscarAssociado(@PathVariable Long id) {
        return associadoService.buscarAssociado(id);
    }

    @PutMapping("/{id}/status")
    public Associado alterarStatusAssociado(@PathVariable Long id, @RequestParam Status status) {
        return associadoService.alterarStatusAssociado(id, status);
    }
}
