using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
    public class PedidoEntregado : Pedido
    {
        public PedidoEntregado(OrdenDeCompra ordenDeCompra)
        {
            OrdenDeCompra = ordenDeCompra;
        }

      

    }
}
