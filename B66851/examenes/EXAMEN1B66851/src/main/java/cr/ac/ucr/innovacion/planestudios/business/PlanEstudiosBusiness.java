package cr.ac.ucr.innovacion.planestudios.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cr.ac.ucr.innovacion.planestudios.domain.Curso;

@Service
public class PlanEstudiosBusiness {

	
	List<Curso> cursosDelPlan;

	
	
	public PlanEstudiosBusiness() {
		llenarLista();
	}



	public void llenarLista() {
		
		cursosDelPlan = new ArrayList<>();
		
		
		Curso curso1 = new Curso("Teoria Organizacional","EI01",3,"V",null);
		Curso curso2 = new Curso("Metodos de la investigacion cualitativa","AI01",4,"V",null);
		Curso curso3 = new Curso("Metodos de la investigacion cualitativa","AI02",3,"V",null);
		Curso curso4 = new Curso("Economia aplicada a la gestion","AI03",4,"V",null);
		Curso curso5 = new Curso("Taller de habilidades generales","HG01",2,"V",null);
		Curso curso6 = new Curso("Bases legales para la gestion","AI04",5,"VI",null);
		Curso curso7 = new Curso("Economia aplicada a la gestion 2","AI05",4,"VI",null);
		Curso curso8 = new Curso("Taller de habilidades gerenciales 2","HG02",2,"VI",null);
		Curso curso9 = new Curso("Gestion publica","EI02",3,"VII",null);
		Curso curso10 = new Curso("Gestion social","EI03",3,"VII",null);
		Curso curso11 = new Curso("Gestion de proyectos","EI04",4,"VII",null);
		Curso curso12 = new Curso("Gestion estrategica","EI05",4,"VIII",null);
		Curso curso13 = new Curso("Taller de habilidades gerenciales 3","HG03",2,"VIII",null);
		
		
		
		
		cursosDelPlan.add(curso1);
		cursosDelPlan.add(curso2);
		cursosDelPlan.add(curso3);
		cursosDelPlan.add(curso4);
		cursosDelPlan.add(curso5);
		cursosDelPlan.add(curso6);
		cursosDelPlan.add(curso7);
		cursosDelPlan.add(curso8);
		cursosDelPlan.add(curso9);
		cursosDelPlan.add(curso10);
		cursosDelPlan.add(curso11);
		cursosDelPlan.add(curso12);
		cursosDelPlan.add(curso13);
	}


	public List<Curso> obtenerCursos() {
		
		return cursosDelPlan;
	}
}
