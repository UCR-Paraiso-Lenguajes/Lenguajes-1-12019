package ac.cr.ucr.domain;


//Tip Cap3 Usar nombres descriptivos
//Tip Cap3 Como crear este tipo de funciones:Retoco el còdigo, cambio los nombres  y elimino duplicados(En general)



public class Matricula {
	
//Tip Cap3 Argumentos de funciones	
	public void matricularAsignatura(Estudiante estudiante, Asignatura asignatura) {
		
		   
		if(!estudiante.getListaAsignaturas().contains(asignatura) ){
		            estudiante.getListaAsignaturas().add(asignatura);
		 }else{
			 throw new RuntimeException("La asignatura ya està matriculada");
		 }
		  
		    }
	
		
	}


