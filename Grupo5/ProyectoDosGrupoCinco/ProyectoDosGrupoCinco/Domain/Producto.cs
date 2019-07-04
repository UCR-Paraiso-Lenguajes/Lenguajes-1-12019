using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
   public class Producto
    {


        private int idProducto;
        private decimal impuesto;
        private string nombre;
        private string descripcion;
        private int cantidadDisponible;
        private string imagen;

        public Producto()
        {
        }

        public Producto(int idProducto, decimal impuesto, string nombre, string descripcion, int cantidadDisponible)
        {
            this.IdProducto = idProducto;
            this.Impuesto = impuesto;
            this.Nombre = nombre;
            this.Descripcion = descripcion;
            this.CantidadDisponible = cantidadDisponible;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public decimal Impuesto { get => impuesto; set => impuesto = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public int CantidadDisponible { get => cantidadDisponible; set => cantidadDisponible = value; }
        public string Imagen { get => imagen; set => imagen = value; }
        public int IdProducto { get => idProducto; set => idProducto = value; }
    }
}
