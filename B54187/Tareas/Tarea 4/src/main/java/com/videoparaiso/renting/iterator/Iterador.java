package com.videoparaiso.renting.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterador implements Iterator<Movimientos> {
	public Node inicio;

	List<Movimientos> movimientos = new ArrayList<Movimientos>();
	Iterator<Movimientos> iterator = movimientos.iterator();

	@Override
	public boolean hasNext() {
		while (iterator.hasNext()) {
			Movimientos movimientos = iterator.next();
			return true;
		}
		return false;
	}

	public void insertar(Movimientos movimientos) {
		Node auxNode = inicio;

		if (auxNode == null) {
			auxNode = new Node(movimientos);
			this.inicio = auxNode;
		} else {
			while (auxNode.next != null) {
				auxNode = auxNode.next;
			}
			auxNode.next = new Node(movimientos);
		}
	}

	@Override
	public Movimientos next() {
		return null;
	}
}
