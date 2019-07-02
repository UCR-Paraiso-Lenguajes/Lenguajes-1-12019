using ExamenPriscilla.Controllers;
using ExamenPriscilla.Data;
using ExamenPriscilla.Domain;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace XUnitTestExamenPriscilla.Api
{
  public  class OrganigramaApiTest
    {
        private  OrganigramaData organigramaData;


        [Test]
        public void NuevoOrganigramaTest()
        {

            Organigrama organigrama1 = new Organigrama(null, "Organigrama INS",1);

            
            Assert.AreEqual(1, organigrama1.id);
            Assert.AreEqual("Organigrama INS", organigrama1.nombre);



        }

        [Test]
        public void variosOrganigramasTest()
        {

            Organigrama organigrama1 = new Organigrama(null, "Organigrama Fu", 2);
            Organigrama organigrama2 = new Organigrama(null, "Organigrama UCR", 3);

            Assert.AreEqual(2, organigrama1.id);
            Assert.AreEqual("Organigrama Fu", organigrama1.nombre);
            Assert.AreEqual(null, organigrama2.departamentos);
      



        }



    }
}
