using AccesoDatos;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Servicios
{
   public class LibroBusiness
    {

        private LibroData libroData = new LibroData();


        /// <summary>
        /// Priscilla Mena
        /// Efecto: devuelve una lista con todos los Libros
        /// Requiere: -
        /// Modifica: -
        /// Devuelve: lista de Libros
        /// </summary>
        /// <returns></returns>
        public List<Libro> getLibros()
        {

            return libroData.getLibros();
        }
        }
}
