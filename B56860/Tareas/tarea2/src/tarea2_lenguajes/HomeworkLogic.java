package tarea2_lenguajes;

 import java.util.ArrayList;

 /**
 *
 * @author Samuel
 */

  /**
     
     * CAPÃ�TULO 2
     
 **/


 public class HomeworkLogic { //ejemplo 1 --> class names // nombres de clase deben ser sustantivos y no verbos     p.25
    //instead of class DoingHomework{


     public int age;

     //ejemplo 2 --> don't pun / evitar juegos de palabras  p.26-27

     public void increasePoints(){ //instead of addPoints(), mostly because of how many times 
        //code                  // you have used add and the semantic meaning
    }

     //ejemplo 3 --> don't be cute / abstenerce de usar sentido del humor en vez de un significado claro   p.26
    public void autoSave(){ //instead of cautiousManWorthsTwo()
        //code
    }


     //ejemplo 4 --> Member Prefixes / evitar prefijos complejos con descripciones y usar nombres simples    p.24

     public class Worker{
        private int id;
        private String proffesion;//instead of:   n_o_prof + //description of the variable 
        private String name;

         public Worker(){}

 	public String getNameById(int id){
	     if(this.id == id)
		return this.name;
        throw new RuntimeException("The person doesn´t exist");
	}        

 	public String getProffesion(){
	    return this.proffesion;
	}
    }


     //ejemplo 5 --> Avoid disinformation / ser claro con la informaciÃ³n

     
    public static String word;
    public void appendLetters(char letter){
        word+=letter;
    }



     /**
     
     * CAPÍTULO 3
     *
    **/


     // ejemplo 1 --> Monadic Forms / cuando quieren recibir solo 1 parametro   p.41
    public String personNameById(int id){
        ArrayList<Worker> workers = new ArrayList<>();
        for (Worker worker : workers) {
            if(id == worker.id){
                return worker.name;
            }
        }
        throw new RuntimeException("The person doesn´t exist");
    }


     //ejemplo 2 --> Flag Arguments / correcto nombramiento de las banderas     p.41

     public String permission(boolean isGiven){
        return isGiven? "yes":"no";
    }


     //ejemplo 3 --> Prefer Exceptions to Returning Error Codes / las ecepciones en vez de mensajes de error    p.46
    public void setAge(int age){
        if(age<=0) throw new RuntimeException("La edad no puede ser 0 o negativa");
        this.age = age;
    }


     //ejemplo 4 --> Structured Programming / uso de break, continue, etc en operaciones largas      p.48-49
    public boolean exists(int id){
        ArrayList<Worker> workers = new ArrayList<>();
        return workers.stream().anyMatch((worker) -> (id == worker.id));//I make a lambda expression, because the if was a litle bit redundant --"I think"
    }                                                                   //But most of all, because it´s less code.


    //ejemplo 5 --> Dyadic Functions / funciones que reciben 2 parametros
    public int multiplication(int numberA,int numberB){
        return numberA * numberB;
    }
} 