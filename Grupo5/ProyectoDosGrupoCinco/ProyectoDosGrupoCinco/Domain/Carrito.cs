using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Domain
{
   public abstract class Carrito
    {
        private List<ProductoCantidad> productoCantidad;
        private int idCarrito;
        private List<Producto> productos;
        private Comprador usuario;
        private Comprador comprador;
        private decimal subTotal;
        private decimal total;

        public Comprador Usuario
        {
            get
            {
                return usuario;
            }
            set
            {

                usuario = value;
            }
        }

       

        public decimal SubTotal {
            get
            {
                return subTotal;
            }
            set
            {

                subTotal = value;
            }
        }
        public decimal Total {
            get
            {
                return total;
            }
            set
            {

                total = value;
            }
        }

        public int IdCarrito {
            get
            {
                return idCarrito;
            }
            set
            {

                idCarrito = value;
            }
        }
        

     

        public Carrito(int idCarrito,int idComprador, int total, int subtotal) {
            IdCarrito = idCarrito;
            Usuario.IdComprador = idComprador;
            Total = total;
            SubTotal = subtotal;
        }

    
        public Carrito(int idCarrito, int total, int subtotal)
        {
            IdCarrito = idCarrito;
            Total = total;
            SubTotal = subtotal;
        }
        public Carrito()
        {
          
        }

    }
}
