package ucr.ac.cr.ie.tarea3.B63199;

import java.awt.print.PrinterIOException;
import java.io.File;
import java.util.ArrayList;

public class Frutos {
	
	//The law of demeter
	private String demeter;
	private String color;
	private String tamano;
	
	
	public Frutos() {
		
	}
	
	//Data Object/anty-symmetry pág 95
	//No orientado a objetos
	public String tipo(String fruto) {
		String tipo="sin categoria";
		if(fruto.equals("Naranja")) {
			tipo="citrico";
		}else
		if(fruto.equals("Oregano")) {
			tipo="especia";
		}else
		if(fruto.equals("Cereza")) {
			tipo="baya";
		}
		return tipo;
	}
	
	//Orientado a objetos pág 96
	@SuppressWarnings("finally")
	public String tipoFruta(String fruto) {
		if(fruto!=null) {
	//Use Exceptions Rather Than Return Codes pág. 104 
	// Use  try-catch-finally pág 106
    //Correcto:
			try {
				return obtenerTipo(fruto).get(1);
				} catch (Exception e) {
					throw new Exception("Error");}
			finally {
				return "El nombre del fruto no está en el sistema";
			}			
			}
		else
			//Use Exceptions Rather Than Return Codes pág. 104 
			//Incorrecto:
			System.out.println("El fruto ha venido en blanco");
		return "";
	}
	
	public ArrayList<String> obtenerTipo(Object planta) {
		ArrayList<String> tipos = new ArrayList<String>();
		
		//agregar los tipos. . . 
		tipos.add("Citrico");
		tipos.add("especia");
		tipos.add("baya");
		
		return tipos;
	}
	
	//The Law of demeter pág 98
	public String averiguaRuta(Object objeto) {
		final String outputDir="";
		//outputDir= ((Object) objeto).getOptions().getScratchDir().getAbsolutePath();
		return outputDir;
		
		
		//pág 98 Train Wrecks
		/*
		Object opts = ctxt.getOptions();
		File scratchDir = opts.getScratchDir();
		final String outputDire = scratchDir.getAbsolutePath();
		*/
	}
	
}
	

