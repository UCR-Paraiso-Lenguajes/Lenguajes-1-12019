using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2_Clases.Domain
{
    public class Subdepartamento : Departamento
    {
        public Subdepartamento(string id, string nombre, OrganigramaJerarquico organigramaJerarquico,Departamento jefatura) : base(id, nombre, organigramaJerarquico)
        {
            if (id == null && nombre == null && organigramaJerarquico == null && jefatura==null) throw new Exception("Departamento vacio");
            this.Jefatura = jefatura;
        }

        public Departamento Jefatura { get; set; }
    }
}
