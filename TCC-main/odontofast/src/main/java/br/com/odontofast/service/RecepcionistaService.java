package br.com.odontofast.service;

import br.com.odontofast.models.Recepcionista;
import br.com.odontofast.models.Status;
import br.com.odontofast.repositories.RecepcionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecepcionistaService {

    @Autowired
    private RecepcionistaRepository recepcionistaRepository;

    // Método para salvar um novo recepcionista
    public Recepcionista salvarRecepcionista(Recepcionista recepcionista) {
        return recepcionistaRepository.save(recepcionista);  // Salva o recepcionista no banco de dados
    }

    // Método para listar todos os recepcionistas
    public List<Recepcionista> listarRecepcionista() {
        return recepcionistaRepository.findAll();  // Retorna todos os recepcionistas
    }

    // Método para buscar um recepcionista pelo ID
    public Recepcionista buscarRecepcionista(Long id) {
        Optional<Recepcionista> recepcionista = recepcionistaRepository.findById(id);
        return recepcionista.orElse(null);  // Retorna null caso não encontre o recepcionista
    }

    // Método para alterar o status de um recepcionista
    public Recepcionista alterarStatusRecepcionista(Long id, Status status) {
        Optional<Recepcionista> recepcionistaOptional = recepcionistaRepository.findById(id);
        if (recepcionistaOptional.isPresent()) {
            Recepcionista recepcionista = recepcionistaOptional.get();
            recepcionista.setStatus(status);  // Atualiza o status do recepcionista
            return recepcionistaRepository.save(recepcionista);  // Salva no banco de dados
        }
        return null;  // Caso o recepcionista não seja encontrado
    }
}
