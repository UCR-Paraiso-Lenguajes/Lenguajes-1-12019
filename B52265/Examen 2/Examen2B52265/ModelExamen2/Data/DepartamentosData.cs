using System;
using System.Collections.Generic;
using System.Text;
using ModelExamen2.Domain;

namespace ModelExamen2.Data
{
    public class DepartamentosData
    {
        public List<Departamentos> departamentos = new List<Departamentos>();
        public DepartamentosData()
        {
            this.EstadoInicial();
        }
        public List<Departamentos> GetDepartamentos() {
            return this.departamentos;
        }
        public Departamentos GetDepartamentosPorId(int id)
        {
            Departamentos newDepa = null;
            foreach (Departamentos depart in this.departamentos)
            {
                if (depart.ID == id)
                {
                    newDepa = depart;
                }
                else {
                    throw new Exception("No se encontro el departamento");
                }
            }
            return newDepa;
        }
        public void InsertarDepartamento(Departamentos departamentos, int idJefatura)
        {
            Departamentos depart = GetDepartamentosPorId(idJefatura);
            departamentos.Jefatura = depart;
            this.departamentos.Add(departamentos);
        }
        public void ActualizarDepartamento(Departamentos departamentos, int id) {
            Departamentos borrarDepa = GetDepartamentosPorId(id);
            this.departamentos.Remove(borrarDepa);
            this.departamentos.Add(departamentos);
          }
        public void BorrarDepartamentos(int id)
        {
            Departamentos borrarDepa = GetDepartamentosPorId(id);
            this.departamentos.Remove(borrarDepa);
        }
        public void MetodoDeJerarquia(int idDepartamento)
        {
                foreach (Departamentos depa in this.departamentos)
                {
                depa.Marcado = false;
                Departamento aux = depa.Jefatura;
                    if (depa.ID == idDepartamento)
                    {
                    depa.Marcado = true;
                        while (aux.Jefatura != null)
                        {
                            aux.Marcado = true;
                            aux = aux.Jefatura;
                       

                        }
                        if (aux.Jefatura == null)
                        {
                            aux.Marcado = true;
                        }
                    }
                }
        }
        public void EstadoInicial()
        {
            Departamentos departamento1 = new Departamentos("Asamblea de Socios", null);
            Departamentos departamento2 = new Departamentos("Gerente General", departamento1);
            Departamentos departamento3 = new Departamentos("Departamento Administrativo", departamento2);
            Departamentos departamento4 = new Departamentos("Contabilidad", departamento3);
            Departamentos departamento5 = new Departamentos("Cartera", departamento3);
            Departamentos departamento6 = new Departamentos("Tesoreria", departamento3);
            Departamentos departamento7 = new Departamentos("Recursos Humanos", departamento3);
            Departamentos departamento8 = new Departamentos("Departamento Comercial", departamento2);
            Departamentos departamento9 = new Departamentos("Comprars Nacionales", departamento8);
            Departamentos departamento10 = new Departamentos("Importaciones", departamento8);
            Departamentos departamento11 = new Departamentos("Ventas", departamento8);
            Departamentos departamento12 = new Departamentos("Sede Principal", departamento11);
            Departamentos departamento13 = new Departamentos("Sucursales", departamento11);
            Departamentos departamento14 = new Departamentos("Web Site", departamento11);
            Departamentos departamento15 = new Departamentos("Departamento de Operaciones", departamento2);
            Departamentos departamento16 = new Departamentos("Bodegaje", departamento15);
            Departamentos departamento17 = new Departamentos("Reempaque", departamento15);
            Departamentos departamento18 = new Departamentos("Despachos", departamento15);
            this.departamentos.Add(departamento1);
            this.departamentos.Add(departamento2);
            this.departamentos.Add(departamento3);
            this.departamentos.Add(departamento4);
            this.departamentos.Add(departamento5);
            this.departamentos.Add(departamento6);
            this.departamentos.Add(departamento7);
            this.departamentos.Add(departamento8);
            this.departamentos.Add(departamento9);
            this.departamentos.Add(departamento10);
            this.departamentos.Add(departamento11);
            this.departamentos.Add(departamento12);
            this.departamentos.Add(departamento13);
            this.departamentos.Add(departamento14);
            this.departamentos.Add(departamento15);
            this.departamentos.Add(departamento16);
            this.departamentos.Add(departamento17);
            this.departamentos.Add(departamento18);
        }
    }
}
