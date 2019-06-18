package com.exa.ucr.ac.cr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exa.ucr.ac.cr.Business.PlanEstudiosBusiness;

@SpringBootApplication
public class Examen1B32915Application {

	public static void main(String[] args) {
		
		SpringApplication.run(Examen1B32915Application.class, args);
	
        PlanEstudiosBusiness recover = new PlanEstudiosBusiness();
		
		recover.recoverState();
	
	}

}
