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
        private int precio;
    

        public Producto()
        {
        }

        public Producto(int idProducto, decimal impuesto, string nombre, string descripcion, int cantidadDisponible, int precio,string imagen)
        {
            this.IdProducto = idProducto;
            this.Impuesto = impuesto;
            this.Nombre = nombre;
            this.Descripcion = descripcion;
            this.CantidadDisponible = cantidadDisponible;
            this.Precio = precio;
            this.Imagen = imagen;
        }

        public Producto(string nombre, decimal impuesto, int cantidadDisponible, string descripcion, string imagen, int precio)
        {
            this.Impuesto = impuesto;
            this.Nombre = nombre;
            this.Descripcion = descripcion;
            this.CantidadDisponible = cantidadDisponible;
            this.Precio = precio;
            this.Imagen = imagen;
        }




        public string Nombre { get => nombre; set => nombre = value; }
        public decimal Impuesto { get => impuesto; set => impuesto = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public int CantidadDisponible { get => cantidadDisponible; set => cantidadDisponible = value; }
        public string Imagen { get => imagen; set => imagen = value; }
        public int IdProducto { get => idProducto; set => idProducto = value; }
        public int Precio { get => precio; set => precio = value; }
    }
}
