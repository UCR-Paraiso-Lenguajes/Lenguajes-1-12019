using System;
using System.Collections.Generic;
using System.Text;

namespace ModelExamen2.Domain
{
    public class Departamento
    {
       private static int IdCurrent;
        private Departamento jefatura;
        public Departamento Jefatura
        {
            get
            {
                return jefatura;
            }
            set
            {
                jefatura = value;
            }
        }
        private string nombre;
        public string Nombre
        {
            get
            {
                return nombre;
            }
            set
            {
                nombre = value;
            }
        }
        private int id;
        public int ID
        {
            get
            {
                return id;
            }
            set
            {
                id = value;
            }
        }
        private bool marcado;
        public bool Marcado
        {
            get
            {
                return marcado;
            }
            set
            {
                marcado = value;
            }
        }
        public Departamento()
        {
        }
        public Departamento(string nombre, Departamento jefatura)
        {
           if (string.IsNullOrWhiteSpace(nombre)) throw new Exception("No puede ingresar solo espacios");
           if (string.IsNullOrEmpty(nombre)) throw new Exception("Nombre es requerido.");
           if (nombre.Equals(jefatura.Nombre)) throw new Exception("Nombre de departamento ya existe, no puede llamarse igual a su jefatura");
            ID = GetNextID();
            Nombre = nombre;
            Marcado = false;
            Jefatura = jefatura;
        }

        static Departamento()
        {
            IdCurrent = 0;
        }
        protected int GetNextID()
        {
            return ++IdCurrent;
        }


    }
}
