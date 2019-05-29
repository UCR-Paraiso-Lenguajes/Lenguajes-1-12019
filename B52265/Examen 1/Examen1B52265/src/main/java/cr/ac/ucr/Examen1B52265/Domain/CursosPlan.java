package cr.ac.ucr.Examen1B52265.Domain;

import java.util.ArrayList;

public class CursosPlan {

    private ArrayList<Curso> cursosDelPlan;
    private Plan plan;

    public CursosPlan(Plan plan, ArrayList<Curso> cursos) {
            this.cursosDelPlan = cursos;
            this.plan = plan;
    }

    public void validaRequisitos(Plan plan,ArrayList<Curso> cursoNuevo){
        if(this.cursosDelPlan.isEmpty()){
            this.cursosDelPlan = cursoNuevo;
            this.plan = plan;
        }else {
            for (Curso curso : cursoNuevo) {
                for(Curso cursoAux: this.cursosDelPlan){
                    if(curso.getRequisitoSigla().equals(cursoAux.getSiglas())){
                        if (curso.isCursoFinal()){
                            new RuntimeException("un curso final no puede ser requisito de otro");
                        }else{
                            this.cursosDelPlan = cursoNuevo;
                            this.plan = plan;
                        }
                    }else{
                        this.cursosDelPlan = cursoNuevo;
                        this.plan = plan;
                    }
                }
            }
        }
    }
    public ArrayList<Curso> getCursosDelPlan() {
        return cursosDelPlan;
    }

    public void setCursosDelPlan(ArrayList<Curso> cursosDelPlan) {
        this.cursosDelPlan = cursosDelPlan;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
