package cr.ac.ucr.ie.lenguajes.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ie.lenguajes.data.AutorData;
import cr.ac.ucr.ie.lenguajes.domain.Autor;


@Service
public class AutoresBusiness {

	@Autowired
	private AutorData autorData = new AutorData();
	
	public List<Autor> ListarAutores(int inicio,int _final){
		if((_final -inicio)<5) {
			return autorData.ListarAutores(inicio, _final);
		}
		throw new RuntimeException("No se pueden mostrar mas de 5 autores a la vez");
	}
	
}
