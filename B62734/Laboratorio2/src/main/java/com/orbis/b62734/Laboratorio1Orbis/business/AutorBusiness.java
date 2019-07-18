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
 
 public List<Autor> buscarautor() {
  return autorData.buscarAutores();
 }
}
