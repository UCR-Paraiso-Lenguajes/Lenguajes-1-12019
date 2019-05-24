package com.orbis.b62734.Laboratorio1Orbis.business;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.b62734.Laboratorio1Orbis.data.AutorDao;
import com.orbis.b62734.Laboratorio1Orbis.domain.*;


@Service
public class AutorBusiness {

 @Autowired
 private AutorDao autorData;
 
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
public List<Autor>  buscarAutorApellido(String apellido) {
	  return autorData.buscarAutorApellido(apellido);
	
}
 
}
