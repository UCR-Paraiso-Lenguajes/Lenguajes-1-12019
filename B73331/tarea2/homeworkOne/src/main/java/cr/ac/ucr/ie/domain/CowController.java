package cr.ac.ucr.ie.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.ucr.ie.dataContainer.DataList;
//Tip #5 Nombres de clases en sustantivos
public class CowController {
	private static Logger logger = Logger.getLogger("cr.ac.ucr.ie.homeworkOne.CowController");
	DataList dataList = new DataList();
	//Tip#6 Nombres de funciones, mejor largo y que describa, en lugar de nombres cortos y que no digan nada
	public void insertACow(Cow cowToInsert) {
    		dataList.listOfCows.add(cowToInsert);
	}
	//Tip #7 nombres de metodos que sean verbos o frases con verbos
	//Tip #8 usar nombres para clases y metodos pronunciables, acordes a su funcionalidad y origen
	public void delteACow(int possitionOfTheCow) {
		dataList.listOfCows.remove(possitionOfTheCow);
	}
	public void listAllCows() {
    		int flag = dataList.listOfCows.size()-1;
    		while(flag>-1) {
    			logger.log(Level.INFO,flag+".  "+dataList.listOfCows.get(flag));
    			flag--;
    		}
	}
	public void updateACow(int possitionOfTheCow, Cow cowUpdated) {
		dataList.listOfCows.remove(possitionOfTheCow);
		dataList.listOfCows.add(possitionOfTheCow, cowUpdated);
	}
	/*
	 * Estos dos ultimos tips se ejemplifican en toda la clase, y en general en toda la aplicacion
	 * 
	 * Tip #9 contexto significativo: los nombres de metos y variables deben ser de acuerdo al contexto
	 * Tip #10 Nombre de variables, funciones, claves deben decir por que de la existencia,
	 * que hacen y como se usan
	 * 
	 */
}