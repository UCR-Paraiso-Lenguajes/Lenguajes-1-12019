using System;
using System.Collections.Generic;
using System.Text;

namespace ModelExamen2.Domain
{
    public class Organigrama
    {
        public List<Departamentos> Departamentos
        {
            get { return Departamentos; }
            set { Departamentos = value; }
        }
        private static int IdCurrent;
        private int id;
        public int ID {
            get { return id; }

            set { id = value; }

        }
        private string organizacion;
        public string Organizacion {
            get { return organizacion; }
            set {
                organizacion = value;
            }
        }
        public Organigrama()
        {
        }
        public Organigrama(string organizacion) {
            if (string.IsNullOrWhiteSpace(organizacion)) throw new Exception("No puede ingresar solo espacios");
            if (string.IsNullOrEmpty(organizacion)) throw new Exception("Nombre es requerido.");
            ID = GetNextID();
            Organizacion = organizacion;
        }
        static Organigrama()
        {
            IdCurrent = 0;
        }
        protected int GetNextID()
        {
            return ++IdCurrent;
        }
        public void AgregarDepartamento(Departamentos departamento)
        {
            this.Departamentos.Add(departamento);
        }
    }
}
