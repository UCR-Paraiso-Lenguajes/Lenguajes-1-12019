package ejemplos;

/**
 * Clase utilizada para subtema "Datos/Antisimetria de los objetos" del capitulo 6
 * Ejemplo de una clase de tipo "Procesal" o "Esetructura de datos"
 * @author Jean Carlos Monge Mendez
 *
 */
public class Cuadrilatero {

	/*
	 * Estructuras de datos: Agregar nuevas variaciones de cuadrilateros solo afecta
	 * la clase que maneja estas estructuras (Clase Cuadrilatero) Pero cuando se
	 * agrega un nuevo método no afecta a las estructuras (Clases Cuadrado,
	 * Rectangulo y Rombo) estas permanecen intactas, solo se modifica la clase
	 * Cuadrilatero.
	 * 
	 * P.96
	 */
	
	/**
	 * Metodo que retorna el Area de un cuadrilatero,
	 * ejemplo de un metodo de la ley de Demeter:
	 * Un metodo solo puede acceder a metodos de la clase Cuadrilatero,
	 * Objeto creado por ObtenerArea (Cuadrado, Rectangulo, Rombo, etc),
	 * Objeto pasado por parametro de ObtenerArea (Object cuadrilatero),
	 * Un objeto creado en la instancia de Cuadrilatero (en este caso no hay variables globales)
	 * 
	 * 
	 * También se trabaja la implementacion de excepciones del capitulo 7: 
	 * Usar Excepciones en lugar de codigos de error y proveer contexto con las excepciones.
	 * Tampoco retornal Null.
	 * @param cuadrilatero
	 * @return
	 * @throws Exception 
	 */
	public double ObtenerArea(Object cuadrilatero) throws Exception {
		if (cuadrilatero instanceof Cuadrado) {
			Cuadrado cuadrado = new Cuadrado();
			return cuadrado.lado * 2;
		} else {
			if (cuadrilatero instanceof Rectangulo) {
				Rectangulo rectangulo = new Rectangulo();
				return rectangulo.base * rectangulo.altura;
			} else {
				if (cuadrilatero instanceof Rombo) {
					Rombo rombo = new Rombo();
					return rombo.diagonalMayor * rombo.diagonalMenor;
				} else {
					throw new Exception("El objeto pasado por parametro no corresponde a ningun tipo de cuadrilatero contemplado");
				}
			}
		}
	}
}

class Cuadrado {
	public double lado;
}

class Rectangulo {
	public double base;
	public double altura;
}

class Rombo {
	public double diagonalMayor;
	public double diagonalMenor;
}