package com.orbis.b62734.Laboratorio1Orbis.data;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.orbis.b63685.Laboratorio1Orbis.data.LibroDao;
import com.orbis.b63685.Laboratorio1Orbis.domain.Autor;
import com.orbis.b63685.Laboratorio1Orbis.domain.Editorial;
import com.orbis.b63685.Laboratorio1Orbis.domain.Libro;
@RunWith(SpringRunner.class)
@SpringBootTest
public class LibroDaoTest {
	
	@Autowired
	private LibroDao libroDao;
	@Test
	public void test() throws SQLException {
		LinkedList<Autor> autores=new LinkedList<Autor>();
		Editorial editorial=new Editorial(1,"meme","detras de la escuela","85440786");
		Libro libro=new Libro(1,"el resplandor",(short)1998,1000,autores,editorial);
		libroDao.save(libro);
	}

}
