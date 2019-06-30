using System;
using System.Collections.Generic;
using System.Text;


using NUnit.Framework;
using System.Collections.Generic;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Domain
{
    public class PedidoTest
    {
        [SetUp]
        public void Setup()
        {
        }
        public OrdenDeCompra getOrdenDeCompra(int cantidadProductos)
        {
            List<ProductoCantidad> listaProductos = new List<ProductoCantidad>();
            ProductoCantidad productoCantidad;
            Producto producto;
            double totalCompra = 0;
            for (int i = 1; i < cantidadProductos; i++)
            {
                producto = new Producto(2000, i, 0.05, "Producto " + i, "ProductoCarritoPrueba" + i, 11);
                productoCantidad = new ProductoCantidad(producto, i);
                listaProductos.Add(productoCantidad);
                totalCompra = totalCompra + (i * productoCantidad.CompraTotalProducto);
            }
            return new OrdenDeCompra(listaProductos, totalCompra);

        }
        [Test]
        public void Positive()
        {
            /*int id, string email, string direccion, OrdenDeCompra ordenDeCompra, DateTime fechaUltimoUso*/
            PedidoPendiente pedidoPendiente = new PedidoPendiente(1, "helloWorld@hotmail.com","Perez Zeledon, San Jose, Costa Rica",getOrdenDeCompra(6),DateTime.Now);
            PedidoDespachado pedidoDespachado = new PedidoDespachado(2, "helloWorld2@hotmail.com", "Desamparados, San Jose, Costa Rica", getOrdenDeCompra(7),
                DateTime.Now, getOrdenDeCompra(7).TotalCompra);
            PedidoEntregado pedidoEntregado = new PedidoEntregado(3, "helloWorld3@hotmail.com", "Barrio Mexico, San Jose, Costa Rica", getOrdenDeCompra(8),
                DateTime.Now, getOrdenDeCompra(8).TotalCompra, getOrdenDeCompra(8).ProductosCantidad.Count);

            Assert.AreNotEqual(pedidoPendiente,pedidoDespachado);
            Assert.AreNotEqual(pedidoDespachado, pedidoEntregado);
            Assert.AreNotEqual(pedidoPendiente, pedidoEntregado);

            Assert.NotNull(pedidoPendiente.Email);
            Assert.NotNull(pedidoDespachado.Email);
            Assert.NotNull(pedidoEntregado.Email);

            Assert.False(pedidoPendiente.Direccion.Equals("Desamparados, San Jose, Costa Rica"));
            Assert.False(pedidoDespachado.Direccion.Equals("Barrio Mexico, San Jose, Costa Rica"));
            Assert.False(pedidoEntregado.Direccion.Equals("Perez Zeledon, San Jose, Costa Rica"));

        }
    }
}
