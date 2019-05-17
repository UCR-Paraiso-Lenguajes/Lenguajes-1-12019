package com.chat.bussines;

import java.util.ArrayList;
import java.util.Random;

public class UserBussines {
	
	private ArrayList<String> feelingsArrayList = new ArrayList<String>();
	
	private String names[] = {"Insecure","Nervous","Tense","Anxious","Angry","Confused","Weak","Petrified","Tense","Horrified",
	"Inadequate","Flat","Motivade","Surprised","Satisfied","Upset","Miserable","Sad","Foolish","Discontented",
	"Wonderful","Proud","Energetic","Hopeful","Loving","Lonely","Mixep-Up","Surprised","Weepy","Tearful",
	"Miserable","Shocked","Frustrated","Disgust","Anger","Amusement","Distress","Embarrassment","sympathy"};
	
	String[] animals = { "bee", "eagle", "spider", "wasp", "whale", "bison", "buffalo", "donkey", "horse", "camel",
			"canary", "crab", "kangaroo", "snail", "zebra", "pig", "chimpanzee", "deer", "swan", "crocodile",
			"elephant", "beetle", "scorpion", "seal", "hen", "cock", "cat", "swallow", "hippopotamus", "ant",
			"wild boar", "giraffe", "lion", "parrot", "fly", "mosquito", "bear", "sheep", " partridge", "dog",
			"penguin", "chick", "grasshoppers", "snake", "tiger", "mole", "bull", "turtle", "cow", "fox" };
	
	public void createUsers() {
		
		Random r = new Random();
		
		int min=0;
		int max=49;
		
		for (int i = 0; i < animals.length; i++) {
		
		int valueAnimal = r.nextInt((max - min) + 1) + min;
		int valueNames  = r.nextInt((max - min) + 1) + min;
	
		String userFake = names[valueNames]+" "+animals[valueAnimal];
			
			feelingsArrayList.add(userFake);
		}
		
		feelingsArrayList.toString();
		
	}

}
