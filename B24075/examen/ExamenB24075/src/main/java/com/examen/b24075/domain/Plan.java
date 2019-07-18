package com.examen.b24075.domain;

public class Plan {
 private String nombre;

 

public Plan(String nombre) {
	if(nombre.equals("") ) throw new RuntimeException("Se encuentran datos vacíos");
	this.nombre = nombre;
}


public Plan() {
	this.nombre="";
}



public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}
 

}
