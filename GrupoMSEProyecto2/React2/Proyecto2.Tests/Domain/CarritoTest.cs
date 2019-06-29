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
            
        }
    }
}
