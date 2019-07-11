using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Clases.Domain
{
   public class Pedido
    {
        

        public Pedido(Carrito ordenDeCompra, string id, string email, string direccion, List<ProductoCantidad> productos)
        {
            OrdenDeCompra = ordenDeCompra;
            Id = id;
            Email = email;
            Direccion = direccion;
            Productos = productos;



        }

        public Pedido()
        {

        }

        private Carrito ordenDeCompra;
        public Carrito OrdenDeCompra
        {
            get
            {
                return ordenDeCompra;
            }
            set
            {
                
                ordenDeCompra = value;
            }
        }

        private string id;
        public string Id
        {
            get
            {
                return id;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("El id es requerido");
                id = value;
            }
        }

        private string email;
        public string Email
        {
            get
            {
                return email;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("El email es requerido");
                email = value;
            }
        }
        private string direccion;
        public string Direccion
        {
            get
            {
                return direccion;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("El email es requerido");
                direccion = value;
            }
        }



        private List<ProductoCantidad> productos = new List<ProductoCantidad>();
        public List<ProductoCantidad>  Productos = new List<ProductoCantidad>();
        internal IEnumerable<ProductoCantidad> Listar()
        {
            return productos;
        }

        public void Add(ProductoCantidad productoCantidad)
        {
            if (productoCantidad == null) throw new Exception("El producto cantidad requerido.");

            productos.Add(productoCantidad);
        }

      

       





    }
}
