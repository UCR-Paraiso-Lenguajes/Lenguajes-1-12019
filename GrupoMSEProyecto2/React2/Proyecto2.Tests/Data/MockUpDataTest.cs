using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using Proyecto2.Model.Data;

namespace Proyecto2.Tests.Data
{
    public class MockUpDataTest
    {
        [SetUp]
        public void Setup()
        {
        }
        [Test]
        public void positive()
        {
            MockUpData mockUp = new MockUpData();

            Assert.NotNull(mockUp.Carritos);
            Assert.NotNull(mockUp.Usuarios);

            Assert.AreNotEqual("carrito 1",mockUp.Carritos[0].Id);
            Assert.AreEqual("carrito 2", mockUp.Carritos[0].Id);
            Assert.AreEqual("carrito 3", mockUp.Carritos[1].Id);
            Assert.AreEqual("Usuario 2",mockUp.Usuarios[0].Nombre);

            Assert.True(mockUp.Carritos.Count == mockUp.Usuarios.Count);
        }
    }
}
