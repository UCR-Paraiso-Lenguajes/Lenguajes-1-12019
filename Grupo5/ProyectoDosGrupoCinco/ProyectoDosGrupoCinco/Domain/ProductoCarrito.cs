using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
    public class ProductoCarrito
    {
        private int idCarrito;
        private int idProducto;
        private int cantidad;

        public ProductoCarrito(int idCarrito, int idProducto, int cantidad)
        {
            IdCarrito = idCarrito;
            IdProducto = idProducto;
            Cantidad = cantidad;
        }


        public ProductoCarrito(int idCarrito, int idProducto)
        {
            IdCarrito = idCarrito;
            IdProducto = idProducto;
           
        }
        public ProductoCarrito()
        {

        }
        public int IdCarrito
        {
            get
            {
                return idCarrito;
            }
            set
            {

                idCarrito = value;
            }
        }

        public int Cantidad
        {
            get
            {
                return cantidad;
            }
            set
            {

                cantidad = value;
            }
        }

        public int IdProducto
        {
            get
            {
                return idProducto;
            }
            set
            {

                idProducto = value;
            }
        }
    }
}
