package com.orbis.b63685;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OrbisApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrbisApplication.class, args);
	}
	
	@RequestMapping(value="")
	public String home() {
		return "helloWorld!!";
	}
	
	

}
