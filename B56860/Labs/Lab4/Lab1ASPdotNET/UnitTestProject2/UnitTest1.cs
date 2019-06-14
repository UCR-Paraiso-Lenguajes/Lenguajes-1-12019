using Microsoft.VisualStudio.TestTools.UnitTesting;
using OrbisB56860.Model.Data;
using OrbisB56860.Model.Domain;
using System.Collections.Generic;

namespace UnitTestProject2
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            int a = 0;
            a++;
        }


        PublicadorData publicadorData;


        [TestMethod]
        public void GetAll()
        {
            IEnumerable<Publicador> listaPublicadores;
            listaPublicadores = publicadorData.GetAll();

            Assert.IsNotNull(listaPublicadores);

        }

    }
}
