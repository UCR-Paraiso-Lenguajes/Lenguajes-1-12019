using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Model.Domain
{
    public class Libro
    {
        private int cod_libro;
        private string titulo;
        private int ano;

        public int codLibro { internal set; get; }
        public string tituloLibro { internal set; get; }
        public int anoPublicacion { internal set; get; }
        public string isbn { internal set; get; }
        public double precio { internal set; get; }

        public Publicador publicdor { internal set; get; }
        public List<Autor> autores { internal set; get; }

        public Libro(int codLibro, string tituloLibro, int anoPublicacion, string isbn, double precio, Publicador publicdor, List<Autor> autores)
        {
            this.codLibro = codLibro;
            this.tituloLibro = tituloLibro;
            this.anoPublicacion = anoPublicacion;
            this.isbn = isbn;
            this.precio = precio;
            this.publicdor = publicdor;
            this.autores = autores;
        }

        public Libro(int cod_libro, string titulo, int ano, string isbn, int precio)
        {
            this.cod_libro = cod_libro;
            this.titulo = titulo;
            this.ano = ano;
            this.isbn = isbn;
            this.precio = precio;
        }
    }
}
