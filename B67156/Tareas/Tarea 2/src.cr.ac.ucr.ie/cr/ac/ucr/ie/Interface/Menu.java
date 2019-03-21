package cr.ac.ucr.ie.Interface;

import javax.swing.JOptionPane;

import cr.ac.ucr.ie.domain.Audivisuales;
import cr.ac.ucr.ie.domain.Biblioteca;
import cr.ac.ucr.ie.domain.Libro;

public class Menu {
	/*
	 * Tip 4
	 * Nombres significativos para variables
	 *Las variables revelan su cometido,ya que son o la unidad de medida o una descripcion significativa
	 *no se utilizan prefijos puesto no cambiaria su significado
	 *Nombres cortos 
	 *No existen redundancias
	 *No existen abreviaciones o simplificaciones 
	 *ver Pag de 45 a 50*/
	String descripcionLibro = "";
	String descripcionAudiovisual = "";
	Biblioteca biblioteca = new Biblioteca();
	
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método intenta ser lo mas optimizado posible
	 * nombres descriptivos pag 53 y 59*/
	public void MenuPrincipal() {
		/*Tip 5
		 * Como la variable no queda clara se opta por comentar su significado*/
		int numeroAccion = 0; //Representa la acción que se tomará en el menú principal
		while(numeroAccion != 4) {
			numeroAccion = ManejaExcepciones(JOptionPane.showInputDialog (null, "MENU PRINCIPAL BIBLIOTECA\nIngrese el valor que corresponde a la acción que desea realizar\n1) Ingresar\n2) Eliminar\n3) Mostrar\n4)Salir"));
			if (numeroAccion == 1) {
				MenuIngresar();
			}else if (numeroAccion == 2) {
				MenuEliminar();
			}else if (numeroAccion == 3) {
				MenuMostrar();
			}else if (numeroAccion == 4) {
				int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea salir de la aplicación?");
				if(confirmar == 1) {
					numeroAccion = 0;
				}
			}else{
				JOptionPane.showMessageDialog(null, "Valor erroneo fuera del dominio");
			}
		}
		
	}
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método intenta ser lo mas optimizado posible
	 * nombres descriptivos pag 53 y 59*/
	private void MenuIngresar() {
		/*Tip 5
		 * Como la variable no queda clara se obta por comentar su significado*/
		int numeroAccionIngresar = 0;//Representa la acción que se tomará en el menú Ingresar
			numeroAccionIngresar = ManejaExcepciones(JOptionPane.showInputDialog(null, "INGRESAR\nIngrese el valor que corresponde a la acción que desea realizar: \n1) Libro\n 2) Audivisual"));
			if (numeroAccionIngresar == 1) {
				GuardaLibros();
			}else if (numeroAccionIngresar == 2) {
				GuardaAudivisual();
			}else{
				JOptionPane.showMessageDialog(null, "Valor erroneo fuera del dominio");
			}
	}
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método realiza solo un acción en funcion a su nombre 
	 * nombres descriptivos pag 53 y 59*/
	private void GuardaLibros() {
		String nombreLibro = JOptionPane.showInputDialog("Ingrese el nombre del libro que desea registrar:");
		String editorial = JOptionPane.showInputDialog("Ingrese el editorial del libro que desea registrar:");
		String ano = JOptionPane.showInputDialog("Ingrese el año del libro que desea registrar:");
		/*Tip 10
		 * Nombres de objetos deben ser sustantivos o frases de sustantivos
		 * pag 53*/
		Libro libro = new Libro(nombreLibro, editorial, ano);
		biblioteca.libros.add(libro);
		JOptionPane.showMessageDialog(null, "El libro ingresado se ha registrado");
	}
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método realiza solo un acción en funcion a su nombre 
	 * nombres descriptivos pag 53 y 59*/
	private void GuardaAudivisual() {
		String nombreaudiovisual = JOptionPane.showInputDialog("Ingrese el nombre del audiovisual que desea registrar:");
		String codigo = JOptionPane.showInputDialog("Ingrese el codigo del audiovisual que desea registrar:");
		/*Tip 10
		 * Nombres de objetos deben ser sustantivos o frases de sustantivos
		 * pag 53*/
		Audivisuales audivisuales = new Audivisuales(nombreaudiovisual,codigo);
		biblioteca.audivisuales.add(audivisuales);
		JOptionPane.showMessageDialog(null, "El audiovisual ingresado se ha registrado");
	}
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método realiza solo un acción en funcion a su nombre 
	 * nombres descriptivos pag 53 y 59*/
	private void MenuEliminar() {
		int numeroAccionEliminar = 0;//Representa la acción que se tomará en el menú Eliminar
			numeroAccionEliminar = ManejaExcepciones(JOptionPane.showInputDialog(null, "ELIMINAR\nIngrese el valor que corresponde a la acción que desea realizar: \n1) Libro\n 2) Audivisual"));
			if (numeroAccionEliminar == 1) {
				EliminaLibro();
			}else if (numeroAccionEliminar == 2) {
				EliminaAudiovisual();
			}else{
				JOptionPane.showMessageDialog(null, "Valor erroneo fuera del dominio");
			}
	}
	/*Tip 6 
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método realiza solo un acción en funcion a su nombre 
	 * nombres descriptivos pag 53 y 59*/
	private void EliminaLibro() {
		String nombreLibro = JOptionPane.showInputDialog("Ingrese el nombre del libro que desea eliminar:");
		if (BuscaLibros(nombreLibro) != -1) {
			biblioteca.libros.remove(BuscaLibros(nombreLibro));
		}
	}
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método realiza solo un acción en funcion a su nombre 
	 * nombres descriptivos pag 53 y 59*/
	private void EliminaAudiovisual() {
		String nombreAudiovisual = JOptionPane.showInputDialog("Ingrese el nombre del audiovisual que desea eliminar:");
		if (BuscaAudiovisuales(nombreAudiovisual) != -1) {
			biblioteca.audivisuales.remove(BuscaAudiovisuales(nombreAudiovisual));
		}
	}
	
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método realiza solo un acción en funcion a su nombre 
	 * nombres descriptivos pag 53 y 59*/
	private void MenuMostrar() {
		int numeroAccionMostrar= 0;//Representa la acción que se tomará en el menú Mostrar
			numeroAccionMostrar = ManejaExcepciones(JOptionPane.showInputDialog(null, "Mostrar\nIngrese el valor que corresponde a la acción que desea realizar: \n1)Libros\n 2)Audivisuales"));
			if (numeroAccionMostrar == 1) {
				MuestraLibro();
			}else if (numeroAccionMostrar == 2) {
				MuestraAudiovisual();
			}else{
				JOptionPane.showMessageDialog(null, "Valor erroneo fuera del dominio");
			}
	}
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método realiza solo un acción en funcion a su nombre 
	 * nombres descriptivos pag 53 y 59*/
	private void MuestraLibro() {
		/*Tip 8
		 * cada bloque if o while se intenta que contenga solo una linea de codigo*/
		for (Libro libro : biblioteca.libros) {
			descripcionLibro += "Nombre: " +libro.getNombreDeLibro()+"\nEditorial: "+ libro.getEditorial()+ "\nAño: "+libro.getAño()+"\n\n";
		}
		JOptionPane.showMessageDialog(null,descripcionLibro);
		descripcionLibro = "";
	}
	/*Tip 6
	 * Método que contiene nombres significativos
	 * cumplen con una cantidad de lineas optimas
	 * El método realiza solo un acción en funcion a su nombre 
	 * nombres descriptivos pag 53 y 59*/
	private void MuestraAudiovisual() {
		/*Tip 8
		 * cada bloque if o while se intenta que contenga solo una linea de codigo*/
		for (Audivisuales audiovisual : biblioteca.audivisuales) {
			descripcionAudiovisual += "Nombre: " + audiovisual.getNombreDeAudivisuales()+ "\nCodigo: "+ audiovisual.getCodigo()+"\n\n";
		}
		JOptionPane.showMessageDialog(null,descripcionAudiovisual);
		descripcionAudiovisual = "";
	}
	/*Tip 7
	 * Este es un Método monodico el cual cumple con la idea de tener un argumento y retornar 
	 * un objeto diferente al que entró
	 * Se intenta reducir la cantidad de lineas lo mejor posible*/
	private int BuscaLibros(String nombreLibro) {
		for (int i = 0; i<biblioteca.libros.size(); i++) {
			Libro libro = biblioteca.libros.get(i);
			/*Tip 8
			 * cada bloque if o while se intenta que contenga solo una linea de codigo*/
			if(libro.getNombreDeLibro().equalsIgnoreCase(nombreLibro)) {
				return i;
			}
		}
		return -1;
	}
	/*Tip 7
	 * Este es un Método monodico el cual cumple con la idea de tener un argumento y retornar 
	 * un objeto diferente al que entró
	 * Se intenta reducir la cantidad de lineas lo mejor posible*/
	private int BuscaAudiovisuales(String nombreAudiovisual) {
		for (int i = 0; i<biblioteca.audivisuales.size(); i++) {
			Audivisuales audiovisual = biblioteca.audivisuales.get(i);
			/*Tip 8
			 * cada bloque if o while se intenta que contenga solo una linea de codigo*/
			if(audiovisual.getNombreDeAudivisuales().equalsIgnoreCase(nombreAudiovisual)) {
				return i;
			}
		}
		return -1;
	}
	
	/*Tip 9
	 * Se estrae el bloque de Try/catch ya que ademas de que se pueden utilizar en varias 
	 * funciones anteriores es preferible separarlos del cuerpo de las funciones ya que en 
	 * ocasiones tienden a confundir
	 * ver Pag 76 */
	private int ManejaExcepciones(String caracterIngresado) {
		int valor = -1;
		try {
			valor = Integer.parseInt(caracterIngresado);
		}catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Valor que ingresó es incorrecto");
		}
		return valor;
	}
}
