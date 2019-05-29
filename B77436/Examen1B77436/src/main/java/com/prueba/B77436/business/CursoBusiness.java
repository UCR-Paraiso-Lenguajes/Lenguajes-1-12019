package com.prueba.B77436.business;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.prueba.B77436.domain.Carrera;
import com.prueba.B77436.domain.Ciclo;
import com.prueba.B77436.domain.Curso;
import com.prueba.B77436.domain.PlandeEstudios;

@Service
public class CursoBusiness {
	
	public void updateCurso() {
		
	}
	
	
	public int cantidadCreditos(ArrayList<Curso> cursos) {
		int creditos=0;
		for(int i=0;i<cursos.size();i++)
			creditos+=cursos.get(i).getCreditos();
		return creditos;
		
	}
	
	public int cantidadCursos(ArrayList<Curso> cursos) {
		
		return cursos.size();
		
	}
	
	public Iterator<Curso> calculaRequesitosCurso(Curso curso, PlandeEstudios plan){
		ArrayList<Integer> requesitos = curso.getRequisitos();
		ArrayList<Curso> cursosRequisito = new ArrayList<Curso>();
		for(int i=0;i<requesitos.size();i++) {
			for(int c=0;c<plan.getCursos().size();c++) {
				if(requesitos.get(i)==plan.getCursos().get(c).getIdCurso())
					cursosRequisito.add(plan.getCursos().get(c));
			}
		}
		
		return cursosRequisito.iterator();
	}
	
	
	public void cargarPlandeEstudio() {
		//ciclo V cursos
		Curso curso1 = new Curso(1,"Teoria Organizacional", "TO", 3);
		Curso curso2 = new Curso(2,"Metodos de investigacion cualitativa", "MI", 4);
		Curso curso3 = new Curso(3,"Metodos de investigacion cualitativa", "MI", 3);
		Curso curso4 = new Curso(4,"Economia aplicada a la Gestion", "ECG", 4);
		Curso curso5 = new Curso(5,"Taller de habilidades gerenciales", "THG", 2);
		
		ArrayList<Curso> cicloV = new ArrayList<Curso>();
		cicloV.add(curso1);
		cicloV.add(curso2);
		cicloV.add(curso3);
		cicloV.add(curso4);
		cicloV.add(curso5);
		////////////////--------------
		//ciclo VI
		Curso curso6 = new Curso(6,"Bases legales para la gestion", "BLG", 5);
		Curso curso7 = new Curso(7,"Economia aplicada a la Gestion B", "ECGII", 4);
		Curso curso8 = new Curso(8,"Taller de habilidades gerenciales II", "THG II", 2);
		ArrayList<Curso> cicloVI = new ArrayList<Curso>();
		cicloVI.add(curso6);
		cicloVI.add(curso7);
		cicloVI.add(curso8);
		////////////////77
		//ciclo VII
		Curso curso9 = new Curso(9,"Gestion Pública", "GP", 3);
		Curso curso10 = new Curso(10,"Gestion Social", "GS", 3);
		Curso curso11 = new Curso(11,"Gestion de proyectos", "GP", 4);
		ArrayList<Curso> cicloVII = new ArrayList<Curso>();
		cicloVII.add(curso9);
		cicloVII.add(curso10);
		cicloVII.add(curso11);
		///////////////////7
		//ciclo VIII
		Curso curso12 = new Curso(12,"Gestion Estrategica", "GE", 4);
		Curso curso13 = new Curso(13,"Taller de habilidades gerenciales III", "THG III", 2);
		ArrayList<Curso> cicloVIII = new ArrayList<Curso>();
		cicloVIII.add(curso12);
		cicloVIII.add(curso13);
		////////
		//ciclo IX
		Curso curso14 = new Curso(14,"Plan de negocios", "PN", 4);
		Curso curso15 = new Curso(15,"Seminario de Investigación", "Semi", 3);
		Curso curso16 = new Curso(16,"Etica para la gestion", "Et", 2);
		ArrayList<Curso> cicloIX = new ArrayList<Curso>();
		cicloIX.add(curso14);
		cicloIX.add(curso15);
		cicloIX.add(curso16);
		//ciclo  X
		Curso curso17 = new Curso(17,"Seminario de Investigación II", "Semi II", 4);
		Curso curso18 = new Curso(18,"Desarrollo y responsabilidad social", "DRS", 3);
		ArrayList<Curso> cicloX = new ArrayList<Curso>();
		cicloX.add(curso17);
		cicloX.add(curso18);
		
		ArrayList<Curso> cursosPlan= new ArrayList<Curso>();
		cursosPlan.add(curso1);
		cursosPlan.add(curso2);
		cursosPlan.add(curso3);
		cursosPlan.add(curso4);
		cursosPlan.add(curso5);
		cursosPlan.add(curso6);
		cursosPlan.add(curso7);
		cursosPlan.add(curso8);
		cursosPlan.add(curso9);
		cursosPlan.add(curso10);
		cursosPlan.add(curso11);
		cursosPlan.add(curso12);
		cursosPlan.add(curso13);
		cursosPlan.add(curso14);
		cursosPlan.add(curso15);
		cursosPlan.add(curso16);
		cursosPlan.add(curso17);
		cursosPlan.add(curso18);
		
		Ciclo ciclo1 = new Ciclo("Ciclo V", cicloV, "Innovación");
		Ciclo ciclo2 = new Ciclo("Ciclo VI", cicloVI, "Innovación");
		Ciclo ciclo3 = new Ciclo("Ciclo VII", cicloVII, "Innovación");
		Ciclo ciclo4 = new Ciclo("Ciclo VIII", cicloVIII, "Innovación");
		Ciclo ciclo5 = new Ciclo("Ciclo IX", cicloIX, "Innovación");
		Ciclo ciclo6 = new Ciclo("Ciclo X", cicloX, "Innovación");
		PlandeEstudios plan = new PlandeEstudios("Innovacion", cursosPlan);
		Carrera carrera = new Carrera(1, "Innovación", plan);
	}

}
