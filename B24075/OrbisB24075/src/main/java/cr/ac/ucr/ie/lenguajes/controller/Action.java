package cr.ac.ucr.ie.lenguajes.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import cr.ac.ucr.ie.lenguajes.business.AutorBusiness;
import cr.ac.ucr.ie.lenguajes.business.EditorialBusiness;
import cr.ac.ucr.ie.lenguajes.business.LibroBusiness;
import cr.ac.ucr.ie.lenguajes.domain.Autor;
import cr.ac.ucr.ie.lenguajes.domain.Libro;
import cr.ac.ucr.ie.lenguajes.form.LibroForm;


@Controller
public class Action {
	@Autowired
	private LibroBusiness libroBusiness;
	@Autowired
	private AutorBusiness autorBusiness;
	@Autowired
	private EditorialBusiness editorialBusiness;

	@RequestMapping(value = "/insertarLibro", method = RequestMethod.GET)
	public String showForm(LibroForm libroForm, Model model) throws SQLException {
	model.addAttribute("editoriales", editorialBusiness.ListarEditoriales(2, 6));
		model.addAttribute("autores", autorBusiness.ListarAutores(1, 4));
		return "insertarLibro";
	}

	@RequestMapping(value = "/insertarLibro/salvar", method = RequestMethod.POST)
	public String save(@Valid LibroForm libroForm, BindingResult bindingResult, Model model)  throws SQLException{
		if (bindingResult.hasErrors()) {
			model.addAttribute("editoriales", editorialBusiness.ListarEditoriales(2, 6));
			model.addAttribute("autores", autorBusiness.ListarAutores(1, 4));
			return "insertarLibro";
		} else {
			Libro libro = new Libro();
			BeanUtils.copyProperties(libroForm, libro);
			libro.getEditorial().setIdEditorial(libroForm.getIdEditorial());

			for (int i = 0; i < libroForm.getIdAutores().length; i++) {
				Autor autor = new Autor();
				autor.setIdAutor(libroForm.getIdAutores()[i]);
				libro.getAutores().add(autor);
			}
			try {
				libroBusiness.save(libro);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "success";
		}
	}
}
