package com.orbis.b53953;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Prueba1Application {

	public static void main(String[] args) {
		SpringApplication.run(Prueba1Application.class, args);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String encontrarEditoriales(Model model) {
		
		return "encontrarEditoriales";
	}

}
