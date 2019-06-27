package com.orbis.B78225.ventas.business;

import com.orbis.B78225.ventas.data.AutorData;
import com.orbis.B78225.ventas.domain.Autor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutorBusiness {


    @Autowired
    private AutorData autorData;

    public List<Autor> listarAutor(int inicio, int fin){

        return autorData.listarAutores(inicio, fin);
    }

}
