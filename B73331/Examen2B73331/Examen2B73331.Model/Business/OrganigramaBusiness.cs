using Examen2B73331.Model.Data;
using Examen2B73331.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2B73331.Model.Business
{
    public class OrganigramaBusiness
    {
        public OrganigramaBusiness() { }
        public Organigrama traeOrganigrama()
        {
            OrganigramaData data = new OrganigramaData();
            return data.getAll()[0];
        }
    }
}
