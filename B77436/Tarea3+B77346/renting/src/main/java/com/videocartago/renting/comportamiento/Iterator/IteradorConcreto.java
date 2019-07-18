package com.videocartago.renting.comportamiento.Iterator;

public class IteradorConcreto implements Iterador {
	
     private Movimientos agregado;
     private int posicion_actual = 0;
    
    public IteradorConcreto( Movimientos agregado ){
         this.agregado = agregado;
    }
    
    
    @Override
     public Object primero()
    {
        Object obj = "";
        if( this.agregado.lista.isEmpty() == false )
        {
            this.posicion_actual = 0;
            obj = this.agregado.lista.firstElement();
        }
        return obj;
    }
    
    
    @Override
     public Object siguiente()
    {
        Object obj = "";
        if( (this.posicion_actual ) < this.agregado.lista.size() )
        {
            obj = this.agregado.lista.elementAt(this.posicion_actual);
            this.posicion_actual = this.posicion_actual + 1;
        }
        return obj;
    }
    
    
    @Override
     public boolean hayMasElementos()
    {
        boolean validaExistenciaElementos = false;
        if( this.posicion_actual < (this.agregado.lista.size() ) )
        {
        	validaExistenciaElementos = true;
        }
        return validaExistenciaElementos;
    }
    
    
    @Override
     public Object actual()
    {
        Object obj = "";
        if( this.posicion_actual < this.agregado.lista.size() )
        {
            obj = this.agregado.lista.elementAt( this.posicion_actual );
        }
        return obj;
    }
}