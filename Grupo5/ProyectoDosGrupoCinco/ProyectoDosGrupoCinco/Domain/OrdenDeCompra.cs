using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
   public class OrdenDeCompra: Pedido
    {

        private int idOrdenDeCompra;
        private string email;
        private string direccion;
        private List<ProductoCantidad> productosCantidad;

     
        public int IdOrdenDeCompra { get => idOrdenDeCompra; set => idOrdenDeCompra = value; }
        public string Email { get => email; set => email = value; }
        public string Direccion { get => direccion; set => direccion = value; }
        public List<ProductoCantidad> ProductosCantidad { get => productosCantidad; set => productosCantidad = value; }
    }
}
