using System;
using System.Collections.Generic;
using System.Text;

namespace Orbis_B67156_.Model.Domain
{
    class Autor
    {
        private int id_autor;
        public int Id_autor
        {
            get
            {
                return id_autor;
            }
            set
            {
                if (value <= 0) throw new Exception("Id autor es requerido");
                id_autor = value;
            }
        }
        private string nombre_autor;
        public string Nombre_autor
        {
            get
            {
                return nombre_autor;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Nombre autor es requerido");
                nombre_autor = value;
            }
        }
        private string apellidos_autor;
        public string Apellidos_autor
        {
            get
            {
                return apellidos_autor;
            }
            set
            {
                if (string.IsNullOrEmpty(value)) throw new Exception("Apellidos autor es requerido");
                apellidos_autor = value;
            }
        }

        public Autor(int id_autor, string nombre_autor, string apellidos_autor)
        {
            Id_autor = id_autor;
            Nombre_autor = nombre_autor;
            Apellidos_autor = apellidos_autor;
        }

    }

}
