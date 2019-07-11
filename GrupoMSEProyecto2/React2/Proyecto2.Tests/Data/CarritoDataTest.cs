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
        public void ObtenerCarritoPorUsuario()
        {
            CarritoData carritoData = new CarritoData();
            Object salida = carritoData.ObtenerCarritoPorUsuario(305060959);
            bool prueba = salida is Carrito;
            if (prueba)
            {
                //Es  Carrito
                Carrito carrito = (Carrito)salida;
                Assert.AreEqual("1",carrito.Id);
                Assert.AreNotSame(256,carrito.Usuario.IdUsuario);
                Assert.Positive(carrito.Pedido.OrdenDeCompra.ProductosCantidad.Count);

                
                Assert.IsTrue(carrito.Pedido is PedidoEntregado);

            }
            else
            {
                //No existe el carrito

            }


        }
    }
}
