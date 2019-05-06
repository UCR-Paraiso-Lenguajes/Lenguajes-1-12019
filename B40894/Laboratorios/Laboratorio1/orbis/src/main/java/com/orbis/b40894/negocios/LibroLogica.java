package com.orbis.b40894.negocios;
import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.orbis.b40894.datos.LibroDatos;
import com.orbis.b40894.dominio.Libro;

@Service
public class LibroLogica {
@Autowired
	private LibroDatos libroDao;
	
	public Iterator<Libro> buscarLibro(int cantidadIncio,int cantidadFin,int idEditorial) {
		return libroDao.buscarLibro(cantidadIncio, cantidadFin, idEditorial);
	}
}






