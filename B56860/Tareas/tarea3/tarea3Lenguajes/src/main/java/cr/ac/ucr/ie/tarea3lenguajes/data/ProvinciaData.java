package cr.ac.ucr.ie.tarea3lenguajes.data;

import cr.ac.ucr.ie.tarea3lenguajes.domain.Provincia;

/**
 *
 * @author Samuel
 */
public class ProvinciaData {
    Provincia provincia = new Provincia();
    
    public void agregarCiudadanos(int id, char genero) throws Exception{
        if(existInDatabase(id)) throw new Exception("Ya existe el id en la base de datos");     //Cap 7 no pasar nulos por parametro
        provincia.agregarCiudadanos(id, genero);                                      //<----ej.  Asegurar que siempre se pase toda la informacion requerida
    }                                                                                           //es mejor sobrecargar un método con distintos parámetros   
                                                                                                //que pasar un nulo por algún campo
    private boolean existInDatabase(int id) {
        //Conexión a la base de datos y consulta por el id
        return false;
    }
}
