package cr.ac.ucr.ie.tarea3.domain;

public class Utilidades {
	/*Tip 2: 
	 * metodo que se utiliza para trabajar con la ayuda de otros metodos,
	 * lo cual se usa en los trenes de choques*/
	public static int maximo(int objeto1, int objeto2)throws MensajeExcepción {
		if(objeto1==0 && objeto2==0) {
			throw new MensajeExcepción("Las variables vienen nulos");
		}
		int max = 0;
		if (objeto1 >  objeto2) {
			max = objeto1;
		}else {
			max = objeto2;
		}
		return max;
	}
}
