using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB73331.Model.Domain
{
    public class Autor
    {
        private int id_autor;
        private string nombre_autor;
        private string apellidos_autor;
        public int Id_Autor
        {
            get { return id_autor; }
            set
            {
                if (value <= 0) throw new Exception("El id debe ser positivo");
                id_autor = value;
            }
        }
        public string Nombre_autor
        {
            get { return nombre_autor; }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("El nombre esta nulo o vacio");
                nombre_autor = value;
            }
        }
        public string Apellidos_autor
        {
            get { return apellidos_autor; }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Los apellidos no pueden ser vacios o nulos");
                apellidos_autor = value;
            }
        }

        public Autor(int id_autor, string nombre_autor, string apellidos_autor)
        {
            this.id_autor = id_autor;
            Nombre_autor = nombre_autor;
            Apellidos_autor = apellidos_autor;
        }
    }
}
