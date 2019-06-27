
using Examen2.Model.Domain;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Examen2.Model.Data
{
    public class DepartamentosData
    {
        private Departamentos departamentos;
        private Mock<Departamentos> mockDepartamentos;

        public DepartamentosData()
        {
            departamentos = new Departamentos();
            mockDepartamentos = new Mock<Departamentos>();
        }

        public void agregarDepartamento(Departamento departamento)
        {
            mockDepartamentos.Object.departamentos.Add(departamento);
        }

        public Departamento buscarDepartamentoporId(int id)
        {
            Departamento departamento=null;
            List<Departamento> depatamentos = mockDepartamentos.Object.departamentos;
            int cuentaDeptos = 0;
            foreach (Departamento depto in mockDepartamentos.Object.departamentos)
            {
                if (depatamentos.ElementAt(cuentaDeptos).IdDepartamento==id)
                {
                    departamento = mockDepartamentos.Object.departamentos.ElementAt(cuentaDeptos);
                }
                cuentaDeptos++;
            }
            return departamento;
        }

        public void eliminarDepartamento(Departamento departamento)
        {
            if (departamento == buscarDepartamentoporId(departamento.IdDepartamento))
            {
                mockDepartamentos.Object.departamentos.Remove(departamento);
            }
        }

        public void modificarDepartamento(Departamento departamento)
        {
            int cuentaDeptos = 0;
            foreach (Departamento depto in mockDepartamentos.Object.departamentos)
            {
                if (mockDepartamentos.Object.departamentos.ElementAt(cuentaDeptos)==departamento)
                {
                    mockDepartamentos.Object.departamentos.ElementAt(cuentaDeptos).NombreDepartamento = departamento.NombreDepartamento;
                    mockDepartamentos.Object.departamentos.ElementAt(cuentaDeptos).Marcado = departamento.Marcado;
                }
                cuentaDeptos++;
            }
        }

        public List<Departamento> listar()
        {
            List<Departamento> departamentos = new List<Departamento>();

            foreach (Departamento depto in mockDepartamentos.Object.departamentos)
            {
                departamentos.Add(depto);
            }

            return departamentos;
        }

    }
}
