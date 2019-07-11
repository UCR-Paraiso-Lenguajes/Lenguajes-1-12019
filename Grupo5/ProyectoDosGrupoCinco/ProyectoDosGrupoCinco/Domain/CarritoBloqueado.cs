using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
  public  class CarritoBloqueado:Carrito
    {

        public CarritoBloqueado(int idCarrito, int idComprador, int total, int subtotal)
        {
            IdCarrito = idCarrito;
            Usuario.IdComprador = idComprador;
            Total = total;
            SubTotal = subtotal;
        }


    }
}
