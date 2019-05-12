
package com.projectOne.interactiveMessaging.tda;

import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueLinked implements Queue {
	private Nodo previous;
	private Nodo after;
	private int count;

	public QueueLinked() {
		this.previous = null;
		this.after = null;
		this.count = 0;
	}

	@Override
	public int getSize() {

		return count;
	}

	@Override
	public boolean isEmpty() {
		return previous == null;
	}

	@Override
	public void annul() {
		this.previous = null;
		this.after = null;
		this.count = 0;
	}

	@Override
	public int getPosition(Object element) throws QueueException {
		if (isEmpty())
			throw new QueueException("La cola esta vacia");
		QueueLinked colaAux = new QueueLinked();

		int contador1 = 0;
		int contadorDefinitivo = -1;// Indica que no existe
		while (!isEmpty()) {
			contador1++;
			if (Util.igualQ(front(), element)) {

				contadorDefinitivo = contador1;
			}
			colaAux.queueUp(uncoil());

		}
		// al final dejo la cola con todos los elementos encolados
		previous = colaAux.previous;
		after = colaAux.after;
		count = colaAux.count;
		return contadorDefinitivo;
	}

	public Object getElement(Object element) throws QueueException {
		if (isEmpty())
			throw new QueueException("La cola esta vacia");
		if (exists(element)) {
			QueueLinked colaAux = new QueueLinked();
			Object elementoToReturn = new Object();

			while (!isEmpty()) {

				if (Util.igualQ(front(), element)) {
					elementoToReturn = front();

				}
				colaAux.queueUp(uncoil());

			}
			// al final dejo la cola con todos los elementos encolados
			previous = colaAux.previous;
			after = colaAux.after;
			count = colaAux.count;
			return elementoToReturn;
		} else {
			return false;
		}

	}

	@Override
	public void queueUp(Object element) {
		Nodo nuevoNodo = new Nodo(element);
		if (isEmpty()) {// La primera vez
			after = nuevoNodo;
			// garantizo que anterior quede apuntando al primer nodo
			previous = after;
		} else {// Significa que al menos hay uno
			after.follow = nuevoNodo;
			after = nuevoNodo;
		}
		count++;
	}

	@Override
	public Object uncoil() {
		if (isEmpty())
			return null;
		Object elemento = previous.element;
		// caso1 Cuando solo hay un elemento
		// Cuando estan apuntando al mismo nodo
		if (previous == after) {
			annul();// Eliminamos la cola

		}
		// Caso2 cuando hay varios
		else {
			previous = previous.follow;
		}
		// Actuaalizo el contador
		count--;
		return elemento;
	}

	@Override
	public boolean exists(Object element) throws QueueException {
		if (isEmpty())
			throw new QueueException("La cola esta vacia");
		QueueLinked colaAux = new QueueLinked();
		boolean encontrado = false;
		while (!isEmpty()) {
			if (Util.igualQ(front(), element)) {
				encontrado = true;
			}
			colaAux.queueUp(uncoil());
		}
		// al final dejo la cola con todos los elementos encolados
		previous = colaAux.previous;
		after = colaAux.after;
		count = colaAux.count;
		return encontrado;
	}

	@Override
	public Object front() {
		if (isEmpty())
			return null;
		return previous.element;
	}

	public Nodo getNodo(int position) throws QueueException {
		if (isEmpty())
			throw new QueueException("La cola esta vacia");
		Nodo aux = previous;
		int posLista = 1;
		while (aux != null) {
			if (Util.igualQ(posLista, position)) {
				return aux;
			}
			posLista++;
			aux = aux.follow;
		}
		return null;
	}

	@Override
	public String toString() {
		if (isEmpty())
			return "La cola esta vacía";
		String result = "\nCola Enlazada\n";

		QueueLinked colaAux = new QueueLinked();
		while (!isEmpty()) {

			result += front() + ", ";
			colaAux.queueUp(uncoil());

		}
		// al final dejo la cola con todos los elementos encolados

		previous = colaAux.previous;
		after = colaAux.after;
		count = colaAux.count;
		return result;
	}

	public void uncoil(Nodo nodo) {

		Object elemento = previous.element;
		// caso1 Cuando solo hay un elemento
		// Cuando estan apuntando al mismo nodo
		if (previous == after) {
			annul();// Eliminamos la cola

		}
		// Caso2 cuando hay varios
		else {
			previous = previous.follow;
		}
		// Actuaalizo el contador
		count--;
	}

	

}
