using NUnit.Framework;
using ModelExamen2.Domain;
using ModelExamen2.Data;
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

            Departamentos departamento1 = new Departamentos("Asamblea de Socios", null);

            Assert.AreEqual(1, departamento1.ID);
            Assert.AreEqual("Asamblea de Socios", departamento1.Nombre);
        }
        [Test]
        public void VariosDepartamentosTest()
        {
            Departamentos departamento1 = new Departamentos("Asamblea de Socios", null);
            Departamentos departamento2 = new Departamentos("Gerente General", departamento1);

            Assert.AreEqual(1, departamento1.ID);
            Assert.AreEqual("Asamblea de Socios", departamento1.Nombre);
            Assert.AreEqual(2, departamento2.ID);
            Assert.AreEqual("Gerente General", departamento2.Nombre);

        }
        [Test]
        public void NombreNullValidation()
        {
            try
            {
                Departamentos departamento1 = new Departamentos(null, null);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("El nombre es obligatorio", e.Message);
            }

        }
        [Test]
        public void NombreEspaciosValidation()
        {
            try
            {
                Departamentos departamento1 = new Departamentos("  ", null);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("No acepta espacios", e.Message);
            }

        }
        [Test]
        public void InsertDepartamento()
        {
            Departamentos departamento1 = new Departamentos("AsambleaSocios", null); ;


            DepartamentosData d1 = new DepartamentosData();
            d1.InsertarDepartamento(departamento1, 0);

            Assert.AreEqual(departamento1.ID, d1.GetDepartamentosPorId(departamento1.ID).ID);

        }
        [Test]
        public void ValidacionDeMismoNombre()
        {

            Departamentos departamento1 = new Departamentos("AsambleaSocios", null);
            Departamentos departamento2 = new Departamentos("Gerente General", departamento1);
            Departamentos departamento3 = new Departamentos("Gerente General", departamento1);

            DepartamentosData d1 = new DepartamentosData();
            d1.InsertarDepartamento(departamento1, 0);
            d1.InsertarDepartamento(departamento2, departamento1.ID);
            d1.InsertarDepartamento(departamento3, departamento1.ID);


            Assert.AreEqual(departamento1.ID, d1.GetDepartamentosPorId(departamento1.ID).ID);
            Assert.AreEqual(departamento2.ID, d1.GetDepartamentosPorId(departamento2.ID).ID);
            Assert.AreEqual(departamento3.ID, d1.GetDepartamentosPorId(departamento3.ID).ID);

        }
        [Test]
        public void BorrarDepartamento()
        {
            try
            {
                DepartamentosData d1 = new DepartamentosData();
          
                d1.BorrarDepartamentos(1);
                d1.GetDepartamentosPorId(1);
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

            Departamentos departamento1 = new Departamentos("AsambleaSocios", null);
            DepartamentosData d1 = new DepartamentosData();
            d1.InsertarDepartamento(departamento1, 0);
            departamento1.Nombre = "Jefes";
            d1.ActualizarDepartamento(departamento1, departamento1.ID);
            Assert.AreEqual(d1.GetDepartamentosPorId(departamento1.ID).Nombre, departamento1.Nombre);
        }

        [Test]
        public void NuevoOrganigramaTest()
        {

            OrganigramaJerarquico organigramaJerarquico = new OrganigramaJerarquico("Asamblea de Socios");
            OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();

            organigramaJerarquicoData.InsertarOrganigrama(organigramaJerarquico);

            Assert.AreEqual(organigramaJerarquicoData.GetOrganigramaPorId(organigramaJerarquico.ID).ID, organigramaJerarquico.ID);
            Assert.AreEqual(organigramaJerarquicoData.GetOrganigramaPorId(organigramaJerarquico.ID).Organizacion, organigramaJerarquico.Organizacion);
        }
        [Test]
        public void NombreEspaciosOrganigramaValidation()
        {
            try
            {
                OrganigramaJerarquico organigramaJerarquico = new OrganigramaJerarquico("  ");
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("No se aceptan espacios en blanco", e.Message);
            }

        }
        [Test]
        public void NombreNullOrganigramaValidation()
        {
            try
            {
                OrganigramaJerarquico organigrama_Jerarquico = new OrganigramaJerarquico(null);
                Assert.Fail("Exception was expected.");
            }
            catch (Exception e)
            {
                Assert.AreEqual("No se aceptan nulos", e.Message);
            }
        }
        [Test]
        public void BorrarOrganigrama()
        {

            try
            {

                OrganigramaJerarquico organigramaJerarquico = new OrganigramaJerarquico("Asamblea de Socios");
                OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();

                organigramaJerarquicoData.InsertarOrganigrama(organigramaJerarquico);

                organigramaJerarquicoData.BorrarOrganigrama(organigramaJerarquico.ID);
                organigramaJerarquicoData.GetOrganigramaPorId(organigramaJerarquico.ID);
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

            OrganigramaJerarquico organigramaJerarquico = new OrganigramaJerarquico("Asamblea de Socios");
            OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();

            organigramaJerarquicoData.InsertarOrganigrama(organigramaJerarquico);

            organigramaJerarquico.Organizacion = "CEO";

            organigramaJerarquicoData.ActualizarOrganigrama(organigramaJerarquico, organigramaJerarquico.ID);
       
            Assert.AreEqual(organigramaJerarquicoData.GetOrganigramaPorId(organigramaJerarquico.ID).Organizacion, organigramaJerarquico.Organizacion);
        }
        [Test]
        public void InsertVariosOrganigramas()
        {
            OrganigramaJerarquico organigramaJerarquico = new OrganigramaJerarquico("Asamblea de Socios");
            OrganigramaJerarquico organigramaJerarquico2 = new OrganigramaJerarquico("Asamblea de Socios");
            OrganigramaJerarquico organigramaJerarquico3 = new OrganigramaJerarquico("Asamblea de Socios");


            OrganigramaJerarquicoData organigramaJerarquicoData = new OrganigramaJerarquicoData();
            organigramaJerarquicoData.InsertarOrganigrama(organigramaJerarquico);
            organigramaJerarquicoData.InsertarOrganigrama(organigramaJerarquico2);
            organigramaJerarquicoData.InsertarOrganigrama(organigramaJerarquico3);


            Assert.AreEqual(organigramaJerarquicoData.GetOrganigramaPorId(organigramaJerarquico.ID).ID, organigramaJerarquico.ID);
            Assert.AreEqual(organigramaJerarquicoData.GetOrganigramaPorId(organigramaJerarquico2.ID).ID, organigramaJerarquico2.ID);
            Assert.AreEqual(organigramaJerarquicoData.GetOrganigramaPorId(organigramaJerarquico3.ID).ID, organigramaJerarquico3.ID);
        }
    }
}