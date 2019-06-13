using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB63685Model.Domain
{
    public class Libro
    {
        private int codLibro;
        private string tituloLibro;
        private string isbn;
        private int anoPublicacion;
        private int idEditorial;
        private List<Autor> autores;
        private double precio;

        public Libro(int codLibro, string tituloLibro, double precio)
        {
            this.codLibro = codLibro;
            this.tituloLibro = tituloLibro;
            this.precio = precio;
        }

        public int CodLibro { get => codLibro; set => codLibro = value; }
        public string TituloLibro { get => tituloLibro; set => tituloLibro = value; }
        public string Isbn { get => isbn; set => isbn = value; }
        public int AnoPublicacion { get => anoPublicacion; set => anoPublicacion = value; }
        public int IdEditorial { get => idEditorial; set => idEditorial = value; }
        public double Precio { get => precio; set => precio = value; }
        internal List<Autor> Autores { get => autores; set => autores = value; }
    }
}
