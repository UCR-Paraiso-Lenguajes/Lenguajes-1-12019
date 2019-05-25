package cr.ac.ucr.ie.lenguajes.business;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cr.ac.ucr.ie.lenguajes.data.AutorData;
import cr.ac.ucr.ie.lenguajes.domain.Autor;


@Service
public class AutorBusiness {

 @Autowired
 private AutorData autorData;
 
 public List<Autor> buscarAutor() {
  return autorData.buscarAutores();
 }
 public Autor buscarAutorId(int id) {
	  return autorData.buscarAutorId(id).get(0);
	 }
 public void actualizarAutor(int id,Autor autor) {
	  autorData.actualizarAutor(autor);
	 }
 public void eliminarAutor(int id) {
	   autorData.eliminarAutor(id);
	 }
 public List<Autor> ListarAutoresPorApellido(String apellido){
		if(apellido == null || apellido.trim().equalsIgnoreCase("1")
							|| apellido.trim().equalsIgnoreCase("2")
							|| apellido.trim().equalsIgnoreCase("3")
							|| apellido.trim().equalsIgnoreCase("4")
							|| apellido.trim().equalsIgnoreCase("5")
							|| apellido.trim().equalsIgnoreCase("6")
							|| apellido.trim().equalsIgnoreCase("7")
							|| apellido.trim().equalsIgnoreCase("8")
							|| apellido.trim().equalsIgnoreCase("9")
							|| apellido.trim().equalsIgnoreCase("0")) throw new RuntimeException("Debe contener letras");
			return autorData.buscarAutorApellido(apellido);
		
	}
 
}
