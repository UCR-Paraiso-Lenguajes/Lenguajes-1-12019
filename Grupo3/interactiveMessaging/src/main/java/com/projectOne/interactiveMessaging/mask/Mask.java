package com.projectOne.interactiveMessaging.mask;

import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Mask {
	
	private ArrayList<String> userfakesList;
	private ArrayList<ImageIcon> listOfAvatar;
	
	public Mask() {
		this.userfakesList = new ArrayList<String>();
		this.listOfAvatar = new ArrayList<ImageIcon>();
	}
	
	public void assignNamesUserfakes() {
		userfakesList.add("Frodo");
		userfakesList.add("Darth Vader");
		userfakesList.add("B8");
		userfakesList.add("Pantera Rosa");
		userfakesList.add("Iron Man");
		userfakesList.add("Thanos");
		userfakesList.add("Luke Skywalker");
		userfakesList.add("Yoda");
		userfakesList.add("Chuwi");
		userfakesList.add("Han Solo");
		userfakesList.add("Black Widow");
		userfakesList.add("Jon Snow");
		userfakesList.add("Ned Stark");
		userfakesList.add("Daenerys Targaryen");
		userfakesList.add("Cersei Lannister");
		userfakesList.add("Sauron");
		userfakesList.add("Legolas");
		userfakesList.add("Arwen");
		userfakesList.add("Aragorn");
		userfakesList.add("Gandalf");
		userfakesList.add("Bilbo Bolsón");
		userfakesList.add("Boromir");
		userfakesList.add("Glorfindel");
		userfakesList.add("Leia");
		userfakesList.add("Obi wan kenobi");
		userfakesList.add("R2D2");
		userfakesList.add("C3PO");
		userfakesList.add("Lord Stark");
		userfakesList.add("Thor");
		userfakesList.add("Superman");
		userfakesList.add("Jorah Mormont");
		userfakesList.add("Captain America");
		userfakesList.add("Spider-man");
		userfakesList.add("Loki");
		userfakesList.add("Clint Barton");
		userfakesList.add("Hulk");
		userfakesList.add("Doctor Strange");
		userfakesList.add("Ant-man");
		userfakesList.add("Rocket");
		userfakesList.add("Black Panther");
		userfakesList.add("Wong");
		userfakesList.add("Valquiria");
		userfakesList.add("Witch Scarlet");
		userfakesList.add("Gamora");
		userfakesList.add("Vision");
		userfakesList.add("Winter Soldier");
		userfakesList.add("Nebula");
		userfakesList.add("Mantis");
		userfakesList.add("War machine");
		userfakesList.add("Drax");
	}
	
	
	public ArrayList<String> assignUserfake(int numberOfmembers) {
		ArrayList<String> userFake= new ArrayList<String>();
		for(int i=0;i<userfakesList.size();i++) {
			if(i<numberOfmembers)
				userFake.add(userfakesList.get(i));
			else
				i=userfakesList.size();
		}
		return userFake;
	}
	
	public ArrayList<ImageIcon> assignAvatar(int numberOfMember){
		ArrayList<ImageIcon> avatar = new ArrayList<ImageIcon>();
		for(int i =0; i<listOfAvatar.size();i++) {
			if(i<numberOfMember)
				avatar.add(listOfAvatar.get(i));
			else
				i=listOfAvatar.size();
		}
		return avatar;
	}
	
	
}
