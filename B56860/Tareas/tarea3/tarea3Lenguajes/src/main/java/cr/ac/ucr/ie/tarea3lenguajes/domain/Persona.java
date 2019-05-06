package cr.ac.ucr.ie.tarea3lenguajes.domain;

/**
 *
 * @author Samuel
 */
class Persona {
    private int id;
    private char genero;

    public Persona(int id, char genero) throws Exception {
        setId(id);
        setGenero(genero);
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) throws IdErroneo {
        if(id > 0)
            this.id = id;
        else                                                            
            throw new IdErroneo("El id no puede ser 0 o negativo");
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) throws IdErroneo {
        if(genero != ' ')
            this.genero = genero;
        else
           throw new IdErroneo("El genero no puede estar vacío"); 
         
    }

    
    
}
