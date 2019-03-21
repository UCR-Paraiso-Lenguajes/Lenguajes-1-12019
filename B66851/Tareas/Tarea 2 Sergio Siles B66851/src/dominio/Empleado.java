/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author fabian
 */
//tip: las clases deben nombrarse con un sustantivo, no se utilizan verbos.
public class Empleado {

    //tip: los nombres deben tener sentido y significado.
    private String identificacion;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    //tip: Evite usar nombres con variaciones, ejemplo apellido1 y apellido2.

    //tip: Evite usar prefijos que se añaden a las variables y que indican su tipo, ejemplo nombreStr.
    public Empleado(String identificaion, String nombre, String primerApellido, String segundoApellido) {
        this.identificacion = identificaion;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
}
