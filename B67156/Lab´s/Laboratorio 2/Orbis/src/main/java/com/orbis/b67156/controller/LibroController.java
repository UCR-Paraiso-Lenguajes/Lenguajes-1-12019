package com.orbis.b67156.controller;

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

import com.orbis.b67156.business.LibroBusiness;
import com.orbis.b67156.data.AutorData;
import com.orbis.b67156.data.EditorialData;
import com.orbis.b67156.data.LibroData;
import com.orbis.b67156.domain.Autor;
import com.orbis.b67156.domain.Editorial;
import com.orbis.b67156.domain.Libro;
import com.orbis.b67156.domain.Libro_Autor;
import com.orbis.b67156.form.LibroForm;

@Controller
public class LibroController {

	@Autowired
	private LibroData libroNegocios;
	@Autowired
	private EditorialData editorialNegocios;
	@Autowired
	private AutorData autorNegocios;
	
	@RequestMapping(value="/VerLibros", method=RequestMethod.GET )
	public String iniciar(Model model) {
		return "VerLibros";
	}
	
	@RequestMapping(value="/VerLibros2", method=RequestMethod.GET )
	public String mostrar_libros(Model model, @RequestParam("id_editorial")String idEditorial){
		int idEditorialTemp = Integer.parseInt(idEditorial);
		model.addAttribute("libro", libroNegocios.buscarPorEditorial(idEditorialTemp));
		return "VerLibros";
	}
	

	@RequestMapping(value="/insertarLibro", method=RequestMethod.GET )
	public String insertar(LibroForm libroForm, Model model) {
		List<Autor> autores = autorNegocios.buscarPorBloque(0, 999999);
		Iterator<Editorial>  editoriales = editorialNegocios.buscarPorBloque(0, 999999);
		model.addAttribute("autores",autores);
		model.addAttribute("editoriales",editoriales);
		model.addAttribute("libroForm", new LibroForm());
		return "insertarLibro";
		
	}
	

	@RequestMapping(value="/insertarLibro", method=RequestMethod.POST )
	public String insertarLibroP(@Valid LibroForm libroForm, BindingResult bindingResult, Model model) {
		/*if(bindingResult.hasErrors()) {
	
			List<Autor> autores = autorNegocios.buscarAutores(0, 999999);
			Iterator<Editorial> editoriales = editorialNegocios.searchPorEditorialRango(0, 999999);
			model.addAttribute("autores",autores);
			model.addAttribute("editoriales",editoriales);
		return "insertarLibro";
		
		}else {*/
			Libro libro = new Libro();
			BeanUtils.copyProperties(libroForm, libro);
			libro.setId(libroForm.getId_editorial());
			libro.setTitulo(libroForm.getTitulo());
			libro.setAno((short)libroForm.getAno());
			libro.setId(libroForm.getId_libro());
			libro.setPrecio(libroForm.getPrecio());
			Libro_Autor libroAutor = new Libro_Autor(libro.getId(), getListInt(libroForm.getAutores()));
			libroNegocios.save(libro, libroAutor);
		
			List<Autor> autores = autorNegocios.buscarPorBloque(0, 999999);
			Iterator<Editorial> editoriales = editorialNegocios.buscarPorBloque(0, 999999);
			model.addAttribute("autores",autores);
			model.addAttribute("editoriales",editoriales);
			return "insertarLibro";
		//}
	
	}
	private List<Integer> getListInt(String[] listFromWeb){
		List<Integer> lista = new ArrayList<>();
		for (int i = 0; i < listFromWeb.length; i++) {
			lista.add(Integer.parseInt(listFromWeb[i]));
		}
		return lista;
	
	}
}
