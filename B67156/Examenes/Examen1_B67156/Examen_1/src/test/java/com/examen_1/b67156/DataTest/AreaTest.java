package com.examen_1.b67156.DataTest;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.examen_1.b67156.data.AreaData;
import com.examen_1.b67156.domain.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaTest {
	@Autowired
	AreaData areaData;
	
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
    }

	@Test
	public void cargaAreas_Test() {
	}
	

}
