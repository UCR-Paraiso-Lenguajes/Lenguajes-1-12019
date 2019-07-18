package com.orbis.b63685.Laboratorio1Orbis;

import java.sql.SQLException;
import java.util.LinkedList;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.orbis.b63685.Laboratorio1Orbis.data.*;
import com.orbis.b63685.Laboratorio1Orbis.domain.Autor;
import com.orbis.b63685.Laboratorio1Orbis.domain.Editorial;
import com.orbis.b63685.Laboratorio1Orbis.domain.Libro;
@SpringBootApplication
public  class Laboratorio1OrbisApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Laboratorio1OrbisApplication.class, args);
		
	}


}
