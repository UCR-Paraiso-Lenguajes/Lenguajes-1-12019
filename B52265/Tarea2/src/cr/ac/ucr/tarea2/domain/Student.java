package cr.ac.ucr.tarea2.domain;

import java.util.ArrayList;

public class Student {

    /*Use Intention-Revealing Names
    Las variables son representativas, cualquier otro porgramador o incluso persona
    sabra facilmente las intenciones y que dato se guardara en estas variables.
     */
    private int id;
    private String name;
    private String apellido;
    private ArrayList<Curso> cursos = new ArrayList<>();

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

}
