package cr.ac.ucr.tarea2.domain;

/*cumpliendo el tip clases name, no es un verbo es un sustantivo*/
public class Curso {

    private int id;
    private String nombreCurso;/*usando el tip member prefixs damos el nombre completo de la variable
    sin abreviaciones el ide lo permite y es mas facil de entender*/
    private int numeroAula;

    public Curso(int id, String nombreCurso, int numeroAula) {
        this.id = id;
        this.nombreCurso = nombreCurso;
        this.numeroAula = numeroAula;
    }

    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }


}
