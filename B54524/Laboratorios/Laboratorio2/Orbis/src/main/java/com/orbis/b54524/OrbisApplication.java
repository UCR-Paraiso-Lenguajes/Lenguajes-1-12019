package com.orbis.b54524;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class OrbisApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrbisApplication.class, args);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String encontrarEditoriales(Model model) {
		return "encontrarEditoriales";
	}

}
