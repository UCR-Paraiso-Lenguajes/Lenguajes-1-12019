
package com.projectOne.interactiveMessaging.tda;

public class Nodo {
    public Object element; //objeto almacenado en el nodo
    public Nodo follow; //apuntador al sgte nodo
    public Nodo previuos;//Apuntador al Nodo anterior
    //Constructor
    public Nodo(Object element){
        this.element = element;
        this.follow =this.previuos=null; //el nuevo nodo apunta a nulo
    }

    public Nodo() {
        this.element = element;
        this.follow = this.previuos=null; //el nuevo nodo apunta a nulo
    }

    public void setElemento(Object element) {
        this.element = element;
    }
    
    

    @Override
    public String toString() {
        return "Nodo{" + "elemento=" + element + '}';
    }
    
}
