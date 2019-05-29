package com.examen.b24075.domain;

import java.util.ArrayList;

public class Datos {
	
	
	public static ArrayList<Curso> cursosDatos = new ArrayList<Curso>();
	public static ArrayList<Plan> planesDatos=  new ArrayList<Plan>();

	public static ArrayList<Curso> getCursosDatos() {
		return cursosDatos;
	}

	public static void setCursosDatos(ArrayList<Curso> cursosDatos) {
		Datos.cursosDatos = cursosDatos;
	}

	public static ArrayList<Plan> getPlanesDatos() {
		return planesDatos;
	}


	  
	  
	  
	
}
