package cr.ac.ucr.examen.business;

import java.util.List;

import org.springframework.stereotype.Service;

import cr.ac.ucr.examen.domain.Carrera;
import cr.ac.ucr.examen.domain.Ciclo;
import cr.ac.ucr.examen.domain.Curso;

@Service
public class CarreraBusiness {
	
	private Carrera carrera;
	
	

	public void actualizar(String siglas, Carrera carrera) {
		// TODO Auto-generated method stub
		
	}

	public List<Carrera> listar(String siglas) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertar(Carrera carrera) {
		
	}
	
	public void insertarCursosCarrera(Curso curso,Ciclo c) {
		if(curso == null || c == null ) throw new RuntimeException("Los daatos enivados no pueden ser vacios");
		carrera.insertarCursosCarrera(curso, c);
	}
	

	public void eliminar(String siglas) {
		// TODO Auto-generated method stub
		
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	

}
