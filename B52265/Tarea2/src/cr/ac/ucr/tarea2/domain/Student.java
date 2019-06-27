package cr.ac.ucr.tarea2.domain;

import java.util.ArrayList;

public class Student {

    /*Use Intention-Revealing Names
    Las variables son representativas, cualquier otro porgramador o incluso persona
    sabra facilmente las intenciones y que dato se guardara en estas variables.
     */
    private int id;
    private String name;
    /*Tambien usando el tip Use pronunceable Names, las variables,
    son palabras conocidas y faciles de pronunciar*/
    private String apellido;
    /*Aca evitamos la desinformacion, ya que efectivamente listaCursos es una lista, y tambien se coloco
    listas para que como dije se sepan que es una lista no solo un grupo de cursos*/
    private ArrayList<Curso> listaCursos = new ArrayList<>();

    public Student() {
    }

    public Student(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.apellido = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return apellido;
    }

    public void setLastName(String lastName) {
        this.apellido = lastName;
    }

    /*Aca hacemos una distincion en los metodos de matricula con sentido donde sabemos perfectamente
    cual metodo debemos invocar para cual situacion sin causar confuciones*/
    public void matriculaOrdinaria(Curso curso) throws Exception {
        /*tip small es un metodo sencillo y rapido sin mucha cosa, evitando muchos niveles de validaciones
         */

        /*siguiento el tip block and identing la validacion if
            contiene un metodo en su validacion se sabe que hace el metodo por el nombre y que se esta
            evaluando ademas de su correcta identacion*/
        if (this.listaCursos.contains(curso)) {
            throw new Exception("El curso ya existe");
        } else {
            this.listaCursos.add(curso);
        }
        /*manteniendo el tip do one thing, el metodo solo hace una cosa que es matricular, no realiza
        mas acciones o validaciones*/
        /*Tambien mantenemos un solo nivel de abstracion por funcion*/
    }

    /*Este asi como el metodo anterior se manejan nombres descriptivos sabemos exactamente que hace*/
    public void matriculaInclusion() {
    }
}
