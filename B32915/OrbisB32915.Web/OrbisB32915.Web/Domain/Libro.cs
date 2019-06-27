using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB32915.Web.Domain
{
    public class Libro
    {
        private int id_libro;
        private string titulo;
        private int ano;
        private double precio;
        private int isbn;
        private int id_editorial;

        public Libro(int id_libro, string titulo, int ano, double precio, int id_editorial, int isbn)
        {
        Id_libro = id_libro;
        Titulo = titulo;
        Ano = ano;
        Precio = precio;
        Isbn = isbn;
        Id_editorial = id_editorial;
    }
        public int Id_libro { get; internal set; }
        public string Titulo { get; internal set; }
        public int Ano { get; internal set; }
        public double Precio { get; internal set; }
        public int Isbn { get; internal set; }
        public int Id_editorial { get; internal set; }
    }
}
