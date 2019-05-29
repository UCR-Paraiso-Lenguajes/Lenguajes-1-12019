package cr.ac.ucr.Examen1B52265.Domain;

import java.util.ArrayList;

public class CursosPlan {

    private ArrayList<Curso> cursosDelPlan;
    private String nombrePlan;

    public CursosPlan(ArrayList<Curso> cursosDelPlan, Curso cursoNuevo) {
        this.cursosDelPlan = cursoRequisito(cursosDelPlan,cursoNuevo);
    }

    public ArrayList<Curso> cursoRequisito(ArrayList<Curso> cursos, Curso cursoNuevo){
        for(Curso curso: cursos){
            if(curso.getSiglas().equals(curso.getSiglas())){
                new RuntimeException("Curso ya existe");
            }else if(cursoNuevo.getRequisitoSigla().equals(curso.getSiglas())){
                if(curso.isCursoFinal()) new RuntimeException("Un curso final no puede ser requisito de otro");
                cursos.add(cursoNuevo);
            } else{
                cursos.add(cursoNuevo);
            }
        }
        return cursos;
    }
    public ArrayList<Curso> getCursosDelPlan() {
        return cursosDelPlan;
    }

    public void setCursosDelPlan(ArrayList<Curso> cursosDelPlan) {
        this.cursosDelPlan = cursosDelPlan;
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }
}
