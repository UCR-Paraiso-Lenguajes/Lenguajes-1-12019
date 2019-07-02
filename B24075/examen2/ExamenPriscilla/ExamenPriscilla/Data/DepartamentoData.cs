using ExamenPriscilla.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ExamenPriscilla.Data
{
    public class DepartamentoData
    {
        public List<Departamento> departamentos;

        public DepartamentoData(List<Departamento> departamentos)
        {
            this.departamentos = departamentos;
        }

        public DepartamentoData()
        {
            this.departamentos = new List<Departamento>();
            Departamento d1 = new Departamento("asamblea socios", "1", false);
            Departamento d2 = new Departamento(d1, "gerente general", "2", false);
            Departamento d3 = new Departamento(d2, "dpto administrativo", "3", false);
            Departamento d4 = new Departamento(d2, "dpto comercial", "4", false);
            Departamento d5 = new Departamento(d2, "dpto de operaciones", "5", false);
            
            this.departamentos.Add(d1);
            this.departamentos.Add(d2);
            this.departamentos.Add(d3);
            this.departamentos.Add(d4);
            this.departamentos.Add(d5);
      
        }

        public Departamento agregarDepartamento(Departamento departamento)
        {
            departamentos.Add(departamento);
            return departamento;
        }

        public List<DevuelveDepartamento> obtenerDepartamentos()
        {
            return paraDevolverDepartamentos();
        }

        public List<DevuelveDepartamento> paraDevolverDepartamentos()
        {
            List<DevuelveDepartamento> devolverDepartamentos = new List<DevuelveDepartamento>();
            DevuelveDepartamento departamento;

            foreach (var depto in departamentos) {
                if (depto.jefatura == null)
                {
                    departamento =  new DevuelveDepartamento();
                    departamento.id = depto.id;
                    departamento.marcado = depto.marcado;
                    departamento.jefatura ="-";
                    departamento.nombre = depto.nombre;

                }
                else
                {
                    departamento = new DevuelveDepartamento();
                    departamento.id = depto.id;
                    departamento.marcado = depto.marcado;
                    departamento.jefatura = depto.jefatura.nombre;
                    departamento.nombre = depto.nombre;
                }

                devolverDepartamentos.Add(departamento);
            }
            return devolverDepartamentos;

        }

        public Departamento obtenerDepartamento(String id)
        {
            foreach (var depto in departamentos)
               if(depto.id.Equals(id))
                    return depto;
            return null;


        }

        public Departamento actualizarDepartamento(String id, Departamento departamento) 
        {
            List<Departamento> departamentosAct = departamentos;

            foreach (var depto in departamentosAct) {
                if (depto.id.Equals(id))
                {

                    depto.id = id;
                    depto.nombre = departamento.nombre;
                    depto.marcado = departamento.marcado;
                    depto.jefatura = departamento.jefatura;
                }
            }

            return departamento;

        }

        public Departamento actualizarMarcar(String id, Departamento departamento)
        {
            List<Departamento> departamentosAct = departamentos;

            foreach (var depto in departamentosAct)
            {
                if (depto.id.Equals(id))
                {
                    marcar(depto);
                  
                }
            }

            return departamento;

        }

        public void marcar(Departamento departamento)
        {
            departamento.marcado = true;
            if (departamento.jefatura == null)
            {
                return;
            }

            marcar(departamento.jefatura);
        }



        public void eliminarDepartamento(String id)
        {
            List<Departamento> departamentosAct = departamentos;

            foreach (var depto in departamentosAct)
                if (depto.id.Equals(id))
                    departamentosAct.Remove(item: depto);
    

            departamentos = departamentosAct;


          


        }
    }
}
