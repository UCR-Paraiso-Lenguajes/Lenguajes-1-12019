using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2_Clases.Domain

{
    public class OrganigramaJerarquico : Organigrama
    {
        public OrganigramaJerarquico(string id, string nombre) : base(id, nombre)
        {
            if (id == null && nombre == null) throw new Exception("organigrama vacio");
        }
    }
}
