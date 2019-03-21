package tarea2_lenguajes;

 import java.util.ArrayList;

 /**
 *
 * @author Samuel
 */

  /**
     
     * CAPÍTULO 2
     
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

 	public getNameById(int id){
	     if(this.id == id)
		return this.name;
	}        

 	public getProffesion(){
	    return this.proffesion;
	}
    }


     //ejemplo 5 --> Avoid disinformation / ser claro con la información
    public static String WORD;
    public void appendLetters(char letter){
        WORD+=letter;
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
        return "Id not in the DB.";
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
        for (Worker worker : workers) {
            if(id == worker.id){
                return true;                 // if there are *TOO MANY* workers this may be useful
            }                                   // obiously there are more efective ways to make a search
        }
        return false;
    }


    //ejemplo 5 --> Dyadic Functions / funciones que reciben 2 parametros
    public int multiplication(int numberA,int numberB){
        return numberA * numberB;
    }
} 