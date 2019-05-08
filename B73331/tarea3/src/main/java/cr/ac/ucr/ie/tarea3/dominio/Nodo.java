package cr.ac.ucr.ie.tarea3.dominio;

public class Nodo {
	/*##### En esta clase se ejemplifica el tip #3 del Capitulo 6 "Ley de Demeter" en donde defino las variables del 
	 * nodo publicas ya que necesito el acceso directo desde la clase ListaEnlazada #######*/ 
	/*##### En esta clase se ejemplifica el tip #4 del Capitulo 6 "Objetos de tranferencia de datos" #######*/ 
    public Object elemento; 
    public Nodo sgte; 
    public Nodo ant;
    
    public Nodo(Object elemento){
        this.elemento = elemento;
        this.sgte =this.ant=null; 
    }

    public Nodo() {
        this.elemento = elemento;
        this.sgte =this.ant=null; 
    }

    
    @Override
    public String toString() {
        return "Nodo{" + "elemento=" + elemento + '}';
    }
    
}
