package cr.ac.ucr.planDeEstudios.negocios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cr.ac.ucr.planDeEstudios.datos.CursoDatos;

import cr.ac.ucr.planDeEstudios.dominio.Curso;


@Service
public class CursoNegocios {

	@Autowired
	private CursoDatos  cursoDatos;
	

	public List<Curso> listarCursos() {
		return cursoDatos.listarCursos();
	}
	

	public Curso guardar(Curso curso)
	{
		if(curso == null) throw new RuntimeException("El curso es requerida.");
		if(curso.getNombre().length() <= 0 ) throw new RuntimeException("El nombre es requerido");
		if(curso.getSiglas().length() <= 0 ) throw new RuntimeException("La sigla es requerida");
		if(curso.getCreditos() < 0 ) throw new RuntimeException("Los creditos deben ser mayores o iguales a 0");
		if(curso.getIniciaFinal()&&curso.getRequisito().getNombre().length()>=1)throw new RuntimeException("No se debe tener requisitos en cursos Finales o Iniciales");
		if(curso.getNombre().equalsIgnoreCase(curso.getRequisito().getNombre()) ) throw new RuntimeException("No puede ser él mismo como requisito");
				
			
		return cursoDatos.guardar(curso);
	}

	
	
	
	public void actualizar(Curso curso, String sigla) 
	{
		if(curso == null) throw new RuntimeException("El curso es requerida.");
		if(curso.getNombre().length() <= 0 ) throw new RuntimeException("El nombre es requerido");
		if(curso.getSiglas().length() <= 0 ) throw new RuntimeException("La sigla es requerida");
		if(curso.getCreditos() < 0 ) throw new RuntimeException("Los creditos deben ser mayores o iguales a 0");
		if(curso.getNombre().equalsIgnoreCase(curso.getRequisito().getNombre()) ) throw new RuntimeException("No puede ser él mismo como requisito");
			
		cursoDatos.actualizar(curso, sigla);
	}


	public void eliminar(Curso curso, String sigla) {
		if(curso == null) throw new RuntimeException("El curso es requerida.");
		
		cursoDatos.eliminar(curso, sigla);
		
	}
	
	
}
