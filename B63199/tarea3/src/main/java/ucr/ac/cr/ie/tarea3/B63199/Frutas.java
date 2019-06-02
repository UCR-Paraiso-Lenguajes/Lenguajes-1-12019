package ucr.ac.cr.ie.tarea3.B63199;

//Data Abstraction Pág 93
public interface Frutas {
	//Incorrecto:
	float obtenerPesoDeFrutaSinCascara();
	String averiguarNombreFrutaCitrica(Object fruta);
	
	//Correcto:
	String obtenerNombre();
	
}

