package br.com.odontofast.service;


import br.com.odontofast.models.Associado;
import br.com.odontofast.models.Status;
import br.com.odontofast.repositories.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository associadoRepository;


    // Método para salvar um novo associado
    public Associado salvarAssociado(Associado associado) {
        return associadoRepository.save(associado);
    }

    // Método para listar todos os associados
    public List<Associado> listarAssociados() {
        return associadoRepository.findAll();
    }

    // Método para buscar um associado por ID
    public Associado buscarAssociado(Long id) {
        Optional<Associado> associado = associadoRepository.findById(id);
        return associado.orElse(null);  // Retorna null se não encontrar
    }

    // Método para alterar o status de um associado
    public Associado alterarStatusAssociado(Long id, Status status) {
        Optional<Associado> associadoOptional = associadoRepository.findById(id);
        if (associadoOptional.isPresent()) {
            Associado associado = associadoOptional.get();
            associado.setStatus(status);
            return associadoRepository.save(associado);  // Salva o associado com o novo status
        }
        return null;  // Caso não encontre o associado
    }

}




