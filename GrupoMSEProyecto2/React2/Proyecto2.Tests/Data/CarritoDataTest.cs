using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Data
{
    public class CarritoDataTest
    {
        [SetUp]
        public void Setup()
        {
        }
        [Test]
        public void PositiveObtenerCarritoPorUsuario()
        {
            CarritoData carritoData = new CarritoData();
            Object salida = carritoData.ObtenerCarritoPorUsuario(305060959);
                //Es  Carrito
            Carrito carrito = (Carrito)salida;
            Assert.AreEqual("1",carrito.Id);
            Assert.AreNotSame(256,carrito.Usuario.IdUsuario);
            Assert.Positive(carrito.Pedido.OrdenDeCompra.ProductosCantidad.Count);

                
            Assert.IsTrue(carrito.Pedido is PedidoEntregado);//74400
            Assert.GreaterOrEqual(744000, carrito.Pedido.TotalCompra);
            Assert.Less(carrito.Pedido.OrdenDeCompra.SubTotalCompra, carrito.Pedido.OrdenDeCompra.TotalCompra);

            Assert.AreNotEqual("manfredgh@yyyy.com",carrito.Pedido.Email);
        }
        [Test]
        public void NegativeObtenerCarritoPorUsuario()
        {
            CarritoData carritoData = new CarritoData();
            Object salida = carritoData.ObtenerCarritoPorUsuario(111111);

            Assert.IsFalse(salida is Carrito);
            Assert.IsTrue(salida is Boolean);
            Assert.AreSame(false, (bool)salida);

            //Sabemos por el false que el carrito no fue traido entonces se procede a reportar lo sucedido

        }
        [Test]
        public void InsertarCarrito()
        {
            List<ProductoCantidad> listaProducto = new List<ProductoCantidad>();
            Producto producto = new Producto(80000, 4, 5, "LG", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            Producto producto2 = new Producto(80000, 2, 5, "Huawei", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            ProductoCantidad productoCantidad = new ProductoCantidad(producto, 2);
            ProductoCantidad productoCantidad2 = new ProductoCantidad(producto2, 2);
            listaProducto.Add(productoCantidad);
            listaProducto.Add(productoCantidad2);

            OrdenDeCompra orden = new OrdenDeCompra(listaProducto);
            PedidoEntregado pedido = new PedidoEntregado(76, "manfredgh@gmail,com", "Alvarado,Cartago", orden, DateTime.Now, orden.TotalCompra, orden.ProductosCantidad.Count);

            Usuario comprador = new Usuario(3, "Samuel", "samu123", "samistile@gmail.com");

            Carrito carrito = new Carrito("105CarritoTest",comprador,pedido);
            CarritoData carritoData = new CarritoData();
            carritoData.InsertarCarrito(carrito);

            Object carritoRecObj = carritoData.ObtenerCarritoPorUsuario(3);
            if (carritoRecObj is Carrito)
            {
                Carrito carritoRecuperado = (Carrito)carritoRecObj;
                Assert.AreEqual(2,carritoRecuperado.Pedido.OrdenDeCompra.ProductosCantidad.Count);
                Assert.AreEqual(carrito.Id, carritoRecuperado.Id);
                Assert.True(carritoRecuperado.Pedido is PedidoEntregado);
                Assert.AreEqual("manfredgh@gmail,com", carritoRecuperado.Pedido.Email);
                Assert.True(carritoRecuperado.Usuario.IdUsuario == 3);
                // SE PUREBA DE UNA VEZ BORRAR CARRITO ---------------------------------------------------------------
                carritoData.BorrarCarrito(carritoRecuperado);

                Object carrito2 = carritoData.ObtenerCarritoPorUsuario(3);
                bool noExiste = (bool)carrito2;
                Assert.IsFalse(noExiste);
            }
            else
            {
                //No trae el carrrito
            }
            
        }
        [Test]
        public void AgregarProductoCantidadACarrito()
        {
            CarritoData carritoData = new CarritoData();
            Carrito carritoV1 = (Carrito)carritoData.ObtenerCarritoPorUsuario(305060959);
            Producto producto = new Producto(600000, 5, 12, "Dell",
                "Computadora Laptop", 30, "https://cdn.shopify.com/s/files/1/1167/3148/products/laptops-refurbished-dell-latitude-e6540-intel-i5-4th-gen-laptop-1_grande.png?v=1530975287");
            //double precioUnitario, int idProducto, double impuestoC, string nombre, string descripcion, int cantidadDisponible, string imagen
            ProductoCantidad productoCantidad = new ProductoCantidad(producto,5);
            carritoData.Actualiza(305060959, productoCantidad);

            Carrito carritoV2 = (Carrito)carritoData.ObtenerCarritoPorUsuario(305060959);

            //Assert.True(carritoV1.Pedido.OrdenDeCompra.ProductosCantidad.Count < carritoV2.Pedido.OrdenDeCompra.ProductosCantidad.Count);
            bool exist = false;
            foreach (ProductoCantidad productoCantidadE in carritoV2.Pedido.OrdenDeCompra.ProductosCantidad)
            {
                if (productoCantidadE.Producto.IdProducto == productoCantidad.Producto.IdProducto) exist = true;
            }
            Assert.IsTrue(exist);

            producto = new Producto(100000, 2, 10, "Alcatel",
                "Celular pk", 20, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            productoCantidad = new ProductoCantidad(producto, 2);
            ProductoCantidad productoSinAumentar = new ProductoCantidad();
            foreach (ProductoCantidad productoCantidadL in carritoV2.Pedido.OrdenDeCompra.ProductosCantidad)
            {
                if (producto.IdProducto.Equals(productoCantidadL.Producto.IdProducto))
                {
                    productoSinAumentar = productoCantidadL;
                }
            }
            carritoData.Actualiza(305060959, productoCantidad);
            carritoV2 = (Carrito)carritoData.ObtenerCarritoPorUsuario(305060959);

            ProductoCantidad productoActualizado = new ProductoCantidad();
            foreach (ProductoCantidad productoCantidadL in carritoV2.Pedido.OrdenDeCompra.ProductosCantidad)
            {
                if (producto.IdProducto.Equals(productoCantidadL.Producto.IdProducto))
                {
                    productoActualizado = productoCantidadL;
                }
            }
            Assert.NotNull(productoSinAumentar);
            Assert.NotNull(productoActualizado);
            Assert.NotZero(productoSinAumentar.Cantidad);
            Assert.NotZero(productoActualizado.Cantidad);
            Assert.AreNotEqual(productoSinAumentar, productoActualizado);
            Assert.True(productoSinAumentar.Cantidad< productoActualizado.Cantidad);

            

        }
        [Test]
        public void ComprarCarrito()
        {
            CarritoData carritoData = new CarritoData();
            Carrito carritoNoComprado = (Carrito)carritoData.ObtenerCarritoPorUsuario(305060959);
            bool comprado = carritoData.Comprar(carritoNoComprado);
            if (comprado)
            {
                Carrito carritoComprado = (Carrito)carritoData.ObtenerCarritoPorUsuario(305060959);
                //Assert.AreNotEqual(carritoNoComprado.Pedido.OrdenDeCompra.ProductosCantidad[0].Producto.CantidadDisponible,
                   // carritoComprado.Pedido.OrdenDeCompra.ProductosCantidad[0].Producto.CantidadDisponible);
                
            }
        }

    }
}
