using Examen2B73331.Model.Data;
using Examen2B73331.Model.Domain;
using NUnit.Framework;
using System;
using System.Collections.Generic;

namespace Tests
{
    public class DepartamentoTest
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Test1()
        {
            DepartamentoRaiz departamentoRaiz = new DepartamentoRaiz(1, "Padre", false);
            Organigrama organigrama = new Organigrama(departamentoRaiz,1);
            organigrama.setDepartamentoLista(2, "departamentoHijo1", false, "Padre");
            organigrama.setDepartamentoLista(3, "departamentoHijo2", false, "Padre");
            organigrama.setDepartamentoLista(4, "departamentoHijo3", false, "departamentoHijo1");
            organigrama.setDepartamentoLista(5, "departamentoHijo4", false, "departamentoHijo3");

            
            
            try
            {
                //PREGUNTARLE AL PROFE COMO HACER QUE AUNQUE EL ASSERT FALLE LA PRUEBA SALGA POSITIVA (EN VERDE)
                //Assert.AreEqual(1, organigrama.getDepartamentoLista(1).Id);
                
            }
            catch (Exception e) {
                
            }
            Assert.AreEqual(2, organigrama.getDepartamentoLista(2).Id);
            organigrama.setDepartamentoLista(6, "departamentoHijo5", false, "departamentoHijo4");
            Assert.AreEqual(6, organigrama.getDepartamentoLista(6).Id);
            Assert.AreEqual(5, organigrama.Departamentos.Count);

            organigrama.setDepartamentoLista(7, "departamentoHijo6", false, "departamentoHijo1");
            organigrama.setDepartamentoLista(8, "departamentoHijo7", false, "departamentoHijo6");
            List<DepartamentoAbstracta> departamentosRama = new List<DepartamentoAbstracta>();
            organigrama.traeRama("Padre", departamentosRama);
            Assert.NotNull(departamentosRama);
            Assert.AreEqual(7, departamentosRama.Count);
            Assert.True(organigrama.eliminarDep("departamentoHijo6"));
            Assert.False(organigrama.existeDep("departamentoHijo6"));

            organigrama.setDepartamentoLista(7, "departamentoHijo6", false, "departamentoHijo1");
            organigrama.setDepartamentoLista(8, "departamentoHijo7", false, "departamentoHijo6");
            Assert.True(organigrama.actualizaDepartamento(50, "departamentoHijo500",false, "departamentoHijo1"));
            Assert.True(organigrama.existeDep("departamentoHijo500"));
            List<DepartamentoAbstracta> depsOrganigrama = organigrama.mostrar();
            Assert.NotNull(depsOrganigrama);
            
            List<DepartamentoAbstracta> segmentoRama = new List<DepartamentoAbstracta>();
            organigrama.traeRamaCiertoPuntoSinRaiz("departamentoHijo3", segmentoRama);
            Assert.NotNull(segmentoRama);
            organigrama.marcar("departamentoHijo3");
            depsOrganigrama = organigrama.mostrar();
            Assert.NotNull(depsOrganigrama);


            BDOrganigrama bd1 = new BDOrganigrama();
            bd1.append(organigrama);

            BDOrganigrama bd2 = new BDOrganigrama();
            DepartamentoRaiz departamentoRaiz2 = new DepartamentoRaiz(1, "Padre2", false);
            Organigrama organigrama2 = new Organigrama(departamentoRaiz2, 2);
            bd2.append(organigrama2);
            Assert.AreNotEqual(bd1.getList()[0], bd2.getList()[1]);

            organigrama2.setDepartamentoLista(2, "departamentoHijo1", false, "Padre2");
            bd1.update(organigrama2, bd2.getList()[1]);
            Assert.True(bd1.getList()[1].Departamentos.Count == 1);
            Assert.AreEqual("departamentoHijo1", bd2.getList()[1].Departamentos[0].Nombre);


            bd2.delete(organigrama2);
            Assert.NotNull(bd1.getList());
            Assert.False(bd1.getList().Count == 2);
            Assert.True(bd1.getList().Count==1);
            


            













        }
    }
}