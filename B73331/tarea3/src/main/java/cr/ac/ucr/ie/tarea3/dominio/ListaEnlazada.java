package cr.ac.ucr.ie.tarea3.dominio;

import cr.ac.ucr.ie.tarea3.interfaces.Lista;
import cr.ac.ucr.ie.tarea3.dominio.ListaExcepcion;

public class ListaEnlazada implements Lista {
	/*##### En esta clase se ejemplifica el tip #2 del Capitulo 6 "Antisimetria de datos y objetos" #######*/ 
    private Nodo inicio; //apunta al inicio de la lista
    
    public ListaEnlazada(){
        this.inicio = null;
    }

   
    public int obtenerTamano() throws ListaExcepcion {
    	/*##### En esta clase se ejemplifica el tip #1 del Capitulo 7 "Usar excepciones en vez de devolver codigo con return" #######*/ 
    	/*##### En esta clase se ejemplifica el tip #4 del Capitulo 7 "Proveer contexto con las excepciones" #######*/ 
    	/*##### En esta clase se ejemplifica el tip #6 del Capitulo 7 "Definir el flujo normal" Separo el 
    	 * tipo de almacenamiento y lo empresarial con los datos (Interface Lista y Clase ListaException, en 
    	 * donde  la clase nodo contiene del dato) #######*/
    	if(estaVacia()){
    		/*##### En esta clase se ejemplifica el tip #8 del Capitulo 7 "No recibir nulos"(isEmpty() revisa 
    		 * el nodo de la lista es nulo o no) #######*/ 
            throw new ListaExcepcion("La lista esta vacia");
        }
        Nodo aux = inicio;
        int contador=0;
        while(aux!=null){
            contador++;
            aux = aux.sgte; //lo movemos al sgte nodo
        }
        return contador;
    }

    public Object obtenerUltimo() throws ListaExcepcion {
        if(estaVacia()){
            throw new ListaExcepcion("La lista esta vacia");
        }
        Nodo aux = inicio;
        while(aux.sgte!=null){
            aux = aux.sgte; //lo movemos al sgte nodo
        }
        /*##### En esta clase se ejemplifica el tip #7 del Capitulo 7 "No retornar nulos" #######*/ 
        if(aux.elemento==null) {
        	return "El elemento esta anulado";
        }else {
            return aux.elemento;
        }
        //es el ultimo en la lista
    }
	public boolean estaVacia() {
		return inicio==null;
	}

    


    
    
    
}
