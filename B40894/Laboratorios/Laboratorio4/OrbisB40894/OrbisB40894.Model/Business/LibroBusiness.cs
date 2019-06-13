using OrbisB40894.Model.Data;
using OrbisB40894.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB40894.Model.Business
{
   public class LibroBusiness
    {
        private string connection;
        private LibroData libroData;
        public LibroBusiness(string connection)
        {
            if (string.IsNullOrEmpty(connection)) throw new Exception("El string de conexión es requerido.");

            this.connection = connection;
            this.libroData = new LibroData();
        }

        public IEnumerable<Libro> List(int id_publicador)
        {
            return this.libroData.GetByCodPublicador(id_publicador);
        }
    }
}
