package ucr.ac.cr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ucr.ac.cr.logica.CarreraLogica;

@SpringBootApplication
public class Examen1B63817Application {

	public static void main(String[] args) {
		SpringApplication.run(Examen1B63817Application.class, args);
		CarreraLogica carreraLogica= new CarreraLogica();
		carreraLogica.carreraEstudiosEstado();
	}

}
