using System;
using System.Collections.Generic;
using System.Text;

namespace model.Domain
{
    public class Departamento
    {
        


        public Departamento()
        {
          

        }


        public Departamento(int idDepartamento, string nombre, Departamento jefatura)
        {
            IdDepartamento = idDepartamento;
            Nombre = nombre;
            Marcado = false;
            Jefatura = jefatura;
            
        }


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
                if (string.IsNullOrEmpty(value)) throw new Exception("Nombre es requerido.");
                if (string.IsNullOrWhiteSpace(value)) throw new Exception("No puede ingresar solo espacios");
                if (Jefatura != null) {
                    if (value.Equals(Jefatura.nombre)) throw new Exception("Nombre de departamento ya existe, no puede llamarse igual a su jefatura");
                } 
                nombre = value;
            }
        }

        private int idDepartamento;
        public int IdDepartamento
        {
            get
            {
                return idDepartamento;
            }
            set
            {
              if (value <= 0) throw new Exception("El numero debe ser positivo");
                idDepartamento = value;
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

    }
}
