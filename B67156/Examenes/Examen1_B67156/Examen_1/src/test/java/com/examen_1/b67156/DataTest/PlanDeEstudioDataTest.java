package com.examen_1.b67156.DataTest;

import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.examen_1.b67156.data.PlanDeEstudioData;
import com.examen_1.b67156.domain.PlanDeEstudio;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanDeEstudioDataTest {
	@Autowired
	PlanDeEstudioData planData;
	PlanDeEstudio planestudio;
	
	@Before
    public void setUp() {
    //Inicialización de variables antes de cada Test
		planestudio = planData.cargaPlanDeEstudio("info");
    }

	@Test
	public void cargaCursos_Test() {
		assertNotNull(planestudio);
	}

}
