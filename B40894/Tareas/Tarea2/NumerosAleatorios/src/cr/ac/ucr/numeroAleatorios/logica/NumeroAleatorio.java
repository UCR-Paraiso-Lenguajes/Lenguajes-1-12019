
package cr.ac.ucr.numeroAleatorios.logica;

import java.util.ArrayList;
import java.util.List;
/*Tip 4 Capitulo 2: Class Names el nombre de una clase no debe ser un verbo si no 
un sustantivo pagina 25 capitulo 2
*/
/*Tip 5 Capitulo 3: Reading Code from Top to Bottom: The Stepdown Rule esto hace referencia
a que el codigo debe ser un estilo parrafo en lo cual utilizamos un metodo donde al inicio
tenemos todo lo que necesitamos configurado como una introduccion luego nuestros metodos
y funciones todo en una clase cascada desde arriba hasta abajo pagina 37 capitulo 3*/
public class NumeroAleatorio {
   /*Tip 1 Capitulo 2: Use Intention-Revealing Names, utilizar nombres con intencion reveladora para mejor comprension segun 
    pagina 18 del capitulo 2*/
    /*Tip 2 Capitulo 2: Use Pronounceable Names, Utilizar nombres pronunciables los cuales se pueda
    entender a la hora de ser utilizados paginas 21-22 del capitulo 2*/
    private int numeroAleatorio;
    private String listaGenerada;
    /*Tip 3 Capitulo 2 Use Searchable Names: utilizar nombres que al ser utilizados en varias secciones del codigo
    sean faciles de buscar paginas 22-23 del capitulo 2*/
    private List<Integer> listaNumerosAleatorios = new ArrayList<>();
   

    /*Tip 5 capitulo 2: Method Names los nombres de los metodos deben tener un verbo
    pagina 25 del capitulo 2*/
    public int GenerarNumeroAleatorio(){
        /*Tip 1 Capitulo 3: Small! como regla las funciones deben ser cortas o pequeñas 
        y como segunda regla deben ser lo mas pequeñas posibles por ende si esta puede ser pequeña
        hazla pero sin perder el entendimiento sobre esta pagina 34 Capitlo 3*/
        return numeroAleatorio=(int)(Math.random() * 50);
    }
    
    /*Tip 4 Capitulo 3: Use Descriptive Names utilizar nombres descriptivos pueden ayudar al
    mejor entendimiento de lo que se esta realizando en cierto lugar del codigo como funciones
    esto ayuda a clarificar el diseño del modelo y a nosotros como programadores para ver lo 
    que estamos haciendo paginas 39-40 Capitlo 3*/
       
    public void GenerarListaNumeros(){
       /*Tip 1 Capitulo 3: Small! como regla las funciones deben ser cortas o pequeñas 
        y como segunda regla deben ser lo mas pequeñas posibles por ende si esta puede ser pequeña
        hazla pero sin perder el entendimiento sobre esta pagina 34 Capitlo 3*/
        for(int contador=0; contador<= 10; contador++){
        numeroAleatorio=(int)(Math.random() * 50);
        /*Tip 2 Capitulo 3: Blocks and Indenting el utilizar la identancion sobre bloques como if
        while le da una mejor comprencion lectora para todo aquel que quiera enteneder el codigo
        pagina 35 Capitlo 3*/
        if(numeroAleatorio>5){
        /*Tip 3 Capitulo 3: One Level of Abstraction per Function se debe tener cuidado con 
        los niveles de abstraccion que se llegen a utilizar y evitar a su maximo el combinar 
        niveles puesto que podria complicar el entendimiento de este ejemplo vemos el .add()
        el cual segun la lectura podria recaer en un nivel bajo o intermedio de abstraccion
        paginas 36-37 Capitlo 3*/
            listaNumerosAleatorios.add(numeroAleatorio);
        }else{
            numeroAleatorio=numeroAleatorio+1;
            listaNumerosAleatorios.add(numeroAleatorio);
        }
        
        }
    }
    
    public String imprimirListaNumeros(){
    GenerarListaNumeros();
    listaGenerada=" ";
    for(int contador=0; contador<= 10; contador++){
       listaGenerada=listaGenerada+" "+listaNumerosAleatorios.get(contador);
    }
    listaNumerosAleatorios.clear();
    return listaGenerada;
    }
    
}
