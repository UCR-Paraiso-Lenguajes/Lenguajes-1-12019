package com.orbis.B78225.ventas.business;

import com.orbis.B78225.ventas.data.LibroData;
import com.orbis.B78225.ventas.domain.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroBusiness {

    @Autowired
    private LibroData libroDao;

   public Libro save(Libro libro){
    if(libro==null)throw new RuntimeException("El libro es requerido");
    if(libro.getAno()>2019)throw new RuntimeException("El ano no puede ser mayor al actual");
    if(libro.getTitulo().length()>50)throw new RuntimeException("El titulo es demasiado largo");
    if(libro.getEditorial()==null) throw new RuntimeException("La editorial es requerida");
    if(libro.getISBN().length()==13)throw new RuntimeException("El IBSN debe ser de 13 digitos");
    if(libro.getAutores()==null)throw new RuntimeException("Los autores son requerisdos");


    return  libroDao.save(libro);
   }

}
