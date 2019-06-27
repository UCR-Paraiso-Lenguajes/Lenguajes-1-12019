using NUnit.Framework;
using OrbisB74560.Model.Data;
using OrbisB74560.Model.Domain;
using System.Collections.Generic;

namespace Tests
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Test1()
        {
            Libro g1 = new Libro(1, "Test", 2017, "104T", 3);

            Assert.AreEqual(1, g1.Id_libro);
            Assert.AreEqual("Test", g1.Titulo);
        }
        [Test]
        public void TestDataPublicador()
        {
            PublicadorData publicadorData = new PublicadorData();
            IEnumerable<Publicador> publicadores = publicadorData.GetAll();
            Assert.IsNotEmpty(publicadores);
            //Assert.Pass();
        }
        [Test]
        public void TestDataLibro()
        {
            string connectionString = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Lab4_IF4100_B74560_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            LibroData libroData = new LibroData(connectionString);
            IEnumerable<Libro> libros = libroData.GetByCodPublicador(1004);
            Assert.IsNotEmpty(libros);
            //Assert.Pass();
        }
    }
}