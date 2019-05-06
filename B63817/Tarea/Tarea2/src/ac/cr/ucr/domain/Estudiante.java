package ac.cr.ucr.domain;

import java.util.ArrayList;
//Tip Cap 2 Distinciones con sentido
// Tip Cap2 Nombre de clase
public class Estudiante {
//Tip Cap2 Usar nombres que se puedan pronunciar	
//Tip Cap2 Evitar codificaciones
	private String nombre;
	private String carnet;
	private String cedula;
	private ArrayList<Asignatura> listaAsignaturas= new ArrayList<Asignatura>();
	
	
	public Estudiante(String nombre, String carnet, String cedula) {
		super();
		if(nombre == null || nombre.trim().equals("")) throw new RuntimeException("El nombre es requerido");
		if(carnet == null || carnet.trim().equals("")) throw new RuntimeException("El carnet es requerido");
		if(cedula == null || cedula.trim().equals("")) throw new RuntimeException("La cedula es requerido");
		this.nombre = nombre;
		this.carnet = carnet;
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}
//Tip Cap3 Hacer una cosa
//Tip Cap3 Tamaño reducido
//Tip Cap3 Hacer una cosa
   public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	 public double calculoPromedio(){
		 double suma = 0.0;
		 for(Asignatura a: listaAsignaturas){
		     suma += a.getCalificacion();
		 }
		 return suma/listaAsignaturas.size();
		    }
	
	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", carnet=" + carnet + ", cedula=" + cedula + "]";
	}

	public ArrayList<Asignatura> getListaAsignaturas() {
		return listaAsignaturas;
	}

	public void setListaAsignaturas(ArrayList<Asignatura> listaAsignaturas) {
		this.listaAsignaturas = listaAsignaturas;
	}

	

	}
	
	
	


