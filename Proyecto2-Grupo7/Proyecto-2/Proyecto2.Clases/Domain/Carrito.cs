using System;
using System.Collections.Generic;
using System.Text;

namespace Proyecto2.Clases.Domain
{
    public class Carrito
    {

        public Carrito(List<ProductoCantidad> productoCantidad, string id, Comprador comprador)
        {
            ProductoCantidad = productoCantidad;
            Id = id;
            Comprador = comprador;
          

        }

        public Carrito()
        {

        }


        private List<ProductoCantidad> productoCantidad = new List<ProductoCantidad>();
        public List<ProductoCantidad> ProductoCantidad = new List<ProductoCantidad>();
        internal IEnumerable<ProductoCantidad> Listar()
        {
            return productoCantidad;
        }

        public void Add(ProductoCantidad productoCantidadTemp)
        {
            if (productoCantidad == null) throw new Exception("El producto cantidad requerido.");

            productoCantidad.Add(productoCantidadTemp);
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

        private Comprador comprador;
        public Comprador Comprador
        {
            get
            {
                return comprador;
            }
            set
            {
                if (comprador == null) throw new Exception("El comprador es requerido.");
                comprador = value;
            }
        }




    }
}
