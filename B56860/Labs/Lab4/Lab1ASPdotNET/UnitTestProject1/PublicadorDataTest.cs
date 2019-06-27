using Microsoft.VisualStudio.TestTools.UnitTesting;
using OrbisB56860.Model.Data;
using OrbisB56860.Model.Domain;
using System;
using System.Collections.Generic;

namespace XUnitTestProject1
{
    public class PublicadorDataTest
    {

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
