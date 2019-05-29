package cr.ac.ucr.Examen1B52265.Domain;

import java.util.ArrayList;

public class Plan {
    private int id;
    private String nombre;
    private CursosPlan cursosPlan;


    public Plan(String nombre, CursosPlan cursosPlan) {
        this.nombre = nombre;
        this.cursosPlan = cursosPlan;
    }

    public int cantidadCreditos(ArrayList<Curso> cursos){
        int resultado = -1;
        for(Curso curso: cursos){
            resultado += curso.getCreditos();
        }
        return resultado;
    }
    public int cantidadCursos(ArrayList<Curso> cursos){
        return cursos.size();
    }
    public boolean buscarRequisitos(){
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CursosPlan getCursosPlan() {
        return cursosPlan;
    }

    public void setCursosPlan(CursosPlan cursosPlan) {
        this.cursosPlan = cursosPlan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
