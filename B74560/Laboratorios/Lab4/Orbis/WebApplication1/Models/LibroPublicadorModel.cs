using OrbisB74560.Model.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB74560.web.Models
{
    public class LibroPublicadorModel
    {
        private List<Libro> libros = new List<Libro>();
        private List<Publicador> publicadores = new List<Publicador>();

        public LibroPublicadorModel(List<Libro> libros, List<Publicador> publicadores)
        {
            this.libros = libros;
            this.publicadores = publicadores;
        }

        public LibroPublicadorModel()
        {
        }
        public List<Libro> Libros
        {
            get { return libros; }
            set
            {
                libros = value;
            }
        }
        public List<Publicador> Publicadores
        {
            get { return publicadores; }
            set
            {
                publicadores = value;
            }
        }
    }
}
