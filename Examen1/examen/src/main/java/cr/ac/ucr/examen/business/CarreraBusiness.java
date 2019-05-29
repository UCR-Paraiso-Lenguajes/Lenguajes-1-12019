package cr.ac.ucr.examen.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cr.ac.ucr.examen.domain.Carrera;
import cr.ac.ucr.examen.domain.Ciclo;
import cr.ac.ucr.examen.domain.Curso;

@Service
public class CarreraBusiness {
	
	private Carrera carrera;
	
	private ArrayList<Carrera> carreras = new ArrayList<Carrera>();
	

	public Carrera insertar(Carrera carrera)  {

 		carreras.add(carrera);

 		return carrera;
	}

 	public String eliminar(String nombre) {
		for (int i = 0; i < carreras.size(); i++) {
			if (carreras.get(i).getNombre().equals(nombre)) {

				carreras.remove(i);
			}

 		}
		return nombre;
	}

 	public Carrera actualizar(String nombre,Carrera carrera) {
 		for (int i = 0; i < carreras.size(); i++) {
			if (carreras.get(i).getNombre().equals(nombre)) {

				carreras.remove(i);
			}

 		}
 		carreras.add(carrera);
 		return carrera;
	}

 	public List<Carrera> listar(String nombre) {

		for (int i = 0; i < carreras.size(); i++) {
			if (carreras.get(i).getNombre().equals(nombre)) {

 				carrera = carreras.get(i);
			}
		}

 		return carreras;
	}
 	
 	
	public void insertarCursosCarrera(Curso curso,Ciclo c) {
		if(curso == null || c == null ) throw new RuntimeException("Los daatos enivados no pueden ser vacios");
		carrera.insertarCursosCarrera(curso, c);
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	

	
	public List<Curso> estadoInicial() {

 		Curso curso1 = new Curso("Teoria Organizacional", "IF001", 3);
		Curso curso2 = new Curso("Metodo de Investigacion Cualitativo", "IF002", 4);
		Curso curso3 = new Curso("Bases Legales de la Gestion", "IF305", 5);
		Curso curso4 = new Curso("Economia aplicada a la gestion II", "IF304", 4);
		Curso curso5 = new Curso("Taller de Habilidades Gerenciales II", "IF500", 2);
		Curso curso6 = new Curso("Metodo de Investigacion Cualitativo", "IF003", 3);
		Curso curso7 = new Curso("Economia aplicada a la gestion", "IF300", 4);
		Curso curso8 = new Curso("Taller de Habilidades Gerenciales", "IF200", 2);
		Curso curso9 = new Curso("Plan de negocios", "I1003F", 4);
		Curso curso10 = new Curso("Taller de Habilidades Gerenciales", "IF8000", 2);
		Curso curso11 = new Curso("Seminario de Investigacion", "IF8001", 3);
		Curso curso12 = new Curso("Etica para la Gestion", "IF4005", 2);
		Curso curso13 = new Curso("Seminario de Investigacion II", "IF9000", 3);
		Curso curso14 = new Curso("Gestion publica", "IF7001", 3);
		Curso curso15 = new Curso("Gestion Social", "IF550", 3);
		Curso curso16 = new Curso("Gestion de proyectos", "IF1001", 4);
		Curso curso17 = new Curso("Gestion Estrategica", "IF1002", 4);
		Curso curso18 = new Curso("Desarrollo y Responsabilidad Social", "IF9900", 3);

 		ArrayList<Curso> cursos = new ArrayList<Curso>();

 		cursos.add(curso1);cursos.add(curso2);
		cursos.add(curso3);cursos.add(curso4);
		cursos.add(curso5);cursos.add(curso6);
		cursos.add(curso7);cursos.add(curso8);
		cursos.add(curso9);cursos.add(curso10);
		cursos.add(curso11);cursos.add(curso12);
		cursos.add(curso13);cursos.add(curso14);
		cursos.add(curso15);cursos.add(curso16);
		cursos.add(curso17);cursos.add(curso18);
		
		
		return cursos;
	}
}
