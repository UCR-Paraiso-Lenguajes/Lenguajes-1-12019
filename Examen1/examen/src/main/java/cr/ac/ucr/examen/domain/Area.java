package cr.ac.ucr.examen.domain;

import java.util.ArrayList;
import java.util.Stack;


public class Area {
	
	private Stack<ArrayList<Curso>> areas = new Stack<>();

	
	public Stack<ArrayList<Curso>> getAreas() {
		return areas;
	}

	public void setAreas(Stack<ArrayList<Curso>> areas) {
		this.areas = areas;
	}
	
	
	
	
}
