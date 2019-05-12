package com.projectOne.interactiveMessaging.mask;

import java.util.ArrayList;
import java.util.Queue;

import com.projectOne.interactiveMessaging.tda.Nodo;
import com.projectOne.interactiveMessaging.tda.QueueException;
import com.projectOne.interactiveMessaging.tda.QueueLinked;

public class Mask {
	
	private ArrayList<String> userfakes;
	private QueueLinked tail;
	
	public Mask() {
		this.userfakes = new ArrayList<String>();
		this.tail = new QueueLinked();
	}
	
	public void assignNamesUserfakes() {
		userfakes.add("Frodo");
		userfakes.add("Darth Vader");
		userfakes.add("Luke");
		userfakes.add("Pantera Rosa");
		userfakes.add("Iron Man");
		userfakes.add("Thanos");
		userfakes.add("Luke Skywalker");
		userfakes.add("Yoda");
		userfakes.add("Chuwi");
		userfakes.add("Han Solo");
		userfakes.add("Black Widow");
		userfakes.add("Jon Snow");
		userfakes.add("Ned Stark");
		userfakes.add("Daenerys Targaryen");
		userfakes.add("Cersei Lannister");
		userfakes.add("Sauron");
		userfakes.add("Legolas");
		userfakes.add("Arwen");
		userfakes.add("Aragorn");
		userfakes.add("Gandalf");
		userfakes.add("Bilbo Bolsón");
		userfakes.add("Boromir");
		userfakes.add("Glorfindel");
		userfakes.add("Leia");
		userfakes.add("Obi wan kenobi");
		userfakes.add("R2D2");
		userfakes.add("C3PO");
		userfakes.add("Lord Stark");
		userfakes.add("Thor");
		userfakes.add("Superman");
		userfakes.add("Jorah Mormont");
		userfakes.add("Captain America");
		userfakes.add("Spider-man");
		userfakes.add("Loki");
		userfakes.add("Clint Barton");
		userfakes.add("Hulk");
		userfakes.add("Doctor Strange");
		userfakes.add("Ant-man");
		userfakes.add("Rocket");
		userfakes.add("Black Panther");
		userfakes.add("Wong");
		userfakes.add("Valquiria");
		userfakes.add("Witch Scarlet");
		userfakes.add("Gamora");
		userfakes.add("Vision");
		userfakes.add("Winter Soldier");
		userfakes.add("Nebula");
		userfakes.add("Mantis");
		userfakes.add("War machine");
		userfakes.add("Drax");
		for(int i=0;i<userfakes.size();i++) {
			tail.queueUp(userfakes.get(i));
		}
	}
	
	
	public String assignUserfake() {
		String userFake="";
		userFake = (String) tail.uncoil();
		return userFake;
	}
	
	public void removeUserFake(String userFake) throws QueueException {
		QueueLinked tailAux = new QueueLinked();
		tailAux.queueUp(userFake);
		for(int i=0; i< tail.getSize(); i++) {
			tailAux.queueUp(tail.uncoil());
		}
		tail.annul();
		tail = tailAux;
	}
	
}
