package com.videocartago.renting.domain;

import java.util.Iterator;

public class MovimientosIterator implements Iterable {
    private static class Node {
        Movimientos movimientos;
        Node sig;
    }
    private Node cabeza;

    public void agregar(Movimientos movimientos) {
        Node nuevo = new Node();
        nuevo.movimientos = movimientos;
        nuevo.sig = cabeza;
        cabeza = nuevo;
    }

    private class MiIterador implements Iterator<Movimientos> {
        private Node actual;
        public MiIterador(Node actual) {
            this.actual = actual;
        }
        @Override
        public boolean hasNext() {
            return actual.sig != null;
        }

        @Override
        public Movimientos next() {
        	Movimientos resultado = actual.movimientos;
            actual = actual.sig;
            return resultado;
        }
    }

    @Override
    public Iterator<Movimientos> iterator() {
        return new MiIterador(cabeza);
    }
}