using model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace model.Data
{
    public class DepartamentosData
    {
        public List<Departamentos> departamentos = new List<Departamentos>();

        public DepartamentosData()
        {
            this.departamentos = LlenarDepartamentos();
        }

        public IEnumerable<Departamentos> GetListDepartamentos()
        {


            return departamentos;

        }

        public Departamentos GetDepartamentosByID(int id)
        {
            Departamentos newDepartamento = null;
            bool encontrado = false;

            foreach (Departamentos depart in departamentos)
            {


                if (depart.IdDepartamento == id && encontrado == false)
                {
                    newDepartamento = depart;
                    encontrado = true;
                }


            }

            if (newDepartamento != null)
            {
                return newDepartamento;
            }
            else
            {
                throw new Exception("Departamento no encontrado");
            }



        }

        public void InsertDepartamentos(Departamentos departamentos, int idJefatura)
        {
            if (idJefatura > 0)
            {
                Departamentos buscarDepartamento = GetDepartamentosByID(idJefatura);
                departamentos.Jefatura = buscarDepartamento;
            }

            this.departamentos.Add(departamentos);
        }


        public void EditDepartamento(Departamentos departamentos, int id)
        {
            Departamentos borrarDepa = GetDepartamentosByID(id);
            this.departamentos.Remove(borrarDepa);
            this.departamentos.Add(departamentos);
        }

        public void DeleteDepartamento(int id)
        {
            Departamentos borrarDepa = GetDepartamentosByID(id);
            if (borrarDepa != null)
            {
                this.departamentos.Remove(borrarDepa);
            }
        }



        public List<Departamentos> LlenarDepartamentos()
        {

            List<Departamentos> departamentos = new List<Departamentos>();

            Departamentos departamento1 = new Departamentos(1, "Asamblea de Socios", null);
            Departamentos departamento2 = new Departamentos(2, "Gerente General", departamento1);
            Departamentos departamento3 = new Departamentos(3, "Departamento Administrativo", departamento2);
            Departamentos departamento4 = new Departamentos(4, "Contabilidad", departamento3);
            Departamentos departamento5 = new Departamentos(5, "Cartera", departamento3);
            Departamentos departamento6 = new Departamentos(6, "Tesoreria", departamento3);
            Departamentos departamento7 = new Departamentos(7, "Recursos Humanos", departamento3);
            Departamentos departamento8 = new Departamentos(8, "Departamento Comercial", departamento2);
            Departamentos departamento9 = new Departamentos(9, "Comprars Nacionales", departamento8);
            Departamentos departamento10 = new Departamentos(10, "Importaciones", departamento8);
            Departamentos departamento11 = new Departamentos(11, "Ventas", departamento8);
            Departamentos departamento12 = new Departamentos(12, "Sede Principal", departamento11);
            Departamentos departamento13 = new Departamentos(13, "Sucursales", departamento11);
            Departamentos departamento14 = new Departamentos(14, "Web Site", departamento11);
            Departamentos departamento15 = new Departamentos(15, "Departamento de Operaciones", departamento2);
            Departamentos departamento16 = new Departamentos(16, "Bodegaje", departamento15);
            Departamentos departamento17 = new Departamentos(17, "Reempaque", departamento15);
            Departamentos departamento18 = new Departamentos(18, "Despachos", departamento15);
            departamentos.Add(departamento1);
            departamentos.Add(departamento2);
            departamentos.Add(departamento3);
            departamentos.Add(departamento4);
            departamentos.Add(departamento5);
            departamentos.Add(departamento6);
            departamentos.Add(departamento7);
            departamentos.Add(departamento8);
            departamentos.Add(departamento9);
            departamentos.Add(departamento10);
            departamentos.Add(departamento11);
            departamentos.Add(departamento12);
            departamentos.Add(departamento13);
            departamentos.Add(departamento14);
            departamentos.Add(departamento15);
            departamentos.Add(departamento16);
            departamentos.Add(departamento17);
            departamentos.Add(departamento18);


            return departamentos;
        }


        public void JerarquiasDeDepartamento(int idDepartamento, IEnumerable<Departamentos> departamentos)
        {
            foreach (Departamentos departamentoActual in departamentos)
            {
                departamentoActual.Marcado = false;
                Departamento departamentoAuxiliar = departamentoActual.Jefatura;
                if (departamentoActual.IdDepartamento == idDepartamento)
                {
                    departamentoActual.Marcado = true;
                    while (departamentoAuxiliar.Jefatura != null)
                    {
                        departamentoAuxiliar.Marcado = true;
                        departamentoAuxiliar = departamentoAuxiliar.Jefatura;


                    }
                    if (departamentoAuxiliar.Jefatura == null)
                    {
                        departamentoAuxiliar.Marcado = true;
                    }
                }
            }
        }

    }
            }
        
    




