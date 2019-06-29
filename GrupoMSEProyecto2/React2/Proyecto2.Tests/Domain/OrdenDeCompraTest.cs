using System;
using System.Collections.Generic;
using System.Text;


using NUnit.Framework;
using System.Collections.Generic;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Domain
{
    public class OrdenDeCompraTest
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Positive()
        {
            List<ProductoCantidad> listaProductos = new List<ProductoCantidad>();
            ProductoCantidad productoCantidad;
            Producto producto;
            double totalCompra = 0;
            for (int i = 1; i < 10; i++)
            {
                producto = new Producto(2000, i, 0.05, "Producto " + i, "ProductoCarritoPrueba" + i, 11);
                productoCantidad = new ProductoCantidad(producto, i);
                listaProductos.Add(productoCantidad);
                totalCompra = totalCompra + (i * productoCantidad.CompraTotalProducto);
            }
            OrdenDeCompra orden1 = new OrdenDeCompra(listaProductos, totalCompra);

            Assert.NotNull(orden1);
            Assert.NotNull(orden1.ProductosCantidad);
            Assert.NotNull(orden1.TotalCompra);
            Assert.False(orden1.ProductosCantidad.Count < 8);
            Assert.True(orden1.ProductosCantidad.Count == 9);
            Assert.AreNotEqual(orden1.ProductosCantidad[0], orden1.ProductosCantidad[1]);
            Assert.AreNotEqual(orden1.ProductosCantidad[0].Producto.Nombre, "Producto 2");
            Assert.AreEqual(orden1.ProductosCantidad[0].Producto.Nombre, "Producto 1");
            Assert.AreEqual(orden1.ProductosCantidad[0].Cantidad, 1);
            Assert.AreEqual(orden1.ProductosCantidad[1].Producto.Nombre, "Producto 2");
            Assert.AreNotEqual(orden1.ProductosCantidad[1].Producto.Nombre, "Producto 1");
            Assert.AreEqual(orden1.ProductosCantidad[1].Cantidad, 2);

            Assert.AreNotEqual(orden1.TotalCompra,541000);
            Assert.AreEqual(orden1.TotalCompra, 541500);
        }
    }
}
