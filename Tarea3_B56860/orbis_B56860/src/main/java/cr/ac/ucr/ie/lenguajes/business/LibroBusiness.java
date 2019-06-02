package cr.ac.ucr.ie.lenguajes.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ie.lenguajes.data.LibroData;
import cr.ac.ucr.ie.lenguajes.domain.Libro;
@Service
public class LibroBusiness {
	@Autowired
	private LibroData libroData;
	
	public List<Libro> ListarLibros(int inicio,int _final){
		if((_final -inicio)<5) {
			return libroData.ListarLibros(inicio, _final);
		}
		throw new RuntimeException("No se pueden mostrar mas de 5 libros a la vez");
	}

	
	public Libro save(Libro libro) {
		 return libroData.save(libro);
	}
	
}
