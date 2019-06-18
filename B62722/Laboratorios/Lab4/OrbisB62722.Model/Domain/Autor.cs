using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB62722.Model.Domain
{
    public class Autor
    {
        public Autor()
        {

        }

        public Autor(int id_autor, string nombre_autor, string primer_apellido, string segundo_apellido)
        {
            this.id_autor = id_autor;
            this.nombre_autor = nombre_autor;
            this.primer_apellido = primer_apellido;
            this.segundo_apellido = segundo_apellido;
        }

        public int id_autor
        {
            get { return id_autor; }
            set { id_autor = value; }
        }

        public string nombre_autor
        {
            get { return nombre_autor; }
            set { nombre_autor = value; }
        }

        public string primer_apellido
        {
            get { return primer_apellido; }
            set { primer_apellido = value; }
        }

        public string segundo_apellido
        {
            get { return segundo_apellido; }
            set { segundo_apellido = value; }
        }
    }
}
