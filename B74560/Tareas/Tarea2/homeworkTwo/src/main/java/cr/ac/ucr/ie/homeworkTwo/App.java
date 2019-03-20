package cr.ac.ucr.ie.homeworkTwo;

import cr.ac.ucr.ie.gui.Menu;


public class App 
{
	
	/* Capitulo 2 - Tip 5
	 * Nombres sencillos de encontrar. 
	 * La utilización de nombres con 
	 * solo una letra o con números son 
	 * complicados de encontrar. Es mejor 
	 * utilizar nombres completos.
	 */
	
	public static Menu menu;
	
    public static void main( String[] args ) throws Exception
    {
    	menu = new Menu();
    	menu.ShowMenu();
    }
}
