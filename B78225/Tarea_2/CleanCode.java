/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author diego vega rodriguez B78225
 *
 */
public class CleanCode {

    //Los nombres de los metodos deben contener un verbo los de las variables deben ser un sustantivo
    //Ejemplo 1
    //Use Intention-Revealing Names Pag.18
    //El nombre de la variable o el metodo debe de responder al porque de su existencia y al para que se va usar
    public int divide() {
        int resultado = 0;

        //incorrecto
        int n = 30;
        int d = 2;

        //correcto
        int numero = 30;
        int divisor = 2;

        return resultado = (numero / divisor);
    }

    //Ejemplo 2
    //Avoid Disinformation Pag.19
    //si se esta hablando de varios objetos del mismo tipo en un arreglo como por ejemplo un arreglo con razas de perros
    //no es necesario pornerle listDogRaces con ponerle dogRaces es suficiente ya que podria crear un mal entendido al no ser una lista
    public void readDogRaces() {

        //incorrecto
        String[] listDogRaces = new String[3];

        //correcto
        String[] dogRaces = new String[3];

        for (int i = 0; i < 10; i++) {

            System.out.println(dogRaces[i]);
        }
    }

    //Ejemplo 3
    //Use Pronounceable Names Pag.21
    //No usar abreviaciones ya que son poco informativas
    //No usar variables muy similares ya que puede ser confuso
    public int calculaSueldo() {
        int resultado = 0;

        //incorrecto
        int sph = 9000;
        int h = 8;

        //correcto
        int sueldoPorHora = 9000;
        int horas = 8;

        return resultado = sueldoPorHora * horas;
    }

    //Ejemplo 4
    //Avoid Encodings Pag.23
    // si la variable se va a usar varias veces en el metodo es preferible ponerle un nombre que sea facil de buscar ya que
    //algunas veces es dificil localizar la variable entre lineas y peor si hay alguna con un nombre similar por lo que seria
    //mejor usar nombre de variables capaces de diferenciar de la una a la otra
    public double calculateAverageHoursPerWeek() {
        double averageHours = 0;

        //incorrecto
        int extraHours = 6;
        int lunchHours = 2;
        int h = 8;
        int days = 6;
        int hoursWeek = 0;

        //correcto
        int extraHoursPerWeek = 6;
        int lunchHoursPerDay = 2;
        int hoursPerWeek = 0;
        int DAYS_PER_WEEK = 6;
        int hours = 8;

        hoursPerWeek = ((hours + extraHoursPerWeek) * DAYS_PER_WEEK) - (lunchHoursPerDay * DAYS_PER_WEEK);
        averageHours = (hoursPerWeek / DAYS_PER_WEEK) * 100;

        return averageHours;

    }

    //Ejemplo 5
    //Member Prefixes Pag.24
    //no es necesario utilizar prefijos en los nombres de las claces o variables, ya deben de ser lo suficientemente sencillas para no tener que utilizarlos
    public class player {

        //incorrecto
        String p_name;
        String p_description;
        String t_name;

        //correcto
        String PlayerName;
        String description;
        String teamName;

        void setDescription(String PlayerName, String description, String teamName) {
            this.PlayerName = PlayerName;
            this.description = description;
            this.teamName = teamName;
        }
    }

    //Ejemplo 6
    // se debe identar bien para llevar un mayor orden y para que otra persona pueda entener mejor nuestro codigo
    //incorrecto
    public void identingBad() {
    int id = 12;
      String name = "Diego";
  String apellido = "Vega";
        int edad = 22;
    }

    //correcto
    public void identingGood() {
        int id = 12;
        String name = "Diego";
        String apellido = "Vega";
        int edad = 22;
    }

    //Ejemplo 7
    //Do one thing Pag.35
    //No utilizar un metodo para dos diferenres propositos
    //incorrect
    public double[] calculateAverageHoursPerWeekFillArray(double averageHours, int extraHoursPerWeek, int lunchHoursPerDay, int hoursPerWeek, int DAYS_PER_WEEK, int hours) {
        double[] averageHoursArray = new double[6];
        hoursPerWeek = ((hours + extraHoursPerWeek) * DAYS_PER_WEEK) - (lunchHoursPerDay * DAYS_PER_WEEK);
        averageHours = (hoursPerWeek / DAYS_PER_WEEK) * 100;

        for (int i = 0; i < averageHoursArray.length; i++) {
            averageHoursArray[i] = averageHours;
        }

        return averageHoursArray;

    }

    //correct  
    public void calculateAverageHoursPerWeek(double averageHours, int extraHoursPerWeek, int lunchHoursPerDay, int hoursPerWeek, int DAYS_PER_WEEK, int hours) {

        hoursPerWeek = ((hours + extraHoursPerWeek) * DAYS_PER_WEEK) - (lunchHoursPerDay * DAYS_PER_WEEK);
        averageHours = (hoursPerWeek / DAYS_PER_WEEK) * 100;

        fillArrayPerAverageHoursPerWeek(averageHours);

    }

    public double[] fillArrayPerAverageHoursPerWeek(double averageHours) {
        double[] averageHoursArray = new double[6];

        for (int i = 0; i < averageHoursArray.length; i++) {
            averageHoursArray[i] = averageHours;
        }
        return averageHoursArray;
    }

    //Ejemplo 8 
    //Use Descriptive Names Pag.39
    //usar nombres que que describan bien la funcion no importa que tan largo sea el nombre
    public void fill() {
    }

    public void fillArrayOfCitiesNames() {
    }

    //Ejemplo 9
    //Argument Objects Pag.43
    //Intentar usar mas argumentos de lo necesario
    //incorrect
    public void addEmployee(String name, String firstName, String lastName, int id) {
    }

    //correct
    public void addEmployee(String fulltName, int id) {
    }

    //Ejemplo 10
    //Structured Programming Pag.48
    //cada funcion debetener una salida por lo tanto debe de tener un retun al menos en un ciclo
    //por lo que no se debe usar break ni continue
    //incorrecto
    public int devuelveUltimoDigito(int numero) {
        
        //incorrecto
        while (true) {
          numero = numero/10;
            if (numero < 10) {
                break;
            }
        }
        
         //correcto
        while (true) {
          numero = numero/10;
            if (numero < 10) {
               return numero;
            }
        }

    }

}
