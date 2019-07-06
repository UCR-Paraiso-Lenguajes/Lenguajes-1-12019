using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2_Clases.Domain
{
    public class DepartamentoRaiz : Departamento
    {
        public DepartamentoRaiz(string id, string nombre, OrganigramaJerarquico organigramaJerarquico) : base(id, nombre, organigramaJerarquico)
        {
            if (id == null && nombre == null && organigramaJerarquico == null) throw new Exception("Departamento vacio");
        }
    }
}
