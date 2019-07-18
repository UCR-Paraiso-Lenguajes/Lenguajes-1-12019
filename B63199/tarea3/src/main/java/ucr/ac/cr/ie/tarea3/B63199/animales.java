package ucr.ac.cr.ie.tarea3.B63199;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.omg.CORBA.ExceptionList;
import org.springframework.core.ExceptionDepthComparator;
import org.springframework.util.ExceptionTypeFilter;

public class animales {

	private String nombre;
	private String dueno;
	private int edad;
	private float estatura;
	
	private ArrayList<Object> animalesDuenno= new ArrayList<Object>();
	
	public animales() {
		
	}

	//Define Exception Classes pág. 108
	public boolean verificarNombreAnimal(String nombre) {
		try {
			nombreAnimal(nombre);
		}catch (Exception e) {
			throw new Exception("Error");}
		catch (ExceptionInInitializerError p) {
			throw new Exception("Error");}
		finally {
			return false;
		}
	}		
	
	public boolean nombreAnimal(String nombreAnimal) {
		if(!nombreAnimal.equals(null)) {
			return true;
		}else
		return false;
	}
	
	//Don't return null pág 110
	public void registrarMascota(String nombre, String dueno) {
		if(nombre !=null) {
			nombre="sin nombre";
		}if (dueno!=null) {
			dueno="sin dueno";
		}else
			JOptionPane.showMessageDialog(null, "Mascota ya registrada");
	}
	
	//Don't pass null pág 112
	public void registrarDueno(String dueno, String mascota) {
		registrar(null, mascota, 2);
	}
	
	public boolean registrar(String dueno, String mascota, int edad) {
		boolean registrar = true;
		return registrar;
	}
	
}
