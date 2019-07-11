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

            List<Producto> productos = productoData.ListProducts();
            List<Producto> productosTemp = new List<Producto>();

            int empezar = 0;
            int terminar = indice * 50;

            if (indice == 0)
            {
                terminar = 50;
            }

            for(int i = 0; i<indice; i++)
            {

                empezar +=50*i;
            }
            if (empezar != 0)
            {
                empezar += 1;
            }
            for(int i=empezar; i <= terminar; i++)
            {

                if (i >= productos.Count)
                {

                    break;

                }
                else
                {
                    productosTemp.Add(productos[i]);
                }




            }

            productos = productosTemp;

            return productos;
        }


        public List<Producto> CargarProductosBuscar(List<Producto> productosRecibida,int indice)//que tengan cantidad
        {

            List<Producto> productos = productosRecibida;
            List<Producto> productosTemp = new List<Producto>();

            int empezar = 0;
            int terminar = indice * 50;

            if (indice == 0)
            {
                terminar = 50;
            }

            for (int i = 0; i < indice; i++)
            {

                empezar += 50 * i;
            }
            if (empezar != 0)
            {
                empezar += 1;
            }
            for (int i = empezar; i <= terminar; i++)
            {

                if (i >= productos.Count)
                {

                    break;

                }
                else
                {
                    productosTemp.Add(productos[i]);
                }




            }

            productos = productosTemp;

            return productos;
        }





        public List<Producto> getAllProduct()
        {
            return productoData.ListProducts();
        }




        public List<Producto> BuscarPorDescripcion(string descripcion, int indice)//descripciones truncadas (descripcion, indice)
        {

          

            return CargarProductosBuscar(productoData.BuscarPorDescripcion(descripcion), indice);
        }

        public Producto MostrarDetalle(int idProducto)
        {
            return null;

        }


        public void ActualizarProducto(int id, Producto producto)
        {
            productoData.actualizarProducto(id, producto);

        }

        public void ActualizarCantidad(int id, int cantidad)
        {
            productoData.actualizarCantidad(id, cantidad);

        }
    }
}
