using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
    public class PedidoPendiente : Pedido
    {
        public PedidoPendiente(OrdenDeCompra ordenDeCompra)
        {
            OrdenDeCompra = ordenDeCompra;
        }


        public PedidoPendiente(OrdenDeCompra ordenDeCompra, int id)
        {
            IdPedido = id;
            OrdenDeCompra = ordenDeCompra;
        }

        public PedidoPendiente()
        {
         
        }
    }
}
