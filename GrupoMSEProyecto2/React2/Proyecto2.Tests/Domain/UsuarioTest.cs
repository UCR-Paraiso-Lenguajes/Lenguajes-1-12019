using System;
using System.Collections.Generic;
using System.Text;


using NUnit.Framework;
using System.Collections.Generic;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Domain
{
    public class UsuarioTest
    {
        [SetUp]
        public void Setup()
        {
        }
        [Test]
        public void Positive()
        {
            //(decimal idUsuario, string nombre, string pasword, string correoPrincipal
            Usuario usuario1 = new Usuario(1,"Esteban Arrieta","Esteban123","esteban123@hotmail.com");
            Usuario usuario2 = new Usuario(2, "Manfred Gonzalez", "Manfred123", "manfred123@gmail.com");
            Usuario usuario3 = new Usuario(3, "Santiago Brenes", "Santiago123", "santiago123@yahoo.com");

            Assert.AreNotEqual(usuario1, usuario2);
            Assert.AreNotEqual(usuario2, usuario3);
            Assert.AreNotEqual(usuario1, usuario3);

            Assert.IsTrue(usuario1.Pasword.Trim()!=null || usuario1.Pasword.Equals(""));
            Assert.IsFalse(usuario2.IdUsuario == 1 && usuario1.CorreoPrincipal.Equals(""));
            Assert.IsTrue(usuario3.IdUsuario == 3 && usuario1.Nombre.Equals("Esteban Arrieta"));

            Assert.NotZero(usuario1.IdUsuario);
            Assert.Positive(usuario3.IdUsuario);

        }
    }
}
