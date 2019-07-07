﻿using System;
using System.Collections.Generic;
using System.Text;


using NUnit.Framework;
using System.Collections.Generic;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Domain
{
    public class ProductoTest
    {
        [SetUp]
        public void Setup()
        {
        }
        [Test]
        public void Positive()
        {
           
            Producto producto1 = new Producto(3000, 1, 0.03, "Producto 1", "ProductoCarritoPrueba1", 2, "https://pictures.dealer.com/t/twowheelmotorsportguelphtc/0354/1447ce5c0fe8b9e07bb124be064018d2x.jpg?impolicy=resize&w=240");

            Assert.False(producto1.PrecioUnitario == 2000);
            Assert.True(producto1.PrecioUnitario == 3000);
            Assert.IsNotNull(producto1.Nombre);
            Assert.IsNotNull(producto1.Descripcion);
            Assert.False(producto1.IdProducto == 2);
            Assert.True(producto1.IdProducto == 1);
            Assert.False(producto1.Impuesto == 5.2);
            Assert.True(producto1.Impuesto == 0.03);
            Assert.False(producto1.CantidadDisponible == 5);
            Assert.True(producto1.CantidadDisponible == 2);

            Assert.True(producto1.PrecioUnitario < producto1.PrecioProductoConImpuesto);

            Assert.AreNotEqual(producto1.PrecioUnitario, 3090);
            Assert.AreEqual(producto1.PrecioUnitario, 3000);

            Assert.AreNotEqual(producto1.PrecioProductoConImpuesto,3000);
            Assert.AreEqual(producto1.PrecioProductoConImpuesto, 3090);
        }
    }
}
