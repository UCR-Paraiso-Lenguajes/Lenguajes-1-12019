package cr.ac.ucr.ie.lenguajes.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ie.lenguajes.data.AutorData;
import cr.ac.ucr.ie.lenguajes.domain.Autor;

@Service
public class AutorBusiness {

	@Autowired
	private AutorData autorData = new AutorData();
	
	public List<Autor> ListarAutores(int inicio,int _final){
		if((_final -inicio)<5) {
			return autorData.ListarAutores(inicio, _final);
		}
		throw new RuntimeException("No se pueden mostrar mas de 5 autores a la vez");
	}
	
public List<Autor> buscarAutoresApellidos(String apellidos){
		
		return autorData.buscarAutoresApellidos(apellidos);
	}
	public Autor findAutorById(int codAutor) {
		return autorData.findAutorById(codAutor);
	}
	public void remove(int codAutor) throws SQLException {
		autorData.remove(codAutor);
	}

	public void update(int id, String nombre, String apellido) throws SQLException {
		autorData.update(id,nombre,apellido);
		
	}
	
}