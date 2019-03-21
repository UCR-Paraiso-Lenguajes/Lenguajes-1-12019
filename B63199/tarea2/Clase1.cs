using System;


/*
 Leer los capítulos 2 y 3 de Clean Code. 
Hacer un pull request (PR) en el repositorio con su 
carné donde se apliquen 5 tips de cada uno de los 
capítulos, por lo tanto serían 10 tips al menos.

Deben poner un comentario en cada tip explicando 
en que parte del libro se basaron. 
*/


public class Class1
{
    //Basado en: "Pick One Word per Concept" pág.26
    //incorrecto:
    private int diferenciador;
    private int identificador;
    //correcto:
    private int cedula;
    private int carnet;

    //Basado en: "Intention-Revealing names" pág. 18
    private int dias; //incorrecto
    private int diasVividos; //correcto


    //Basado en: "Make Meaningful Distinctions" pág. 20 
    private String naranja; //incorrecto
    private String colorNaranja; //correcto


    //Basado en: "Use pronunceable names" pág. 22
    private int nDpt; //incorrecto
    private int numDepto; //correcto

    //Basado en: "Don't be cute" pág. 26
    //Incorrecto:
    public void zumbarALaColmena() {
        Console.WriteLine("Zumbar por ayuda");
    }
    //Correcto:
    public void pedirRefuerzos() {
        Console.WriteLine("Aiiiiyuuuuuuuuda");
    } 

    // Basado en: "Don´t Pun" pág 27.
    //Incorrecto:
    private void borrar(String nombre) {
        Console.WriteLine(nombre+" ha sido eliminado de este mundo.");
    }
    private void eliminar(int id) {
        Console.WriteLine(id + " ha sido eliminado de este mundo.");
    }
    //Correcto:
    private void borrarClientePorNombre(String nombre) {
        Console.WriteLine(nombre + " ha sido eliminado de este mundo.");
    }
    private void borrarClientePorId(int id) {
        Console.WriteLine(id + " ha sido eliminado de este mundo.");
    }



    //Basado en: "Blocks and Indenting" pág. 35
    //incorrecto:
    private Boolean avanzar = true;
    private boolean conducir(int velocidad) { if (velocidad != 0)
    avanzar = true; else avanzar = false; return avanzar;}
    //correcto:
    private boolean conducir(int velocidad)
    {
        if (velocidad != 0)
            avanzar = true;
        else
            avanzar = false;
        return avanzar;
    }

    //Basado en: "Flag Arguments" pág. 41
    //Incorrecto:
    public boolean listo(boolean bandera)
    {
        bandera = true;
        return bandera;
    }
    //correcto:
    public boolean platilloListoParaServir(boolean platilloListo)
    {
        platilloListo = true;
        return platilloListo;
    }

    //Basado en: "Verbs and Keywords"
    public boolean dibujar(boolean si)
    {
        if (si == false)
            si = true;
        return si;
    }//incorrecto
    public boolean dibujarConejo(boolean crearDibujo)
    {
        if (crearDibujo == false)
            crearDibujo = true;
        return crearDibujo;
    }



    public static void main(String []args)
    {
        Cliente cliente1 = new Object("Ana", "Gómez");
        Cliente cliente2 = new Object("Suley", "Cruz");

        agendar(cliente1);
        agendarClienteNuevo(cliente2);

        platilloListoParaServir(true);
        listo(false);

        pedirRefuerzos();
        zumbarALaColmena();

        borrar("Lucho");
        eliminar(1);
        borrarClientePorNombre("Ambar");
        borrarClientePorId(2);

        conducir(1);

        }

    //Basado en: "Use descriptive names" pág.39
    //Incorrecto:
    public void agendar(Cliente cliente)
    {
        if (cliente != null)
        {
            Console.WriteLine(cliente);
        }
    }//Correcto:
    public void agendarClienteNuevo(Cliente cliente)
    {
        if (cliente != null)
        {
            Console.WriteLine(cliente);
        }
    }
}
