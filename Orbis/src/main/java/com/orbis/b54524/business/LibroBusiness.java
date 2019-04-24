package com.orbis.b54524.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b54524.datos.LibroDatos;
import com.orbis.b54524.dominio.Libro;

@Service
public class LibroBusiness {
	
	@Autowired
	private LibroDatos libroDatos;
	
	public ArrayList<Libro> listarLibros(int inicioRegistros, int finRegistros, int idEditorial) {
		if(inicioRegistros < 0 && finRegistros > 20) {
			try {
				throw new Exception("rangos no validos");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return libroDatos.listarLibros(inicioRegistros, finRegistros, idEditorial);
	}
	
	public Libro save(Libro libro) throws Exception{
		return libroDatos.save(libro);
	}

}
