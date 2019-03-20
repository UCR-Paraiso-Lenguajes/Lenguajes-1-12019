/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2lenguajes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP ELITEBOOK
 */
public class Pelicula {

    //Codigo, nombre, genero, autor, año, duracionEnMinutos,precio
    //Ejemplo 1 del capítulo 2
    //El atributo p no nos indica nada, si especificados el nombre como
    // nombreDePelicula ya nos ayuda a entender la funcion de la variable
    //Use Intention-Revealing Names pag:18
    //String p;
    String nombreDePelicula;

    String codigoDeLaPelicula;
    String generoDeLaPelicula;
    String NombreDelDirectorrDeLaPelicula;
    int añoDeLanzamientoDeLaPelicula;
    int precioEnColonesDeLaPelicula;
    int duracionEnMinutosDeLaPelicula;

    // Ejemplo 2: Use Searchable Names, pag 22
    // No es lo mismo crear una variable que me diga si una pelicula es
    // Alta Definicion nombrandola  hd que nombrandola highDefinition
    // boolean hd;
    boolean highDefinition;

    public Pelicula(String nombreDePelicula, String codigoDeLaPelicula, String generoDeLaPelicula, String NombreDelDirectorDeLaPelicula, int añoDeLanzamientoDeLaPelicula, int precioEnColonesDeLaPelicula, int duracionEnMinutosDeLaPelicula) {
        this.nombreDePelicula = nombreDePelicula;
        this.codigoDeLaPelicula = codigoDeLaPelicula;
        this.generoDeLaPelicula = generoDeLaPelicula;
        this.NombreDelDirectorrDeLaPelicula = NombreDelDirectorDeLaPelicula;
        this.añoDeLanzamientoDeLaPelicula = añoDeLanzamientoDeLaPelicula;
        this.precioEnColonesDeLaPelicula = precioEnColonesDeLaPelicula;
        this.duracionEnMinutosDeLaPelicula = duracionEnMinutosDeLaPelicula;
    }

    public String getNombreDePelicula() {
        return nombreDePelicula;
    }

    public void setNombreDePelicula(String nombreDePelicula) {
        this.nombreDePelicula = nombreDePelicula;
    }

    public String getCodigoDeLaPelicula() {
        return codigoDeLaPelicula;
    }

    public void setCodigoDeLaPelicula(String codigoDeLaPelicula) {
        this.codigoDeLaPelicula = codigoDeLaPelicula;
    }

    public String getGeneroDeLaPelicula() {
        return generoDeLaPelicula;
    }

    public void setGeneroDeLaPelicula(String generoDeLaPelicula) {
        this.generoDeLaPelicula = generoDeLaPelicula;
    }

    public String getNombreDelDirectorrDeLaPelicula() {
        return NombreDelDirectorrDeLaPelicula;
    }

    public void setNombreDelDirectorrDeLaPelicula(String NombreDelDirectorrDeLaPelicula) {
        this.NombreDelDirectorrDeLaPelicula = NombreDelDirectorrDeLaPelicula;
    }

    public int getAñoDeLanzamientoDeLaPelicula() {
        return añoDeLanzamientoDeLaPelicula;
    }

    public void setAñoDeLanzamientoDeLaPelicula(int añoDeLanzamientoDeLaPelicula) {
        this.añoDeLanzamientoDeLaPelicula = añoDeLanzamientoDeLaPelicula;
    }

    public int getPrecioEnColonesDeLaPelicula() {
        return precioEnColonesDeLaPelicula;
    }

    public void setPrecioEnColonesDeLaPelicula(int precioEnColonesDeLaPelicula) {
        this.precioEnColonesDeLaPelicula = precioEnColonesDeLaPelicula;
    }

    public int getDuracionEnMinutosDeLaPelicula() {
        return duracionEnMinutosDeLaPelicula;
    }

    public void setDuracionEnMinutosDeLaPelicula(int duracionEnMinutosDeLaPelicula) {
        this.duracionEnMinutosDeLaPelicula = duracionEnMinutosDeLaPelicula;
    }

    //Ejemplo 3 cap 2 Make Meaningful Distinctions pag 20
    // Suponiendo que las 2 peliculas tienen diferente duracion...
    //Este metodo no tiene sentido ya que p1 y p2 no nos indican nada.
//    public Pelicula PeliculaConMayorDuraciónEnMinutosEntreDosPeliculas(Pelicula p1, Pelicula p2){
//        
//      if(p1.getDuracionEnMinutosDeLaPelicula() >= p2.getDuracionEnMinutosDeLaPelicula()){
//          return p1;
//      }else{
//          return p2;
//      }  
//        
//    }
    //Es mejor colocar nombres dinstintivos para los argumentos, variables etc
    public Pelicula PeliculaConMayorDuraciónEnMinutosEntreDosPeliculas(Pelicula primerPelicula, Pelicula segundaPelicula) {

        if (primerPelicula.getDuracionEnMinutosDeLaPelicula() >= segundaPelicula.getDuracionEnMinutosDeLaPelicula()) {
            return primerPelicula;
        } else {
            return segundaPelicula;
        }

    }

    //Ejemplo 4 capitulo 2, Use Pronounceable Names pag 21
    // El nombre PeliGenTe no es una palabra normal y es extrano pronunciarla
    public List<Pelicula> PeliGenTe() {
        ArrayList<Pelicula> ListaDeTodasLasPeliculas = ListaDeTodasLasPeliculasRegistradas();
        ArrayList<Pelicula> ListaDeLasPeliculasDeTerror = new ArrayList<>();
        for (Pelicula pelicula : ListaDeTodasLasPeliculas) {
            if (pelicula.getGeneroDeLaPelicula().equalsIgnoreCase("TERROR")) {
                ListaDeLasPeliculasDeTerror.add(pelicula);
            }
        }
        return ListaDeLasPeliculasDeTerror;
    }

    //Mejor le cambiamos el nombre y le colocamos ListaDePeliculasDeGeneroDeTerror
    // Es un poco largo pero especifica bien de lo que trata el metodo.
    public List<Pelicula> ListaDePeliculasDeGeneroDeTerror() {
        ArrayList<Pelicula> ListaDeTodasLasPeliculas = ListaDeTodasLasPeliculasRegistradas();
        ArrayList<Pelicula> ListaDeLasPeliculasDeTerror = new ArrayList<>();
        for (Pelicula pelicula : ListaDeTodasLasPeliculas) {
            if (pelicula.getGeneroDeLaPelicula().equalsIgnoreCase("TERROR")) {
                ListaDeLasPeliculasDeTerror.add(pelicula);
            }
        }
        return ListaDeLasPeliculasDeTerror;
    }

    //Ejemplo 5: Don’t Be Cute, pag 26
    // No hay que colocar nombres para ser graciosos o llamar la atencion
    // Es mejor colocar nombres que nos ayuden a entender bien lo que hace el metodo.
    public int ObtenerLaDuracionMaximaDeLasPeliculas() {
        ArrayList<Pelicula> ListaDeTodasLasPeliculas = ListaDeTodasLasPeliculasRegistradas();
        int duracionMaximaTemporal = 0;
        for (Pelicula pelicula : ListaDeTodasLasPeliculas) {
            if (pelicula.getDuracionEnMinutosDeLaPelicula() > duracionMaximaTemporal) {
                duracionMaximaTemporal = pelicula.getDuracionEnMinutosDeLaPelicula();
            }
        }
        return duracionMaximaTemporal;
    }

    public Pelicula ObtenerLaPeliculaQueDuraUnLeñazo() {
        ArrayList<Pelicula> ListaDeTodasLasPeliculas = ListaDeTodasLasPeliculasRegistradas();
        Pelicula peliculaConDuracionMaxima = null;
        for (Pelicula pelicula : ListaDeTodasLasPeliculas) {
            if (pelicula.getDuracionEnMinutosDeLaPelicula() == ObtenerLaDuracionMaximaDeLasPeliculas()) {
                peliculaConDuracionMaxima = pelicula;
            }
        }
        return peliculaConDuracionMaxima;
    }

    // Mejor le cambiamos el nombre
    public Pelicula ObtenerLaPeliculaConMayorDuracion() {
        ArrayList<Pelicula> ListaDeTodasLasPeliculas = ListaDeTodasLasPeliculasRegistradas();
        Pelicula peliculaConDuracionMaxima = null;
        for (Pelicula pelicula : ListaDeTodasLasPeliculas) {
            if (pelicula.getDuracionEnMinutosDeLaPelicula() == ObtenerLaDuracionMaximaDeLasPeliculas()) {
                peliculaConDuracionMaxima = pelicula;
            }
        }
        return peliculaConDuracionMaxima;
    }

    //Ejemplos del capitulo 3
    //Aqui voy a hacer 2 ejemplos en uno
    //Serian los ejemplos 6 y 7
    // Small! capitulo 3 pag 34  y  Do One Thing capitulo 3 pag 35
    //La idea es hacer metodos pequenos, y que hagan solamente 1 tarea especifica
    // Primero hare un ejemplo mal hecho, y luego lo voy a separar en 2 funciones.
//      public ArrayList<Pelicula> ListaDePeliculasConDuracionMayorADosHoras(ArrayList<Pelicula> ListaDeTodasLasPeliculas){
//          ArrayList<Pelicula> ListaDePeliculasConDuracionMayorADosHoras = new ArrayList<>();
//          ArrayList<Pelicula> ListaDePeliculasDeMelGibson = new ArrayList<>();
//          
//          for (Pelicula pelicula:ListaDeTodasLasPeliculas){
//              if(pelicula.getDuracionEnMinutosDeLaPelicula() > 120){
//                  ListaDePeliculasConDuracionMayorADosHoras.add(pelicula);
//              }
//              if(pelicula.getNombreDelDirectorrDeLaPelicula().equalsIgnoreCase("MEL GIBSON")){
//              ListaDePeliculasDeMelGibson.add(pelicula);
//          }
//          }
//          return ListaDePeliculasConDuracionMayorADosHoras;
//      }
    //Como pueden ver, aparte de que el codigo es largo, esta haciendo 2 cosas a la vez
    // Hace una lista de peliculas que duran mas de 2 horas, y aparte una lista
    // de peliculas del director Mel Gibson, lo cual no tiene nada que ver con el nombre del metodo
    //Vamos a separarlo en 2 Metodos:
    public ArrayList<Pelicula> ListaDePeliculasConDuracionMayorADosHoras(ArrayList<Pelicula> ListaDeTodasLasPeliculas) {
        ArrayList<Pelicula> ListaDePeliculasConDuracionMayorADosHoras = new ArrayList<>();

        for (Pelicula pelicula : ListaDeTodasLasPeliculas) {
            if (pelicula.getDuracionEnMinutosDeLaPelicula() > 120) {
                ListaDePeliculasConDuracionMayorADosHoras.add(pelicula);
            }

        }
        return ListaDePeliculasConDuracionMayorADosHoras;
    }

    public ArrayList<Pelicula> ListaDePeliculasDelDirectorMelGibson(ArrayList<Pelicula> ListaDeTodasLasPeliculas) {

        ArrayList<Pelicula> ListaDePeliculasDeMelGibson = new ArrayList<>();
        for (Pelicula pelicula : ListaDeTodasLasPeliculas) {

            if (pelicula.getNombreDelDirectorrDeLaPelicula().equalsIgnoreCase("MEL GIBSON")) {
                ListaDePeliculasDeMelGibson.add(pelicula);
            }
        }
        return ListaDePeliculasDeMelGibson;
    }

    // Ahora si quedaron metodos mas pequenos y hacen solo 1 cosa.
    // Ejemplo 8, Use Descriptive Names, capitulo 3, pag 39
    //Hay que usar nombres que digan bien lo que esperamos que haga el metodo
    //El nombre del metodo Peliculas no nos dice nada y no sabremos que hace exactamente
    public ArrayList<Pelicula> Peliculas() {
        Pelicula peliculaDePruebaUno = new Pelicula("LA VIDA DE PI", "CF0", "CIENCIA FICCION", "ANG LEE", 2012, 500, 127);
        Pelicula peliculaDePruebaDos = new Pelicula("HASTA EL ULTIMO HOMBRE", "A0", "ACCION", "MEL GIBSON", 2016, 500, 139);
        Pelicula peliculaDePruebaTres = new Pelicula("IT PARTE 1", "T0", "TERROR", "ANDRES MUSCHIETTI", 2017, 500, 135);
        ArrayList<Pelicula> ListaDeTodasLasPeliculas = new ArrayList<>();
        ListaDeTodasLasPeliculas.add(peliculaDePruebaUno);
        ListaDeTodasLasPeliculas.add(peliculaDePruebaDos);
        ListaDeTodasLasPeliculas.add(peliculaDePruebaTres);

        return ListaDeTodasLasPeliculas;
    }

    // Si le colocamos el nombre ListaDeTodasLasPeliculasRegistradas ya sabemos
    // Que nos trae el nombre de todas las peliculas registradas
    // Lo mejor seria tener un archivo o una BD con las peliculas
    // Leerlo y agregar todo a la estructura de datos, pero como es un ejemplo lo deje asi.
    public ArrayList<Pelicula> ListaDeTodasLasPeliculasRegistradas() {
        Pelicula peliculaDePruebaUno = new Pelicula("LA VIDA DE PI", "CF0", "CIENCIA FICCION", "ANG LEE", 2012, 500, 127);
        Pelicula peliculaDePruebaDos = new Pelicula("HASTA EL ULTIMO HOMBRE", "A0", "ACCION", "MEL GIBSON", 2016, 500, 139);
        Pelicula peliculaDePruebaTres = new Pelicula("IT PARTE 1", "T0", "TERROR", "ANDRES MUSCHIETTI", 2017, 500, 135);
        ArrayList<Pelicula> ListaDeTodasLasPeliculas = new ArrayList<>();
        ListaDeTodasLasPeliculas.add(peliculaDePruebaUno);
        ListaDeTodasLasPeliculas.add(peliculaDePruebaDos);
        ListaDeTodasLasPeliculas.add(peliculaDePruebaTres);

        return ListaDeTodasLasPeliculas;
    }

    //Ejemplo 9: Function Arguments, capitulo 3, pag 40
    // Segun dice el libro, lo ideal seria tener metodos que no tengan que usar
    // parametros, ya que pueden traer mucos posibles resultados y se nos puede
    // salir de las manos.
    public ArrayList<Pelicula> ListaDePeliculasDeCienciaFiccion(ArrayList<Pelicula> listaDeTodasLasPeliculas) {

        ArrayList<Pelicula> listaDePeliculasDeCienciaFiccion = new ArrayList<>();

        for (Pelicula pelicula : listaDeTodasLasPeliculas) {
            if (pelicula.getGeneroDeLaPelicula().equalsIgnoreCase("CIENCIA FICCION")) {
                listaDePeliculasDeCienciaFiccion.add(pelicula);
            }

        }
        return listaDePeliculasDeCienciaFiccion;
    }

    //Lo hacemos sin parametros
    public ArrayList<Pelicula> ListaDePeliculasDeCienciaFiccion() {

        ArrayList<Pelicula> listaDeTodasLasPeliculas = ListaDeTodasLasPeliculasRegistradas();
        ArrayList<Pelicula> listaDePeliculasDeCienciaFiccion = new ArrayList<>();

        for (Pelicula pelicula : listaDeTodasLasPeliculas) {
            if (pelicula.getGeneroDeLaPelicula().equalsIgnoreCase("CIENCIA FICCION")) {
                listaDePeliculasDeCienciaFiccion.add(pelicula);
            }

        }
        return listaDePeliculasDeCienciaFiccion;
    }

    // Ejemplo 10: Have No Side Effects, capitulo 3, pag 44
    // La idea, como se ha estado diciendo desde el principio, es que una funcion solo haga una cosa
    // y que no tenga funciones ocultas a lo que uno espera que vaya a realizar. Ejemplo
//    public ArrayList<Pelicula> ListaDePeliculasDelSiglo21() {
//        ArrayList<Pelicula> listaDeTodasLasPeliculas = ListaDeTodasLasPeliculasRegistradas();
//        ArrayList<Pelicula> listaDePeliculasDelSiglo21 = new ArrayList<>();
//
//        for (Pelicula pelicula : listaDeTodasLasPeliculas) {
//            if (pelicula.getAñoDeLanzamientoDeLaPelicula() >= 2000) {
//                pelicula.setPrecioEnColonesDeLaPelicula(1000);
//                listaDePeliculasDelSiglo21.add(pelicula);
//            }
//        }
//        return listaDePeliculasDelSiglo21;
//    }
    // Como se puede notar, aparte de la funcion que esperabamos que era hacer una lista
    // Con las peliculas del 2000 en adelante, el metodo tambien aprovecha y le cambia
    // el precio a esas peliculas, dejandolo en 1000 colones.
    // Aqui tenemos 2 opciones, separamos en 2 metodos, o dejamos el metodo original
    // y le quitamos la signacion del precio nuevo:
    public ArrayList<Pelicula> ListaDePeliculasDelSiglo21() {
        ArrayList<Pelicula> listaDeTodasLasPeliculas = ListaDeTodasLasPeliculasRegistradas();
        ArrayList<Pelicula> listaDePeliculasDelSiglo21 = new ArrayList<>();

        for (Pelicula pelicula : listaDeTodasLasPeliculas) {
            if (pelicula.getAñoDeLanzamientoDeLaPelicula() >= 2000) {

                listaDePeliculasDelSiglo21.add(pelicula);
            }
        }
        return listaDePeliculasDelSiglo21;
    }

}
