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
        CarritoData carritoData = new CarritoData();

        public IEnumerable<Producto> ListarProducto(int indice)
        {
            int cont = 0;
            List<Producto> products = productoData.ListProducts();
            List<Producto> productsContados = new List<Producto>();
            if (products.Capacity >= indice)
            {
                foreach (Producto producto in products)
                {
                    if (productsContados.Capacity <= 50)
                    {
                        productsContados.Add(producto);
                    }
                }
            }
            else
            {
                return products;
            }
            return productsContados;
        }

        public Producto ProductoPorId(string id)
        {
            Producto productoTemp = new Producto();
            List<Producto> products = productoData.ListProducts();


            foreach (Producto producto in products)
            {
                if (producto.Id.Equals(id))
                {
                    productoTemp = producto;
                }
            }
            return productoTemp;
        }


        public void ActualizarInventario(Producto producto, int cantidad)
        {
            Producto productoActualizar = new Producto();
            producto = ProductoPorId(producto.Id);
            producto.CantidadDisponible=cantidad;
            productoData.Actualizar(producto);
        }


        public Carrito recuperarCarrito(string idComprador) {
            Carrito carritoRecuperado = new Carrito();
            List<Carrito> carritos  =carritoData.listarCarritos();


            foreach (Carrito carrito in carritos)
            {
                if (carrito.Comprador.Id.Equals(idComprador))
                {
                    carritoRecuperado = carrito;
                }
            }
            if (carritoRecuperado.Id == null) {

                List<ProductoCantidad> productosCantidad = new List<ProductoCantidad>();
                carritoRecuperado.Comprador= carritoData.ListCompradorbyid(idComprador);
                carritoData.InsertarCarrito(carritoRecuperado);


            };


            return carritoRecuperado;
        }
        public void AgregarProductoAlCarrito(ProductoCantidad productoCantidad ,string idCarrito) {

            carritoData.InsertarProductoCantidad(productoCantidad,idCarrito);
            Producto productoActualizar = new Producto();
            productoActualizar = ProductoPorId(productoCantidad.Producto.Id);
            productoActualizar.CantidadDisponible = productoActualizar.CantidadDisponible - 1;
            productoData.Actualizar(productoActualizar);


        }

    }
}
