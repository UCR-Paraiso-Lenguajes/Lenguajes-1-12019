package com.orbis.b63817.ventas.controlador;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orbis.b63817.ventas.dominio.Autor;
import com.orbis.b63817.ventas.logica.AutorLogica;

@RestController
public class AutorControlarRest {

	@Autowired
	private AutorLogica autorLogica;

	@RequestMapping(value = "/api/editar/{id_autor}", method = RequestMethod.PUT)
	public @ResponseBody void actualizarAutor(@PathVariable int id_autor, @RequestBody Autor autor) {
		System.out.println(autor.toString());
		System.out.println(id_autor);
		autorLogica.update(id_autor, autor);
	}

	@RequestMapping(value = "/api/borrar/{id_autor}", method = RequestMethod.DELETE)
	public @ResponseBody void borrarAutor(@PathVariable int id_autor) {
		System.out.println(id_autor);
		autorLogica.delete(id_autor);
	}

}

