using ProyectoDosGrupoCinco.Data;
using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace ProyectoDosGrupoCinco.Business
{
   public class ProductoBusiness
    {
        ProductoData productoData = new ProductoData();
        public List<Producto> CargarProductos(int indice)//que tengan cantidad
        {
            return null;
        }

        public List<Producto> BuscarPorDescripcion(string descripcion)//descripciones truncadas
        {
            return productoData.BuscarPorDescripcion(descripcion);
        }

        public Producto MostrarDetalle(int idProducto)
        {
            return null;

        }
    }
}
