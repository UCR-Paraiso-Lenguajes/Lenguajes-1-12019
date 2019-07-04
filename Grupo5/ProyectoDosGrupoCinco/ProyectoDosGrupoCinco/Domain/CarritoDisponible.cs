using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
   public class CarritoDisponible : Carrito
    {
        public CarritoDisponible(int idCarrito, int idComprador, int total, int subtotal)
        {
            IdCarrito = idCarrito;
            Usuario.IdComprador = idComprador;
            Total = total;
            SubTotal = subtotal;
        }

        public CarritoDisponible(int idCarrito, int total, int subtotal)
        {
            IdCarrito = idCarrito;
            Total = total;
            SubTotal = subtotal;
        }
        public CarritoDisponible()
        {
          
        }

    }
}
