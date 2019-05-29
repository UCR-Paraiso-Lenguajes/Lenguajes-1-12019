package cr.ac.ucr.Examen1B52265.Domain;

public class Curso {
    private int id;
    private String nombre;
    private String siglas;
    private int creditos;
    private String requisitoSigla;
    private boolean isCursoInicial;
    private boolean isCursoFinal;

    public Curso(String nombre, String siglas, int creditos, String requisitoSigla, boolean isCursoInicial, boolean isCursoFinal) {
        if(isSiglasIguales(siglas,requisitoSigla)) new RuntimeException("Un curso no puede ser requisito de si mismo");
        if(isCursoInicial) new RuntimeException("Un curso inicial no puede tener requisitos");
        if(nombre.trim().equals("")) new RuntimeException("El nombre no puede venir vacio");
        if(siglas.trim().equals("")) new RuntimeException("Las siglas no pueden venir vacio");
        if(creditos<0) new RuntimeException("la cantidad de creditos no puede ser menor a 0");
        this.nombre = nombre;
        this.siglas = siglas;
        this.creditos = creditos;
        this.requisitoSigla = requisitoSigla;
        this.isCursoInicial = isCursoInicial;
        this.isCursoFinal = isCursoFinal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getRequisitoSigla() {
        return requisitoSigla;
    }

    public void setRequisitoSigla(String requisitoSigla) {
        this.requisitoSigla = requisitoSigla;
    }

    public boolean isCursoInicial() {
        return isCursoInicial;
    }

    public void setCursoInicial(boolean cursoInicial) {
        isCursoInicial = cursoInicial;
    }

    public boolean isCursoFinal() {
        return isCursoFinal;
    }

    public void setCursoFinal(boolean cursoFinal) {
        isCursoFinal = cursoFinal;
    }

    public boolean isSiglasIguales(String siglas, String requisitoSigla){
        if(siglas.equals(requisitoSigla)){
            return true;
        }else {
            return false;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
