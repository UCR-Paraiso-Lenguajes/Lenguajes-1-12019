package cr.ac.ucr.Examen1B52265.Domain;

import java.util.ArrayList;

public class Plan {
    private int id;
    private String nombre;


    public Plan(int id,String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
