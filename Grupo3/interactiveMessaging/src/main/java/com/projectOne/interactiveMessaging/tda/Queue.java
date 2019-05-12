

package com.projectOne.interactiveMessaging.tda;

public interface Queue {
	public int getSize(); // Devuelve el numero de
	public boolean isEmpty(); // true si la pila esta
	public void annul();
	public int getPosition(Object element) throws QueueException;
	public void queueUp(Object element);
	public Object uncoil() throws QueueException;
	public boolean exists(Object element) throws QueueException;
	public Object front() throws QueueException;
}
