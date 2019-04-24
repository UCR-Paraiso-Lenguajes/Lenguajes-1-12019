package com.videocartago.renting.domain;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActorTest {

	@Test
	public void probarActor() {
		Actor actor = new Actor(1,"Mike","Myers");
		actor.setCodActor(2);
		actor.setNombreActor("Anne");
		actor.setApellidosActor("Heche");
		actor.getCodActor();
		actor.getNombreActor();
		actor.getApellidosActor();
		assertNotNull(actor);
		assertTrue(!actor.equals(""));
	}
}
