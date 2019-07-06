package cr.ac.ucr.planDeEstudios.datos;

import java.util.ArrayList;

import java.util.List;


import org.springframework.stereotype.Repository;

import cr.ac.ucr.planDeEstudios.dominio.Curso;
import cr.ac.ucr.planDeEstudios.dominio.Requisito;

@Repository
public class CursoDatos {

	private List<Curso> cursosCreados = new ArrayList<Curso>();
	
	Curso curso1 = new Curso("Teoria Organizacional", "TO", 3, true); 		
	Curso curso2 = new Curso("Metodos de Investigacion Cualitativa", "MIC", 4, true); 		
	Curso curso3 = new Curso("Economía Aplicada a la Gestión", "EAG", 4, true); 		
	Curso curso4 = new Curso("Taller de Habilidades Gerenciales", "THG",2, true);
	Requisito requisito1 = new Requisito(curso2.getNombre(),curso2.getSiglas(),curso2.getCreditos());
	Curso curso5 = new Curso("Bases Legales para la Gestión", "BLG", 5, requisito1, false);
	Requisito requisito2 = new Requisito(curso3.getNombre(),curso3.getSiglas(),curso3.getCreditos());
	Curso curso6 = new Curso("Economia  Aplicada a la Gestión II", "EAG2", 4, requisito2, false);
	Requisito requisito3 = new Requisito(curso4.getNombre(),curso4.getSiglas(),curso4.getCreditos());
	Curso curso7 = new Curso("Taller de Habilidades Gerenciales II", "THG2", 2, requisito3, false);
	Requisito requisito4 = new Requisito(curso1.getNombre(),curso1.getSiglas(),curso1.getCreditos());
	Curso curso8 = new Curso("Gestión Pública", "GP", 3, requisito4, false);
	Curso curso9 = new Curso("Gestión Social", "GS", 3, false);
	Curso curso10 = new Curso("Gestión de Proyectos", "GP", 4, false);
	Requisito requisito5 = new Requisito(curso8.getNombre(),curso8.getSiglas(),curso8.getCreditos());
	Curso curso11= new Curso("Gestion Estrategica", "GE", 4, requisito5 ,false);
	Requisito requisito6 = new Requisito(curso7.getNombre(),curso7.getSiglas(),curso7.getCreditos());
	Curso curso12= new Curso("Taller de Habilidades Gerenciales III", "THG3", 2, requisito6 ,false);
	Curso curso13= new Curso("Plan de Negocios", "PN", 4, true);
	Requisito requisito7 = new Requisito(curso5.getNombre(),curso5.getSiglas(),curso5.getCreditos());
	Curso curso14= new Curso("Seminario de Investigacion", "SI", 3, requisito7 ,false);
	Curso curso15= new Curso("Etica para la Gestion", "EPG", 2, true);
	Requisito requisito8 = new Requisito(curso14.getNombre(),curso14.getSiglas(),curso14.getCreditos());
	Curso curso16= new Curso("Seminario de Investigacion II", "SI2",4, requisito8 ,true);
	Requisito requisito9 = new Requisito(curso15.getNombre(),curso15.getSiglas(),curso15.getCreditos());
	Curso curso17= new Curso("Desarrollo y Responsabilidad Social", "DRS",3, requisito9 ,true);
	
	private boolean llenarLista=true;
	
	public List<Curso> listarCursos() {
		
	if(llenarLista) {
		return listarCursosQuemados();
	}else {	
		
		return cursosCreados;
	}
	
	}

	private List<Curso> listarCursosQuemados() {
	cursosCreados.add(curso1);
	cursosCreados.add(curso2);
	cursosCreados.add(curso3);
	cursosCreados.add(curso4);
	cursosCreados.add(curso5);
	cursosCreados.add(curso6);
	cursosCreados.add(curso7);
	cursosCreados.add(curso8);
	cursosCreados.add(curso9);
	cursosCreados.add(curso10);
	cursosCreados.add(curso11);
	cursosCreados.add(curso12);
	cursosCreados.add(curso13);
	cursosCreados.add(curso14);
	cursosCreados.add(curso15);
	cursosCreados.add(curso16);
	cursosCreados.add(curso17);
	llenarLista=false;
	return cursosCreados;
	}
	
	public Curso guardar(Curso curso) {
		
		cursosCreados.add(curso);
		return curso;
	}

	
	public void actualizar(Curso curso, String sigla) {
		for (int contadorDeLugares = 0; contadorDeLugares < cursosCreados.size(); contadorDeLugares++) {
			if (cursosCreados.get(contadorDeLugares).getSiglas().equalsIgnoreCase(sigla)) {
				cursosCreados.set(contadorDeLugares, curso);
			}
		}
		
	}


	public void eliminar(Curso curso, String sigla) {
		for (int contadorDeLugares = 0; contadorDeLugares < cursosCreados.size(); contadorDeLugares++) {
			if (cursosCreados.get(contadorDeLugares).getSiglas().equalsIgnoreCase(sigla)) {
				cursosCreados.remove(contadorDeLugares);
			}
		}
		
	}

}
