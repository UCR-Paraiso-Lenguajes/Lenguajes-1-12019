using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
    public class ProductoCarrito
    {
        private int idCarrito;
        private int idProducto;


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
