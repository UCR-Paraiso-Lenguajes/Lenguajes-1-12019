package com.videocartago.renting.domain;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.videocartago.renting.domain.Genero;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActorTest {
	private Actor actor;
	@Test
	public void actorTest() {
		actor =new Actor(1, "Jeremy", "Fonseca Medez");
		assertTrue(actor.getNombreActor().equals("Jeremy"));
		assertTrue(actor.getCodActor()==1);
	}
}
