using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB40894.Model.Domain
{
    public class Libro
    {
        private int cod_libro;

        public int Cod_libro { get; private set; }
        public string Titulo { get; private set; }
        public int Año_publicacion { get; private set; }
        public string Isbn { get; private set; }
        public double Precio { get; private set; }


        private string titulo;
        private int año_publicacion;
        private string isbn;
        private double precio;

        private List<Autor> autores = new List<Autor>();
        public List<Autor> Autores { get; private set; }

        private Publicador publicador;

        public Publicador Publicador { get; private set; }

        public Libro(int cod_libro, string titulo, double precio)
        {
            
            Titulo = titulo;
            Cod_libro = cod_libro;
            Precio = precio;
        }

    }

}
