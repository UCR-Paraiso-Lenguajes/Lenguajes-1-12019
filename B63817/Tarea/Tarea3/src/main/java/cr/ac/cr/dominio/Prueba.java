package cr.ac.cr.dominio;


import javax.sound.midi.Soundbank;

public class Prueba {

	public static void main(String[] args) {

		Concursante concursante= new Concursante("Priscilla");
		Concursante concursante1= new Concursante("Michelle");
		
				Inscripcion i= new Inscripcion();
	
			

		i.agregarConcursante(concursante);
		i.agregarConcursante(concursante);
		i.agregarConcursante(concursante);
		i.agregarConcursante(concursante1);
	for (int j = 0; j < i.getListaConcursantes().size(); j++) {
		System.out.println(i.getListaConcursantes().get(j).toString()+j);
	}
		
		

	}

}
