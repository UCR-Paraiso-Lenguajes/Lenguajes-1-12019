using System;
using System.Collections.Generic;
using System.Text;

namespace model.Domain
{
    public  class Departamentos : Departamento
    {
        public Departamentos(int idDepartamento, string nombre, Departamento jefatura)
        {
            IdDepartamento = idDepartamento;
            Nombre = nombre;
            Marcado = false;
            Jefatura = jefatura;
        }
        public Departamentos(int idDepartamento, string nombre)
        {
            IdDepartamento = idDepartamento;
            Nombre = nombre;
            Marcado = false;
           
        }
    }
}
