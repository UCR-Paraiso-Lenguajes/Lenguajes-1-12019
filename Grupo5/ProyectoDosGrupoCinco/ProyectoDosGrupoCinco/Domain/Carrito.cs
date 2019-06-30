using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
   public abstract class Carrito
    {
        private List<ProductoCantidad> productoCantidad;
        private string idCarrito;
        private List<Producto> productos;
        private Comprador usuario;
        private decimal subTotal;
        private decimal total;

        public decimal SubTotal { get => subTotal; set => subTotal = value; }
        public decimal Total { get => total; set => total = value; }

        public void Asignar(Producto producto,int  cantidad)
        {

        }

        public bool ValidaAsignar(Producto producto, int cantidad)
        {
            return true;
        }

     void Quitar(Producto producto)
        {

        }

        public Carrito Recuperar()
        {
            return null;
        }
        

    }
}
