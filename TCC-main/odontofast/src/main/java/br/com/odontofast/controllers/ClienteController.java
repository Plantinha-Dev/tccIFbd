package br.com.odontofast.controllers;

import br.com.odontofast.models.Cliente;
import br.com.odontofast.models.Status;
import br.com.odontofast.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost")
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para adicionar um novo cliente
    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);  // Chama o service para salvar o cliente
    }

    // Endpoint para listar todos os clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();  // Chama o service para listar todos os clientes
    }

    // Endpoint para buscar um cliente por ID
    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return clienteService.buscarCliente(id);  // Chama o service para buscar um cliente pelo ID
    }

    // Endpoint para alterar o status de um cliente
    @PutMapping("/{id}/status")
    public Cliente alterarStatusCliente(@PathVariable Long id, @RequestParam Status status) {
        return clienteService.alterarStatusCliente(id, status);  // Chama o service para alterar o status
    }
}
