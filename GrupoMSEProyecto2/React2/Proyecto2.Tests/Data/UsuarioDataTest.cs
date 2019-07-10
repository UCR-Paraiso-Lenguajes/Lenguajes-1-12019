using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Data
{
    public class UsuarioDataTest
    {
        [SetUp]
        public void Setup()
        {
        }
        [Test]
        public void listarUsuario()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            UsuarioData comprador = new UsuarioData(sqlconnect);

            

            IEnumerable<Usuario> lista = comprador.GetAll();

            Assert.NotNull(lista);

        }

        [Test]
        public void InsertarComprador()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            UsuarioData usuarioData = new UsuarioData(sqlconnect);

            Usuario comprador = new Usuario(3, "Samuel", "samu123", "samistile@gmail.com");

            Assert.AreEqual(3, comprador.IdUsuario);
            Assert.AreEqual("Samuel", comprador.Nombre);
            Assert.AreEqual("samu123", comprador.Pasword);
            Assert.AreEqual("samistile@gmail.com", comprador.CorreoPrincipal);

            usuarioData.InsertarComprador(comprador);

        }

        [Test]
        public void ActualizarComprador()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            UsuarioData usuarioData = new UsuarioData(sqlconnect);

            Usuario comprador = new Usuario(3, "Samuel", "SamuEL123", "samistile12@gmail.com");

            Assert.AreEqual(3, comprador.IdUsuario);
            Assert.AreEqual("Samuel", comprador.Nombre);
            Assert.AreEqual("SamuEL123", comprador.Pasword);
            Assert.AreEqual("samistile12@gmail.com", comprador.CorreoPrincipal);

            usuarioData.ActualizaComprador(comprador);

        }

        [Test]
        public void BorrarComprador()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            UsuarioData usuarioData = new UsuarioData(sqlconnect);

            Usuario comprador = new Usuario(3, "Samuel", "SamuEL123", "samistile12@gmail.com");

            Assert.AreEqual(3, comprador.IdUsuario);
            Assert.AreEqual("Samuel", comprador.Nombre);
            Assert.AreEqual("SamuEL123", comprador.Pasword);
            Assert.AreEqual("samistile12@gmail.com", comprador.CorreoPrincipal);

            usuarioData.BorrarComprador((int)comprador.IdUsuario);

        }
    }
}
