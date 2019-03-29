package cr.ac.ucr.ie.lenguajes.business;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ie.lenguajes.data.LibroData;
import cr.ac.ucr.ie.lenguajes.domain.Libro;
@Service
public class LibroBusiness {
	@Autowired
	private LibroData libroData;
	
	public Iterator<Libro> ListarLibros(int inicio,int _final){
		if((_final -inicio)<5) {
			return (Iterator<Libro>) libroData.ListarLibros(inicio, _final);
		}
		throw new RuntimeException("No se pueden mostrar mas de 5 libros a la vez");
	}

}
