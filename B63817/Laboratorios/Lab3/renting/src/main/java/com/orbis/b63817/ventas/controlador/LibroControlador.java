package com.orbis.b63817.ventas.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.orbis.b63817.ventas.datos.LibroDatos;
import com.orbis.b63817.ventas.domain.form.LibroForm;
import com.orbis.b63817.ventas.dominio.Autor;
import com.orbis.b63817.ventas.dominio.Editorial;
import com.orbis.b63817.ventas.dominio.Libro;
import com.orbis.b63817.ventas.logica.AutorLogica;
import com.orbis.b63817.ventas.logica.EditorialLogica;
import com.orbis.b63817.ventas.logica.LibroLogica;

@Controller
public class LibroControlador {
	@Autowired
	private LibroLogica libroLogica;
	@Autowired
	private EditorialLogica editorialLogica;
	@Autowired
	private AutorLogica autorLogica;
	@Autowired
	private LibroDatos libroDatos;

	@RequestMapping(value = "/mostrar_libros", method = RequestMethod.GET)
	public String listarLibroes(Model model, @RequestParam("id_Editorial") int id_Editorial) {
		Iterator<Libro> listaLibros = libroLogica.mostrarLibros(id_Editorial);

		if (!libroLogica.mostrarLibros(id_Editorial).hasNext()) {

			String validacion = "La editorial seleccionada no tiene libros asociados";
			model.addAttribute("vacio", validacion);

		} else {

			model.addAttribute("listaLibros", listaLibros);
		}

		return "mostrar_libros";
	}

	@RequestMapping(value = "/insertarLibro", method = RequestMethod.GET)
	public String init(LibroForm libroForm, Model model) {

		Iterator<Editorial> listaEditorial = editorialLogica.listarEditoriales(1, 4);
		Iterator<Autor> listaAutores = autorLogica.mostrarAutores();
		ArrayList<Autor> listaAutoresDelLibro = new ArrayList<>();
		model.addAttribute("listaEditorial", listaEditorial);
		model.addAttribute("listaAutores", listaAutores);
		model.addAttribute("listaAutoresDelLibro", listaAutoresDelLibro);
		model.addAttribute("form", new LibroForm());

		return "insertarLibro";
	}

	@RequestMapping(value = "/insertarLibro/salvar", method = RequestMethod.POST)
	public String save(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) throws SQLException {

		if (bindingResult.hasErrors()) {

			return "error";
		} else {

			int id_libro = libroLogica.insertarLibro(libroForm);

			model.addAttribute("numero", id_libro);
			model.addAttribute("titulo", libroForm.getTitulo());

			return "exito";

		}

	}

}
