package br.com.odontofast.service;

import br.com.odontofast.models.Cliente;
import br.com.odontofast.models.Status;
import br.com.odontofast.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para salvar um novo cliente
    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);  // Salva no banco de dados
    }

    // Método para listar todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();  // Retorna todos os clientes
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);  // Retorna null se não encontrar
    }

    // Método para alterar o status de um cliente
    public Cliente alterarStatusCliente(Long id, Status status) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setStatus(status);  // Atualiza o status
            return clienteRepository.save(cliente);  // Salva o cliente com o novo status
        }
        return null;  // Caso não encontre o cliente
    }
}
