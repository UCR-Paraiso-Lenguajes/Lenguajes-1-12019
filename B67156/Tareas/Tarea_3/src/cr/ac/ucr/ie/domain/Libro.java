package cr.ac.ucr.ie.domain;


/* Capirulo 6 - Tip 2 
 * Asimetría de datos y objectos
 * Diferencias entre un objeto y una estructura de datos
 * En este caso el objeto oculta datos con abstracciones en que los metodos operan sobre los datos
 */
public class Libro {
	
	/*Capitulo 6 - Tip 3
	 * Ley de Demeter
	 * Objectos privados que solo se comuniquen con los de su interés.
	 * Ocultar la Estructura
	 * metodos ocultan de forma abstracta los datos
	 * 
	 */

	public String nombreDeLibro;
	public String Editorial;
	public int Año;
	
	public Libro(String nombreDeLibro, String editorial, int año) {
		
		/* Cap 7 - Tip 5
		 * Definir las excepciones de acuerdo a las necesidades que presenta el problema
		 * Ofrecer mensajes de error informativo que ayuden a guiar al problema encontrado
		 */
		
		/* Cap 7 - Tip 1
		 * Usar excepciones en lugar de códigos devueltos
		 * Ayuda a mejorar lo limpio del codigo y que este sea mas facil de interpretar
		 */
		
		/* Cap 7 - Tip 8
		 * No pasar NULL
		 * Al no pasar valores null haran que el programa se mas robusto 
		 * en cuanto al manejo de excepciones
		 */
		if(nombreDeLibro == null && nombreDeLibro.trim().equals("")) throw new RuntimeException("el nombre del libro es requerido");
		if(editorial == null && editorial.trim().equals("")) throw new RuntimeException("el nombre del editorial es requerido");
		if(año == 0) throw new RuntimeException("el año es requerido");
		
		this.nombreDeLibro = nombreDeLibro;
		Editorial = editorial;
		Año = año;
	}
	
	
	
	public Libro() {
		super();
	}



	public String getNombreDeLibro() {
		return nombreDeLibro;
	}
	public void setNombreDeLibro(String nombreDeLibro) {
		if(nombreDeLibro == null && nombreDeLibro.trim().equals("")) throw new RuntimeException("el nombre del libro es requerido");
		this.nombreDeLibro = nombreDeLibro;
	}
	public String getEditorial() {
		return Editorial;
	}
	public void setEditorial(String editorial) {
		if(editorial == null && editorial.trim().equals("")) throw new RuntimeException("el nombre del editorial es requerido");
		Editorial = editorial;
	}
	public int getAño() {
		return Año;
	}
	public void setAño(int año) {
		if(año == 0) throw new RuntimeException("el año es requerido");
		Año = año;
	}
}
