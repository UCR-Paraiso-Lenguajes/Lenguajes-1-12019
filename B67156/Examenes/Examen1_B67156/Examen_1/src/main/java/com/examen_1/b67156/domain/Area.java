package com.examen_1.b67156.domain;

public class Area {
	
	private String nombreArea;
	private String carrera;
	private Curso matrizRelaciones [][];
	
	
	
	 public Area(String nombreArea, String carrera) {
		this.nombreArea = nombreArea;
		this.carrera = carrera;
		this.matrizRelaciones = new Curso[3][6];
		cargaMatriz();
	}


	 private void cargaMatriz() {
			for (int x = 0; x < matrizRelaciones.length;x++) {
				for (int y = 0; y < matrizRelaciones[x].length; y++) {
					matrizRelaciones[x][y] = null;
					
				}
			}
	 }

	public void insertarRelaciones(Curso curso) {
		int fila = 0;
		int columna = curso.getCiclo();
		while(this.matrizRelaciones[fila][columna] != null) {
			fila+=1;
		}
		 this.matrizRelaciones[fila][columna] = curso;

	}
	
	public int cantidadDeCursos () {
		//TODO define la cantidad de cursos que tiene
		return 0;
	}
	
	public int totalDeCreditos() {
		//TODO define la cantidad de creditos
		return 0;
	}

}
