package com.ucr.ac.cr.data;

import java.util.ArrayList;

import com.ucr.ac.cr.domain.Curso;
import com.ucr.ac.cr.domain.PlanDeEstudios;

public class DatosEnMemoria {
	
	public ArrayList<Curso> cursos = new ArrayList<Curso>() ;
	public PlanDeEstudios plan;
	
	public void datos() {
		
		//Ciclo V 

		Curso teoriaOrganizacional = new Curso(1,"Teoria Organizacional", "TEO-1", 3, 1);
		Curso investigacionCualitativa = new Curso(2,"Metodos de Investigacion Cualitativa", "MelCu-1", 4, 1);
		Curso investigacionCuantitativa = new Curso(2,"Metodos de Investigacion Cuantitativa", "MelCu-2", 3, 1);
		Curso economiaAplicada = new Curso(2,"Economia Aplicada a la Gestion", "EAG-1A", 4, 1);
		Curso tallerGerencial = new Curso(3,"Taller de Habilidades Gerenciales","TaHaGe-1", 2, 1);

		cursos.add(teoriaOrganizacional);
		cursos.add(investigacionCualitativa);
		cursos.add(investigacionCuantitativa);
		cursos.add(economiaAplicada);
		cursos.add(tallerGerencial);

		//Ciclo VI
		
		 ArrayList<String> requisitosbases = new ArrayList<String>() ;
		 requisitosbases.add("MelCu-1");
		 requisitosbases.add( "MelCu-2");
		 requisitosbases.add("EAG-1A");
		 ArrayList<String> requisitostaller = new ArrayList<String>() ;
		 requisitostaller.add("TaHaGe-1");
		
		Curso basesLegales = new Curso(2,"Bases Legales para la Gestion",  "BaLe-2", 5,requisitosbases, 2);
		Curso economiaAplicadaDos = new Curso(2,"Economia Aplicada a la Gestion II","EcAPpli-2", 4,requisitosbases,2);
		Curso tallerGerencialDos = new Curso(3,"Taller de Habilidades Gerenciales","TaHaGe-2", 2,requisitostaller, 2);
		
		cursos.add(basesLegales);
		cursos.add(economiaAplicadaDos);
		cursos.add(tallerGerencialDos);

		//Ciclo VII
		
		ArrayList<String> requisitosGestion = new ArrayList<String>() ;
		requisitosGestion.add("TEO-1");
		
		Curso gestionPublica = new Curso(1,"Gestion Publica", "GesPu-3", 3,requisitosGestion, 3);
		Curso gestionSocial = new Curso(1,"Gestion Social", "GesSo-3", 3, requisitosGestion,3);
		Curso gestionProyecto = new Curso(1,"Gestion de Proyectos", "GesPr-3", 4, requisitosGestion,3);

		cursos.add(gestionPublica);
		cursos.add(gestionSocial);
		cursos.add(gestionProyecto);

		//Ciclo VIII 
		
		ArrayList<String> requisitosGestionEstra = new ArrayList<String>() ;
		requisitosGestionEstra.add("GesPu-3");
		requisitosGestionEstra.add("GesSo-3");
		requisitosGestionEstra.add("GesPr-3");
		requisitosGestionEstra.add("TEO-1");
		
		ArrayList<String> requisitosTallerHab = new ArrayList<String>() ;
		requisitosTallerHab.add("TaHaGe-1");
		requisitosTallerHab.add("TaHaGe-2");

		Curso gestionEstrategica = new Curso(1,"Gestion Estrategica", "GesE-4", 4,requisitosGestionEstra, 4);
		Curso tallerGerencialTres = new Curso(3,"Taller de Habilidades Gerenciales", "TaHaGe-4", 2,requisitosTallerHab, 4);
		cursos.add(tallerGerencialTres);
		cursos.add(gestionEstrategica);

		//Ciclo IX
		
		ArrayList<String> requisitosPlanNego = new ArrayList<String>() ;
		requisitosPlanNego.add("GesPu-3");
		requisitosPlanNego.add("GesSo-3");
		requisitosPlanNego.add("GesPr-3");
		requisitosPlanNego.add("TEO-1");
		requisitosPlanNego.add("GesE-4");
		
		ArrayList<String> requisitosSeminario = new ArrayList<String>() ;
		requisitosSeminario.add("MelCu-1");
		requisitosSeminario.add("MelCu-2");
		requisitosSeminario.add("EAG-1A");
		requisitosSeminario.add("BaLe-2");
		requisitosSeminario.add("EcAPpli-2");
		
		

		Curso planNegocio = new Curso(1,"Plan de Negocios","PlanNe-5", 4,requisitosPlanNego, 5);
		Curso seminario = new Curso(2,"Seminario de Investigacion", "SeInv-5", 3,requisitosSeminario, 5);
		Curso eticaGestion = new Curso(4,"Etica para la Gestion", "EtiGes-5", 2, 5);

		cursos.add(planNegocio);
		cursos.add(seminario);
		cursos.add(eticaGestion);
		

		//Ciclo X
		
		ArrayList<String> requisitosSeminarioII = new ArrayList<String>() ;
		requisitosSeminarioII.add("MelCu-1");
		requisitosSeminarioII.add("MelCu-2");
		requisitosSeminarioII.add("EAG-1A");
		requisitosSeminarioII.add("BaLe-2");
		requisitosSeminarioII.add("EcAPpli-2");
		requisitosSeminarioII.add("SeInv-5");
		
		ArrayList<String> requisitosDesarroloResp = new ArrayList<String>() ;
		requisitosDesarroloResp.add("EtiGes-5");
		

		Curso seminarioInvestDos = new Curso(2,"Seminario de Investigacion II", "SeInDos-6", 4,requisitosSeminarioII, 6);
		Curso desarrolloResp = new Curso(4,"Desarrollo Social y Responsabilidad Social","DeReSo-6", 3,requisitosDesarroloResp, 6);

		cursos.add(seminarioInvestDos);
		cursos.add(desarrolloResp);	
		
		 plan = new PlanDeEstudios("Informatica", cursos);
		
		
	}

}
