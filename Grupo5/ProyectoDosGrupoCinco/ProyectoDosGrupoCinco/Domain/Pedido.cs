using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
   public abstract class Pedido
    {
        private OrdenDeCompra ordenDeCompra;
        private int idPedido;

        public Pedido(OrdenDeCompra ordenDeCompra)
        {
            this.OrdenDeCompra = ordenDeCompra;
        }

        public Pedido(OrdenDeCompra ordenDeCompra, int idPedido)
        {
            this.IdPedido = idPedido;
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

        public int IdPedido
        {
            get
            {
                return idPedido;
            }
            set
            {

                idPedido = value;
            }
        }
    }
}
