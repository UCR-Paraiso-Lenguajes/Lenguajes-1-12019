
package domain;

/**
 *
 * @author Nicole Fonseca
 */

/*Class Names
En los nombres de clases no se usan verbos.
*/
public class Estudiante {
    
    /*Use Intention-Revealing Names
    Usar nombres que revelen para que se van a utilizar, en este
    caso los datos del estudiante que tiene cada variable.
    */
    private String id;
    private String nombre;
    private String apellidos;
    private String carrera;

    public Estudiante() {
    }

    public Estudiante(String id, String nombre, String apellidos, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.carrera = carrera;
    }

    /*Method Names
    Los nombres de métodos deben ser verbos. 
    Los métodos de acceso y modificación deben ponerse con 
    prefijos como get, set, is.
    */
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
