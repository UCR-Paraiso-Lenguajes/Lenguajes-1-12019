using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB40894.Model.Domain
{
    public class Autor
    {
        private int id_autor;


        public int Id_autor { get; private set; }

   

        private string nombre;
        private string primer_apellido;
        private string segundo_apellido;

        public Autor(int id_autor, string nombre, string primer_apellido, string segundo_apellido)
        {
            Id_autor = id_autor;
            this.nombre = nombre;
            this.primer_apellido = primer_apellido;
            this.segundo_apellido = segundo_apellido;
        }

      


    }
}
