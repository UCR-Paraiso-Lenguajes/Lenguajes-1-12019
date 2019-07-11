using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
    public class PedidoDespachado : Pedido
    {
        public PedidoDespachado(OrdenDeCompra ordenDeCompra)
        {
            OrdenDeCompra = ordenDeCompra;
        }

        public Pedido Despechar() {


            return null;
        }
    }

}
