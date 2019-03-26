package ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;

/**
 * Objetos y estructuras de datos
 * @author Jean Carlos Monge Mendez
 *
 */
public class Main {
	
	
	/* 
	 * Abstraccion de los datos: Ver Clase Triangulo
	 */
	
	
	/*
	 * Estructuas de datos y Orientacion a objetos:
	 * 
	 * Estructuras de datos: Ver clase Cuadrilatero
	 * Orientacion a objetos: Ver clase TrianguloEquilatero 
	 */
	
	
	/*
	 * Ley de Demeter: Ver clase Cuadrilatero, metodo ObtenerArea()
	 */
	
	
	/*
	 * Ruinas del tren: Ver clase Edificio
	 */
	public void MostrarEjemplo() {
		Edificio edificio = new Edificio();
		String nombreUbicacionDelEdificio = edificio.ubicacion.nombre;
	}
	
	/*
	 * Objetos de transferencia de datos: Ver clase Edificio, clase Ubicacion
	 */
	
	
	/*
	 * Usar Excepciones en lugar de codigos de error y proveer contexto de las excepciones:
	 * Ver clase Cuadrilatero, metodo ObtenerArea()
	 */
	
	
	/*
	 * Usar Try-Catch-Finally: Conexion a base de datos
	 */
	public void ConectarBaseDeDatos(String cadenaConexionPrincipal, String cadenaConexionSecundaria) {
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(cadenaConexionPrincipal);
			
			//Consultas a la base de datos
			
		}catch (Exception exepcionPrincipal) {
			System.out.println("Conexion a base de datos principal falló: "+exepcionPrincipal.getMessage());
			try {
				conexion = DriverManager.getConnection(cadenaConexionSecundaria);
				
				//Consultas a la base de datos
				
			} catch (SQLException excepcionSecundaria) {
				System.out.println("Conexion a base de datos secundaria falló: "+excepcionSecundaria.getMessage());
			}
		}finally {
			try {
				conexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("No se pudo cerrar la conexion: "+e.getMessage());
			}
		}
	}
}