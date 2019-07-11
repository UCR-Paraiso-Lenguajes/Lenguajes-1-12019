using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
   public abstract class Pedido
    {
        private OrdenDeCompra ordenDeCompra;

        public Pedido(OrdenDeCompra ordenDeCompra)
        {
            this.OrdenDeCompra = ordenDeCompra;
        }

        public Pedido()
        {
            
        }

        public OrdenDeCompra OrdenDeCompra
        {
            get
            {
                return ordenDeCompra;
            }
            set
            {

                ordenDeCompra = value;
            }
        }
    }
}
