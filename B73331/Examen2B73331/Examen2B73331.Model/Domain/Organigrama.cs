using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2B73331.Model.Domain
{
    public class Organigrama
    {
        private int organigramaId;
        public int OrganigramaId
        {
            get { return organigramaId; }
            set
            {
                if (value<=0) throw new Exception("El id debe ser mayor a cero");
                organigramaId = value;
            }
        }
        private DepartamentoRaiz departamentoRaiz;
        public DepartamentoRaiz DepartamentoRaiz
        {
            get { return departamentoRaiz; }
            set
            {
                departamentoRaiz = value ?? throw new Exception("El departamento raiz no puede ser nulo");
            }
        }
        private List<Departamento> departamentos = new List<Departamento>();
        public List<Departamento> Departamentos
        {
            get { return departamentos; }
            set
            {
                departamentos = value ?? throw new Exception("La lista de departamentos no puede ser nula");
            }
        }
        public DepartamentoAbstracta getDepartamentoLista(int idDepartamento)
        {
            if (DepartamentoRaiz.Id == idDepartamento)
            {
                return DepartamentoRaiz;
            }
            foreach (Departamento departamento in Departamentos)
            {
                if (departamento.Id == idDepartamento) return departamento;
                
            }
            return new Departamento();
        }
        public DepartamentoAbstracta getDepartamentoListaString(string nombreDep)
        {
            if (DepartamentoRaiz.Nombre.Equals(nombreDep))
            {
                return DepartamentoRaiz;
            }
            foreach (Departamento departamento in Departamentos)
            {
                if (departamento.Nombre == nombreDep) return departamento;

            }
            return new Departamento();
        }
        public bool setDepartamentoLista(int nid, string nnombre, bool nmarcado,string nombrePadre)
        {
            if (nid <= 0) throw new Exception("El id debe ser mayor a cero");
            if (nnombre.Equals(nombrePadre)) throw new Exception("El nombre del padre debe ser diferente al nombre del nuevo hijo");
            if (string.IsNullOrEmpty(nnombre) || string.IsNullOrWhiteSpace(nnombre)) throw new Exception("El nombre debe ser distinto de vacio o nulo");
            if (string.IsNullOrEmpty(nombrePadre) || string.IsNullOrWhiteSpace(nombrePadre)) throw new Exception("El nombre del padre debe ser distinto de vacio o nulo");


            if (DepartamentoRaiz.Nombre.Equals(nombrePadre))
            {

                departamentos.Add(new Departamento(nid,nnombre,nmarcado,DepartamentoRaiz));
                return true;
            }
            foreach (Departamento departamento in Departamentos)
            {
                if (departamento.Nombre.Equals(nombrePadre)) {
                    departamentos.Add(new Departamento(nid, nnombre, nmarcado, departamento));
                    return true;
                }
                
            }
            return false;
        }
        public bool existeDep(string nombreDepartamento)
        {
            if (DepartamentoRaiz.Nombre.Equals(nombreDepartamento))
            {
                return true;
            }
            foreach (Departamento departamento in Departamentos)
            {
                if (departamento.Nombre.Equals(nombreDepartamento))
                {
                    return true;
                }

            }
            return false;
        }
        public bool eliminarDep(string nombreDepartamento)
        {
            if (DepartamentoRaiz.Nombre.Equals(nombreDepartamento))
            {
                DepartamentoRaiz = null;
                Departamentos = null;
                return true;
            }
            List<DepartamentoAbstracta> depsFamilia = new List<DepartamentoAbstracta>();
            depsFamilia = traeRama(nombreDepartamento, depsFamilia);
            if (depsFamilia.Count == 0)return false;
            foreach (Departamento departamento in depsFamilia)
            {
                Departamentos.Remove(departamento);
            }
            Departamentos.Remove((Departamento)getDepartamentoListaString(nombreDepartamento));
            return true;
        }
        public List<DepartamentoAbstracta> traeRama(string nombreNodo,List<DepartamentoAbstracta> listaNodos)
        {
            foreach (Departamento departamento in Departamentos)
            {
                if (departamento.Jefatura.Nombre.Equals(nombreNodo))
                {
                    listaNodos.Add(departamento);
                    traeRama(departamento.Nombre, listaNodos);
                }
            }
            return listaNodos;
        }
        public List<Departamento> traeHijos(string nombreNodo)
        {
            List<Departamento> hijos = new List<Departamento>();
            foreach (Departamento departamento in Departamentos)
            {
                if (departamento.Jefatura.Nombre.Equals(nombreNodo))
                {
                    hijos.Add(departamento);
                }

            }
            return hijos;
        }
        public bool actualizaDepartamento(int nid, string nnombre, bool nmarcado, string nombreAntiguo)
        {
            if (!existeDep(nombreAntiguo))
            {
                return false;
            }
            
            List<Departamento> hijos = traeHijos(nombreAntiguo);
            if (DepartamentoRaiz.Nombre.Equals(nombreAntiguo))
            {
                DepartamentoRaiz = new DepartamentoRaiz(nid, nnombre, nmarcado);
                actualizaHijos(hijos, DepartamentoRaiz);
            }
            else
            {
                Departamento dep = (Departamento)getDepartamentoListaString(nombreAntiguo);

                Departamentos.Remove(dep);
                dep.Id = nid;
                dep.Nombre = nnombre;
                dep.Marcado = nmarcado;
                Departamentos.Add(dep);
                actualizaHijos(hijos, dep);
            }
            return true;
        }
        private void actualizaHijos(List<Departamento> hijos, DepartamentoAbstracta jefaturaActualizada)
        {
            foreach (Departamento departamento in hijos)
            {
                Departamentos.Remove(departamento);
                departamento.Jefatura = jefaturaActualizada;
                Departamentos.Add(departamento);
            }
        }
        public List<DepartamentoAbstracta> mostrar()
        {
            List<DepartamentoAbstracta> listaDeps = new List<DepartamentoAbstracta>();
            listaDeps.Add(DepartamentoRaiz);
            traeRama(DepartamentoRaiz.Nombre, listaDeps);
            /*
            List<Departamento> listaDeps2 = new List<Departamento>();
            foreach (Departamento dep in listaDeps)
            {
                listaDeps2.Add(dep);
            }*/
            return listaDeps;
        }
        public List<Departamento> mostrarSinRaiz()
        {
            List<DepartamentoAbstracta> listaDeps = new List<DepartamentoAbstracta>();
            //listaDeps.Add(DepartamentoRaiz);
            traeRama(DepartamentoRaiz.Nombre, listaDeps);
            
            List<Departamento> listaDeps2 = new List<Departamento>();
            foreach (Departamento dep in listaDeps)
            {
                listaDeps2.Add(dep);
            }
            return listaDeps2;
        }
        public bool marcar(string nombreNodoMarcar)
        {
            if (!existeDep(nombreNodoMarcar))
            {
                return false;
            }
            
            if (nombreNodoMarcar.Equals(DepartamentoRaiz.Nombre))
            {
                DepartamentoRaiz.Marcado = true;
                return true;
            }
            else
            {
                List<DepartamentoAbstracta> ramaConHermanos = new List<DepartamentoAbstracta>();
                traeRamaCiertoPuntoSinRaiz(nombreNodoMarcar, ramaConHermanos);
                Departamento depNodo = (Departamento)getDepartamentoListaString(nombreNodoMarcar);
                List<Departamento> hermanos = traeHijos(depNodo.Jefatura.Nombre);
                foreach (Departamento departamento in hermanos)
                {
                    if (!departamento.Nombre.Equals(nombreNodoMarcar))
                    {
                        ramaConHermanos.Remove(departamento);
                    }
                }
                foreach (DepartamentoAbstracta dep in ramaConHermanos)
                {
                    actualizaDepartamento(dep.Id, dep.Nombre,true, dep.Nombre);
                }
                return true;
            }
            
            

        }
        public List<DepartamentoAbstracta> traeRamaCiertoPuntoSinRaiz(string nombreNodo, List<DepartamentoAbstracta> listaNodos)
        {

            
            if (nombreNodo.Equals(DepartamentoRaiz.Nombre))
            {
                listaNodos.Add(DepartamentoRaiz);
                
            }
            else
            {
                Departamento dep = (Departamento)getDepartamentoListaString(nombreNodo);
                List<Departamento> hijos = traeHijos(dep.Jefatura.Nombre);
                foreach (Departamento departamentoHijo in hijos)
                {
                    listaNodos.Add(departamentoHijo);
                }
                traeRamaCiertoPuntoSinRaiz(dep.Jefatura.Nombre, listaNodos);
            }
            return listaNodos;
        }
        public Organigrama(DepartamentoRaiz departamentoRaiz, int idOrg)
        {
            DepartamentoRaiz = departamentoRaiz;
            OrganigramaId = idOrg;
        }

        private Organigrama()
        {
        }
    }
}
