using System;
using System.Collections.Generic;
using System.Text;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;

namespace Proyecto2.Clases.Bussiness
{
   public class CompanniaBussiness
    {
        ProductoData productoData = new ProductoData();
        public IEnumerable<Producto> ListarProducto(int indice)
        {
            int cont = 0;
           List<Producto> products = productoData.ListProducts();
           List<Producto> productsContados = new List<Producto>();
            if (products.Capacity >= indice)
            {
                foreach (Producto producto in products)
                {
                    if (productsContados.Capacity<=50 ) {
                        productsContados.Add(producto);
                    }
                }
            }
            else {
                return products;
            }
            return productsContados;
        }
    }
}
