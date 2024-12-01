package br.com.odontofast.repositories;

import br.com.odontofast.models.Recepcionista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RecepcionistaRepository extends JpaRepository<Recepcionista, Long> {
}

