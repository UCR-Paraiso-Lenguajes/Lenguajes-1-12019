package com.orbis.B52265.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.B52265.dao.AutorDao;
import com.orbis.B52265.domain.Autor;

@Service
public class AutorBusiness {
	
	@Autowired
	private AutorDao autordao;
	
 public List<Autor> listarAutores (int inicio, int fin){
	 return autordao.listarAutores(inicio, fin);
 }
}
