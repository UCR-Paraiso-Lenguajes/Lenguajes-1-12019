package cr.ac.ucr;

public class Curso {
	
	private  Estudiante[] estudiantesMatriculados;
	private int numeroEstudiantes; 
	
	public Curso() {
		super();
		estudiantesMatriculados=new Estudiante[30];
	}
	public void Matricular(Estudiante estudiante) {
		/* Cap 3:Small!
		 * Cap 3:Do One Thing
		 * Cap 3:One Level of Abstraction per Function
		 * Cap 3:Use Descriptive Names
		**/
		if(estudiante!=null) {
			if (numeroEstudiantes<=30) {
				/* caso cuando tenga 31
				**/
				numeroEstudiantes=numeroEstudiantes+1;
				estudiantesMatriculados[numeroEstudiantes]=estudiante;
			}else {
				throw new RuntimeException("El maximo de estudiantes es 30");
			}
			
		}
	}
	public  Estudiante[] getEstudiantesMatriculados() {
		return estudiantesMatriculados;
	}

	public void setEstudiantesMatriculados(Estudiante[] estudiantesMatriculados) {
		estudiantesMatriculados = estudiantesMatriculados;
	}
	@Override
	public String toString() {
		String informacionCurso="";
		for (int estudiantesCurso = 0; estudiantesCurso < estudiantesMatriculados.length; estudiantesCurso++) {
			/* Cap 2 : Avoid Mental Mapping
			 
			**/
			informacionCurso+=estudiantesMatriculados[estudiantesCurso].toString()+"\n";
		}
		/*
		 * Cap 3: Output Arguments 
		 *
		**/
		return informacionCurso;
	}
   
}
