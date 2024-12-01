package br.com.odontofast;

import br.com.odontofast.models.Recepcionista;
import br.com.odontofast.service.RecepcionistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OdontofastApplication implements CommandLineRunner {

	@Autowired
	private RecepcionistaService recepcionistaService;  // Injetando o serviço de Funcionario

	public static void main(String[] args) {
		SpringApplication.run(OdontofastApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}
}
