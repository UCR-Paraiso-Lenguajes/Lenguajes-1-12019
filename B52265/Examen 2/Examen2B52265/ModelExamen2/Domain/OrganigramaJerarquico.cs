using System;
using System.Collections.Generic;
using System.Text;

namespace ModelExamen2.Domain
{
    public class OrganigramaJerarquico : Organigrama
    {

        public OrganigramaJerarquico(string organizacion)
        {
            ID = GetNextID();
            Organizacion = organizacion;
        }

    }
}
