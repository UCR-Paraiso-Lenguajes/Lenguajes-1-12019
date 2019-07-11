using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
  public class ProductoCantidad
    {
        private Producto producto;
        private int cantidad;

        public Producto Producto { get => producto; set => producto = value; }
        public int Cantidad { get => cantidad; set => cantidad = value; }
    }
}
