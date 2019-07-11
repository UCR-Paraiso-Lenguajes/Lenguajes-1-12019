using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using Proyecto2.Clases.Bussiness;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;

namespace Proyecto2.Test
{
    class CompanniaBussinessTest
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void TestListarProductos()
        {

            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            List<Producto> products = companniaBussiness.ListarProducto(50);
            Assert.AreEqual(50, products.Capacity);

        }

        [Test]
        public void TestBuscarProductoPorId()
        {
            Producto producto = new Producto("1010", 23, "https://st-listas.20minutos.es/images/2015-04/395912/4688314_640px.jpg?1428205607", "Computadora", "Dell", 40);
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            Producto producto1 = companniaBussiness.ProductoPorId(producto.Id);
            Assert.AreEqual(producto.Id, producto1.Id);
            Assert.AreEqual(producto.Impuesto, producto1.Impuesto);
            Assert.AreEqual(producto.Url_image, producto1.Url_image);
            Assert.AreEqual(producto.Nombre, producto1.Nombre);
            Assert.AreEqual(producto.Descripcion, producto1.Descripcion);
        }

        [Test]
        public void TestBuscarProductoPorId2()
        {
            Producto producto = new Producto("1010", 23, "https://st-listas.20minutos.es/images/2015-04/395912/4688314_640px.jpg?1428205607", "Computadora", "Dell", 34);
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            Producto producto1 = companniaBussiness.ProductoPorId(producto.Id);
            Assert.AreEqual(producto.Id, producto1.Id);
            Assert.AreEqual(producto.Impuesto, producto1.Impuesto);
            Assert.AreEqual(producto.Url_image, producto1.Url_image);
            Assert.AreEqual(producto.Nombre, producto1.Nombre);
            Assert.AreEqual(producto.Descripcion, producto1.Descripcion);
            Assert.AreEqual(producto.CantidadDisponible, producto1.CantidadDisponible);
        }

        [Test]
        public void ActualizarInventario()
        {

            Producto producto = new Producto("1010", 23, "https://st-listas.20minutos.es/images/2015-04/395912/4688314_640px.jpg?1428205607", "Computadora", "Dell", 40);
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            companniaBussiness.ActualizarInventario(producto, 34);
            
            Assert.AreEqual(companniaBussiness.ProductoPorId(producto.Id).CantidadDisponible,34 );

        }

        [Test]
        public void TestRecuperarCarrito()
        {
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            CarritoData carritoData = new CarritoData();
            Carrito carrito= carritoData.getCarritobyid(2);
            Carrito carrito2= companniaBussiness.recuperarCarrito("2");
            Assert.AreEqual(carrito.Id, carrito2.Id);
            Assert.AreEqual(carrito.Comprador.Id, carrito2.Comprador.Id);
        }

        [Test]
        public void TestRecuperarCarrito2()
        {
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            Carrito carrito = companniaBussiness.recuperarCarrito("5");
            Assert.AreNotEqual(null, carrito);
        }
        
        [Test]
        public void TestAgregarProductoAlCarrito()
        {
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            CarritoData carritoData = new CarritoData();
            Producto producto = new Producto("1007", 90, "https://st-listas.20minutos.es/images/2015-04/395912/4688310_249px.jpg?1428205607", "2 XBOX 360", "Color negro", 9);
            companniaBussiness.AgregarProductoAlCarrito(producto, 2, "3");
            ProductoCantidad productoCantidad = companniaBussiness.ProductoCantidadPorId("3","1007");
            Assert.AreEqual(producto.Id, productoCantidad.Producto.Id);

        }
        [Test]
        public void TestComprarCarrito()
        {
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            Producto producto = companniaBussiness.ProductoPorId("1007");
            companniaBussiness.comprarCarrito(2, "milenarojasleiva@gmail.com", "Paraiso");
            Pedido pedido = companniaBussiness.PedidosPorIdCarrito("2");
            Assert.AreNotEqual(null, pedido);
            ProductoCantidad productoCantidad = companniaBussiness.ProductoCantidadPorId("2", "1007");
            Producto producto2 = companniaBussiness.ProductoPorId("1007");
            Assert.AreEqual(producto.CantidadDisponible-productoCantidad.Cantidad,producto2.CantidadDisponible);
            

        }

        [Test]
        public void TestComprarCarritoSinProductos()
        {
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            Producto producto = companniaBussiness.ProductoPorId("1014");
            companniaBussiness.comprarCarrito(4, "valerialeivaquiros@gmail.com", "Paraiso");
            Pedido pedido = companniaBussiness.PedidosPorIdCarrito("4");
            Assert.AreNotEqual(null, pedido);
            ProductoCantidad productoCantidad = companniaBussiness.ProductoCantidadPorId("4", "1014");
            Producto producto2 = companniaBussiness.ProductoPorId("1014");
            Assert.AreEqual(producto.CantidadDisponible, producto2.CantidadDisponible);
        }




        [Test]
        public void TestPedidoPorId()
        {


            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            CarritoData carritoData = new CarritoData();
            Carrito carrito = carritoData.getCarritobyid(2);
            List<ProductoCantidad> productos = carrito.ProductoCantidad;
            Pedido pedido = new Pedido(carrito, "13","milenarojasleiva@gmail.com", "Paraiso", productos);
            Pedido pedido1 = companniaBussiness.PedidosPorId("13");
            Assert.AreEqual(pedido.Id, pedido1.Id);
            Assert.AreEqual(pedido.Direccion, pedido1.Direccion);


        }


        [Test]
        public void TestListarPedidos()
        {
            CompanniaBussiness companniaBussiness = new CompanniaBussiness();
            List<Pedido> pedidos = companniaBussiness.ListarPedido(50);
            Assert.AreEqual(50, pedidos.Capacity);

        }

    }
}
