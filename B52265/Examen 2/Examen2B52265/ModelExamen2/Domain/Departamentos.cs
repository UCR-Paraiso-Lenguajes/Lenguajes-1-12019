using System;
using System.Collections.Generic;
using System.Text;

namespace ModelExamen2.Domain
{
    public class Departamentos : Departamento
    {
        public Departamentos(string nombre, Departamento jefatura)
        {

            ID = GetNextID();
            Nombre = nombre;
            Marcado = false;
            Jefatura = jefatura;
        }
    }
}
