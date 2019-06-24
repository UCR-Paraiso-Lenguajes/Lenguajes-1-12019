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
            float totalCompra = 0;
            for (int i = 1; i < 10; i++)
            {
                producto = new Producto(2000, i, 5, "Producto " + i, "ProductoCarritoPrueba" + i, 11);
                productoCantidad = new ProductoCantidad(producto, i,i*producto.PrecioUnitario);
                listaProductos.Add(productoCantidad);
                totalCompra = totalCompra + i * producto.PrecioUnitario;
            }
            OrdenDeCompra orden1 = new OrdenDeCompra(listaProductos, totalCompra);

        }
    }
}
