using System;
using System.Collections.Generic;
using System.Text;


using NUnit.Framework;
using System.Collections.Generic;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Domain
{
    public class CarritoTest
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
            for (int i = 1; i < cantidadProductos; i++)
            {
                producto = new Producto(2000, i, 0.05, "Producto " + i, "ProductoCarritoPrueba" + i, 11, "https://pictures.dealer.com/t/twowheelmotorsportguelphtc/0354/1447ce5c0fe8b9e07bb124be064018d2x.jpg?impolicy=resize&w=240");
                productoCantidad = new ProductoCantidad(producto, i);
                listaProductos.Add(productoCantidad);
            }
            return new OrdenDeCompra(listaProductos);
            
        }
        [Test]
        public void Positive()
        {
            //string id, Usuario usuario, decimal subtotal, int total, Pedido pedido

            Usuario usuario1 = new Usuario(1, "Esteban Arrieta", "Esteban123", "esteban123@hotmail.com");
            PedidoPendiente pedidoPendiente = new PedidoPendiente(1, "helloWorld@hotmail.com", "Perez Zeledon, San Jose, Costa Rica", getOrdenDeCompra(6), DateTime.Now);
            Carrito  carrito1 = new Carrito("c111",usuario1,pedidoPendiente);

            Usuario usuario2 = new Usuario(2, "Manfred Gonzalez", "Manfred123", "manfred123@gmail.com");
            PedidoDespachado pedidoDespachado = new PedidoDespachado(2, "helloWorld2@hotmail.com", "Desamparados, San Jose, Costa Rica", getOrdenDeCompra(7),
                DateTime.Now, getOrdenDeCompra(7).TotalCompra);
            Carrito carrito2 = new Carrito("c222", usuario2,pedidoDespachado);

            Usuario usuario3 = new Usuario(3, "Santiago Brenes", "Santiago123", "santiago123@yahoo.com");
            PedidoEntregado pedidoEntregado = new PedidoEntregado(3, "helloWorld3@hotmail.com", "Barrio Mexico, San Jose, Costa Rica", getOrdenDeCompra(8),
                DateTime.Now, getOrdenDeCompra(8).TotalCompra, getOrdenDeCompra(8).ProductosCantidad.Count);
            Carrito carrito3 = new Carrito("c333", usuario3,pedidoEntregado);

            Assert.IsNotNull(carrito1);
            Assert.IsNotNull(carrito2);
            Assert.IsNotNull(carrito3);

            Assert.AreEqual(carrito1.Id,"c111");
            Assert.AreNotEqual(carrito3.Id,"c3333");

            int cantidadDeProductos = carrito2.Pedido.OrdenDeCompra.ProductosCantidad.Count;
            Assert.Positive(cantidadDeProductos);
            Assert.NotZero(cantidadDeProductos);
            Assert.AreEqual(cantidadDeProductos,6);

            Assert.IsFalse(carrito3.Pedido == null);
            Assert.IsNotEmpty(carrito1.Usuario.Nombre);


        }
    }
}
