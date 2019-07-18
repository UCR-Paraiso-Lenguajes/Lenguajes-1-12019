using model.Data;
using model.Domain;
using NUnit.Framework;
using System;

namespace Tests
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

    

        [Test]
        public void NuevoDepartamentoTest()
        {

            Departamentos departamento1 = new Departamentos(1,"Asamblea de Socios", null);


            Assert.AreEqual(1, departamento1.IdDepartamento);
            Assert.AreEqual("Asamblea de Socios", departamento1.Nombre);
            
           

        }

        [Test]
        public void VariosDepartamentosTest()
        {

            Departamentos departamento1 = new Departamentos(1, "Asamblea de Socios", null);
            Departamentos departamento2 = new Departamentos(2, "Gerente General", departamento1);

            Assert.AreEqual(1, departamento1.IdDepartamento);
            Assert.AreEqual("Asamblea de Socios", departamento1.Nombre);
            Assert.AreEqual(2, departamento2.IdDepartamento);
            Assert.AreEqual("Gerente General", departamento2.Nombre);



        }

        [Test]
        public void IdDepartamentoValidation()
        {
            try
            {
                Departamentos departamento1 = new Departamentos(0, "Asamblea de Socios", null);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("El numero debe ser positivo", e.Message);
            }

        }

        [Test]
        public void NombreNullValidation()
        {
            try
            {
                Departamentos departamento1 = new Departamentos(1, null, null);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("Nombre es requerido.", e.Message);
            }

        }

        [Test]
        public void NombreEspaciosValidation()
        {
            try
            {
                Departamentos departamento1 = new Departamentos(1, "  ", null);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("No puede ingresar solo espacios", e.Message);
            }

        }



        /* [Test]
         public void NombresJefaturaYDepartamentoIgualesValidation()
         {
            Departamentos departamento1 = new Departamentos(1, "AsambleaSocios", null);
             try
             {
                 
                 Departamentos departamento2 = new Departamentos(2, "AsambleaSocios", departamento1);
                 Assert.Fail("Exception was expected.");
             }
             catch (Exception e)
             {
                 Assert.AreEqual("Nombre de departamento ya existe, no puede llamarse igual a su jefatura", e.Message);
             }

         }*/

        [Test]
        public void InsertDepartamento()
        {
            int id = 1;
            Departamentos departamento1 = new Departamentos(id, "AsambleaSocios", null); ;


            DepartamentosData d1 = new DepartamentosData();
            d1.InsertDepartamentos(departamento1,0);

            Assert.AreEqual(departamento1.IdDepartamento, d1.GetDepartamentosByID(departamento1.IdDepartamento).IdDepartamento);

        }

        [Test]
        public void InsertVariosDepartamentos()
        {
            
            Departamentos departamento1 = new Departamentos(1, "AsambleaSocios", null);
            Departamentos departamento2 = new Departamentos(2, "Gerente General", departamento1);
            Departamentos departamento3 = new Departamentos(3, "Gerente General", departamento1);

            DepartamentosData d1 = new DepartamentosData();
            d1.InsertDepartamentos(departamento1, 0);
            d1.InsertDepartamentos(departamento2, departamento1.IdDepartamento);
            d1.InsertDepartamentos(departamento3, departamento1.IdDepartamento);


            Assert.AreEqual(departamento1.IdDepartamento, d1.GetDepartamentosByID(departamento1.IdDepartamento).IdDepartamento);
            Assert.AreEqual(departamento2.IdDepartamento, d1.GetDepartamentosByID(departamento2.IdDepartamento).IdDepartamento);
            Assert.AreEqual(departamento3.IdDepartamento, d1.GetDepartamentosByID(departamento3.IdDepartamento).IdDepartamento);

        }

        [Test]
        public void BorrarDepartamento()
        {

           try
            {

           // Departamentos departamento1 = new Departamentos(1, "AsambleaSocios", null);


            DepartamentosData d1 = new DepartamentosData();
         //   d1.InsertDepartamentos(departamento1, 0);

            d1.DeleteDepartamento(1);

           


            
                d1.GetDepartamentosByID(1);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("Departamento no encontrado", e.Message);
            }

             

        }

        [Test]
        public void EditarDepartamento()
        {

          
                Departamentos departamento1 = new Departamentos(1, "AsambleaSocios", null);


                DepartamentosData d1 = new DepartamentosData();
                d1.InsertDepartamentos(departamento1, 0);
                departamento1.Nombre = "Jefes";

               d1.EditDepartamento(departamento1,departamento1.IdDepartamento);





                Assert.AreEqual(d1.GetDepartamentosByID(departamento1.IdDepartamento).Nombre, departamento1.Nombre);




        }

        [Test]
        public void NuevoOrganigramaTest()
        {

            Organigrama_Jerarquico organigrama_Jerarquico = new Organigrama_Jerarquico(1, "Asamblea de Socios");
            OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();

            organigramaJerarquicoData.InsertOrganigramaJerarquico(organigrama_Jerarquico);

            Assert.AreEqual(organigramaJerarquicoData.GetListOrganigramaJerarquicoByID(organigrama_Jerarquico.IdOrganigrama).IdOrganigrama, organigrama_Jerarquico.IdOrganigrama);
            Assert.AreEqual(organigramaJerarquicoData.GetListOrganigramaJerarquicoByID(organigrama_Jerarquico.IdOrganigrama).NombreOrganizacion, organigrama_Jerarquico.NombreOrganizacion);



        }

        [Test]
        public void NombreEspaciosOrganigramaValidation()
        {
            try
            {
                Organigrama_Jerarquico organigrama_Jerarquico = new Organigrama_Jerarquico(1, "  ");
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("No puede ingresar solo espacios", e.Message);
            }

        }

        [Test]
        public void NombreNullOrganigramaValidation()
        {
            try
            {
                Organigrama_Jerarquico organigrama_Jerarquico = new Organigrama_Jerarquico(1, null);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("Nombre es requerido.", e.Message);
            }

        }

        [Test]
        public void BorrarOrganigrama()
        {

            try
            {

                Organigrama_Jerarquico organigrama_Jerarquico = new Organigrama_Jerarquico(1, "Asamblea de Socios");
                OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();

                organigramaJerarquicoData.InsertOrganigramaJerarquico(organigrama_Jerarquico);

                organigramaJerarquicoData.DeleteOrganigramaJerarquico(organigrama_Jerarquico.IdOrganigrama);





                organigramaJerarquicoData.GetListOrganigramaJerarquicoByID(organigrama_Jerarquico.IdOrganigrama);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("El organigrama no fue encontrado", e.Message);
            }



        }

        [Test]
        public void EditarOrganigrama()
        {


            Organigrama_Jerarquico organigrama_Jerarquico = new Organigrama_Jerarquico(1, "Asamblea de Socios");
            OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();

            organigramaJerarquicoData.InsertOrganigramaJerarquico(organigrama_Jerarquico);

            organigrama_Jerarquico.NombreOrganizacion = "Jefes";

            organigramaJerarquicoData.EditOrganigramaJerarquico(organigrama_Jerarquico, organigrama_Jerarquico.IdOrganigrama);





            Assert.AreEqual(organigramaJerarquicoData.GetListOrganigramaJerarquicoByID(organigrama_Jerarquico.IdOrganigrama).NombreOrganizacion, organigrama_Jerarquico.NombreOrganizacion);




        }

        [Test]
        public void IdOrganigramaValidation()
        {
            try
            {
                Organigrama_Jerarquico organigrama_Jerarquico = new Organigrama_Jerarquico(0, "Asamblea de Socios");

                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("El numero debe ser positivo", e.Message);
            }

        }


        [Test]
        public void InsertVariosOrganigramas()
        {

            Organigrama_Jerarquico organigrama_Jerarquico = new Organigrama_Jerarquico(1, "Asamblea de Socios");
            Organigrama_Jerarquico organigrama_Jerarquico2 = new Organigrama_Jerarquico(2, "Asamblea de Socios");
            Organigrama_Jerarquico organigrama_Jerarquico3 = new Organigrama_Jerarquico(3, "Asamblea de Socios");


            OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();
            organigramaJerarquicoData.InsertOrganigramaJerarquico(organigrama_Jerarquico);
            organigramaJerarquicoData.InsertOrganigramaJerarquico(organigrama_Jerarquico2);
            organigramaJerarquicoData.InsertOrganigramaJerarquico(organigrama_Jerarquico3);


            Assert.AreEqual(organigramaJerarquicoData.GetListOrganigramaJerarquicoByID(organigrama_Jerarquico.IdOrganigrama).IdOrganigrama, organigrama_Jerarquico.IdOrganigrama);
            Assert.AreEqual(organigramaJerarquicoData.GetListOrganigramaJerarquicoByID(organigrama_Jerarquico2.IdOrganigrama).IdOrganigrama, organigrama_Jerarquico2.IdOrganigrama);
            Assert.AreEqual(organigramaJerarquicoData.GetListOrganigramaJerarquicoByID(organigrama_Jerarquico3.IdOrganigrama).IdOrganigrama, organigrama_Jerarquico3.IdOrganigrama);

           
        }

    }
}