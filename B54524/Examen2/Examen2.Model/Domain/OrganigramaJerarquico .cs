using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Examen2.Model.Domain
{
    public class OrganigramaJerarquico : Organigrama
    {
        public List<OrganigramaJerarquico> organigramasJerarquicos { get; internal set; }

        public OrganigramaJerarquico(string nombreEmpresa) : base(nombreEmpresa)
        {

        }

        public OrganigramaJerarquico()
        {

        }
    }
}
