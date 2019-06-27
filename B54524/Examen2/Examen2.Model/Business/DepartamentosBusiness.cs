using Examen2.Model.Data;
using Examen2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2.Model.Business
{
    public class DepartamentosBusiness
    {
        public static List<Departamento> departamentos = new List<Departamento>();

        public IEnumerable<Departamento> CargarEstadoInicial()
        {
            //DepartamentosData departamentoData = new DepartamentosData();
            Departamento departamentoAS = new Departamento("Assamblea de Socios", new Departamento("NULL", null));
            Departamento departamentoGG = new Departamento("Gerente General", departamentoAS);
            Departamento departamentoDA = new Departamento("Departamento Administrativo", departamentoGG);
            Departamento departamentoDC = new Departamento("Departamento Comercial", departamentoGG);
            Departamento departamentoDO = new Departamento("Departamento Operaciones", departamentoGG);
            Departamento departamentoCNT = new Departamento("Contabilidad", departamentoDA);
            Departamento departamentoCR = new Departamento("Cartera", departamentoDA);
            Departamento departamentoTS = new Departamento("Tesoreria", departamentoDA);
            Departamento departamentoRU = new Departamento("Recursos Humanos", departamentoDA);
            Departamento departamentoCN = new Departamento("Compras Nacionales", departamentoDC);
            Departamento departamentoIM = new Departamento("Importaciones", departamentoDC);
            Departamento departamentoVN = new Departamento("Ventas", departamentoDC);
            Departamento departamentoBD = new Departamento("Bodegaje", departamentoDO);
            Departamento departamentoRM = new Departamento("Reempaque", departamentoDO);
            Departamento departamentoDS = new Departamento("Despachos", departamentoDO);
            Departamento departamentoSP = new Departamento("Sede Principal", departamentoVN);
            Departamento departamentoSC = new Departamento("Sucursales", departamentoVN);
            Departamento departamentoWS = new Departamento("Web Site", departamentoVN);
            departamentos.Add(departamentoAS);
            departamentos.Add(departamentoGG);
            departamentos.Add(departamentoDA);
            departamentos.Add(departamentoDC);
            departamentos.Add(departamentoDO);
            departamentos.Add(departamentoCNT);
            departamentos.Add(departamentoCR);
            departamentos.Add(departamentoTS);
            departamentos.Add(departamentoRU);
            departamentos.Add(departamentoCN);
            departamentos.Add(departamentoIM);
            departamentos.Add(departamentoVN);
            departamentos.Add(departamentoBD);
            departamentos.Add(departamentoRM);
            departamentos.Add(departamentoDS);
            departamentos.Add(departamentoSP);
            departamentos.Add(departamentoSC);
            departamentos.Add(departamentoWS);
            //departamentoData.CargarEstado(departamentos);
            return departamentos;
        }

        public List<Departamento> Listar()
        {

            return departamentos;
        }

        public void Agregar(Departamento departamento)
        {

        }

        public void Actualizar (Departamento departamento)
        {
            foreach(Departamento dep in departamentos)
            {
                if(dep.IdDepartamento == departamento.IdDepartamento)
                {
                    dep.Marcado = true;
                }
            }
        }

        public void Eliminar(int id)
        {

        }
    }
}
