using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Clases.Domain
{
   public class Pedido
    {
        Carrito OrdendeCompra;
        string Id;
        string Email;
        string Direccion;
        List<ProductoCantidad> productos;

    }
}
