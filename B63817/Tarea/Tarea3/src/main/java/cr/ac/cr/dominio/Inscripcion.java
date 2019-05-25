package cr.ac.cr.dominio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//Cap 7- caso 1: Usar exepciones en lugar de còdigos devueltos, al generar una exepciòn los metodos pueden detectar errores
//Cap 7- caso 3: Usar exepciones sin comprobar
//Cap 7- caso 5: Definir clases de exepciòn de acuerdo a las necesidaes del invocador
//Cap 7-caso 8:Definir flujo normal
//

public class Inscripcion {
	
	private ArrayList<Concursante> listaConcursantes= new ArrayList<Concursante>();
	
	//Cap 7- caso2: Crear primero la instrucciòn Try-catch-finally
	public void agregarConcursante(Concursante concursante) {
		
		try {
			
			tratarDeAgregar(concursante);
		} catch (Exception e) {
			//Cap 7- caso 4: Ofrecer contexto junto a las expepciones
			System.out.println("Error al agregar concursante");
		}
	}



	private void tratarDeAgregar(Concursante concursante) throws InscripcionException{
			encontrarConcursante(concursante);
			listaConcursantes.add(concursante);
	
 
	}

	//Cap7-caso 7: No devolver Null
	private Boolean encontrarConcursante(Concursante concursante) throws InscripcionException {
		 Boolean bandera=false;
		 
		if(!listaConcursantes.contains(concursante)) {
		bandera=true;
		}
		else {throw new  InscripcionException("Error al agregar concursante"); }
		return bandera;
		}

	
	public ArrayList<Concursante> getListaConcursantes() {
		return listaConcursantes;
	}

	public void setListaConcursantes(ArrayList<Concursante> listaConcursantes) {
		this.listaConcursantes = listaConcursantes;
	}

	//Cap 6- caso 6: Objetos de transferencia de datos
	public Concursante consultarConcursanteEnBaseDeDatos(ResultSet rs) throws SQLException {
	
		Concursante concursante= new Concursante();
		concursante.setNombre(rs.getString("Valeria"));
		return concursante;
		  } 
	
}


