using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2_Clases.Domain
{
   public class Departamento
    {
        public Departamento(string id,string nombre,OrganigramaJerarquico organigramaJerarquico) {
            if(id==null&& nombre==null && organigramaJerarquico== null) throw new Exception("Departamento vacio");
            this.Id = id;
            this.Nombre = nombre;
            this.Marcado = false;
            this.OrganigramaJerarquico = organigramaJerarquico;
        }
        public string Id { get; set; }
        public string Nombre { get; set; }
        public Boolean Marcado{ get; set; }
        public OrganigramaJerarquico OrganigramaJerarquico { get; set; }
    }
}
