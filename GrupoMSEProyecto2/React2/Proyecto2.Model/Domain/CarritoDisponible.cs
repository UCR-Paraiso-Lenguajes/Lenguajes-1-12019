using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Model.Domain
{
    public class CarritoDisponible : Carrito
    {
        public void Asignar(Producto producto, int cantidad)
        {

        }
        public bool ValidarAsignar(Producto producto, int cantidad)
        {
            return false;
        }
        public Pedido Comprar()
        {
            return new Despachado();
        }
        public void Quitar(Producto producto)
        {

        }
    }
}
