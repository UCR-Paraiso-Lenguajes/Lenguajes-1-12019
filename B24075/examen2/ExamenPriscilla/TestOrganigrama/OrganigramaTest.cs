using ExamenPriscilla.Data;
using ExamenPriscilla.Domain;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace TestOrganigrama
{
    public class OrganigramaTest
    {
        private OrganigramaData organigramaData;


        [NUnit.Framework.Test]
        public void NuevoOrganigramaTest()
        {

            Organigrama organigrama1 = new Organigrama(null, "Organigrama INS", 1);


            Assert.AreEqual(1, organigrama1.id);
            Assert.AreEqual("Organigrama INS", organigrama1.nombre);



        }

        [Test]
        public void OrganigramasTest()
        {

            Organigrama organigrama1 = new Organigrama(null, "Organigrama Fu", 2);
            Organigrama organigrama2 = new Organigrama(null, "Organigrama UCR", 3);

            Assert.AreEqual(2, organigrama1.id);
            Assert.AreEqual("Organigrama Fu", organigrama1.nombre);
       
        }

        [NUnit.Framework.Test]
        public void ActualizaOrganigramaTest2()
        {

            Organigrama organigrama1 = new Organigrama(null, "Organigrama INS", 1);


            Assert.AreEqual(1, organigrama1.id);
            Assert.NotNull("Organigrama INS", organigrama1.nombre);



        }



    }
}
