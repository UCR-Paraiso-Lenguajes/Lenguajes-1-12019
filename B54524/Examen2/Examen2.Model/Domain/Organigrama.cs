using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2.Model.Domain
{
    public class Organigrama
    {
        public int IdOrganigrama { get; internal set; }
        public string NombreEmpresa { get; internal set; }

        public Organigrama(string nombreOrganigrama)
        {
            NombreEmpresa = nombreOrganigrama;
        }

        public Organigrama()
        {
        }
    }
}
