using System;
using System.Collections.Generic;
using System.Text;

namespace Examen2.Model.Domain
{
    public class Departamento
    {
        private static int idAutoIncremental = 0;
        public int IdDepartamento { get; internal set; }
        public string NombreDepartamento { get; internal set; }
        public bool Marcado { get; set; }
        public Departamento Jefatuta { get; internal set; }

        public Departamento(string nombreDepartamento, Departamento jefatuta)
        {
            IdDepartamento = idAutoIncremental++;
            Marcado = false;
            NombreDepartamento = nombreDepartamento;
            Jefatuta = jefatuta;
        }

        public Departamento(string nombre, bool marcado, int id)
        {
            NombreDepartamento = nombre;
            Marcado = marcado;
            IdDepartamento = id;
        }
    }
}
