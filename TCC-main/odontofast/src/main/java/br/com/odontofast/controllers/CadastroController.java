package br.com.odontofast.controllers;

import br.com.odontofast.models.Associado;
import br.com.odontofast.models.Cliente;
import br.com.odontofast.models.Recepcionista;
import br.com.odontofast.service.AssociadoService;
import br.com.odontofast.service.ClienteService;
import br.com.odontofast.service.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping("/cadastros")
public class CadastroController {

    // Injeção de dependência dos serviços
    @Autowired
    private RecepcionistaService recepcionistaService;

    @Autowired
    private AssociadoService associadoService;

    @Autowired
    private ClienteService clienteService;

    // Endpoint para cadastrar um recepcionista
    @PostMapping("/recepcionista")
    public ResponseEntity<Recepcionista> cadastrarRecepcionista(@RequestBody Recepcionista recepcionista) {
        // Salva o recepcionista e retorna a resposta com o status HTTP 201 Created
        Recepcionista salvo = recepcionistaService.salvarRecepcionista(recepcionista);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // Endpoint para cadastrar um associado
    @PostMapping("/associado")
    public ResponseEntity<Associado> cadastrarAssociado(@RequestBody Associado associado) {
        // Salva o associado e retorna a resposta com o status HTTP 201 Created
        Associado salvo = associadoService.salvarAssociado(associado);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // Endpoint para cadastrar um cliente
    @PostMapping("/cliente")
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
        // Salva o cliente e retorna a resposta com o status HTTP 201 Created
        Cliente salvo = clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
