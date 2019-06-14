using OrbisB74560.Model.ExceptionOrbis;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB74560.Model.Domain
{
    public class Autor
    {
        private int idAutor;
        private string nombre_autor;
        private string apellidos_autor;
        public int id_Autor
        {
            get { return idAutor; }
            set
            {
                if (value <= 0) throw new ExceptionsOrbis("El id debe ser positivo");
                idAutor = value;
            }
        }
        public string Nombre_autor
        {
            get { return nombre_autor; }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new ExceptionsOrbis("El nombre esta nulo o vacio");
                nombre_autor = value;
            }
        }
        public string Apellidos_autor
        {
            get { return apellidos_autor; }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new ExceptionsOrbis("Los apellidos no pueden ser vacios o nulos");
                apellidos_autor = value;
            }
        }

        public Autor(int idAutor, string nombre_autor, string apellidos_autor)
        {
            this.idAutor = idAutor;
            Nombre_autor = nombre_autor;
            Apellidos_autor = apellidos_autor;
        }
    }
}
