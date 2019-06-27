using Model.Data;
using Model.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Model.Business
{
    public class LibroBusiness
    {
        private string connection;
        private LibroData libroData;

        public LibroBusiness(string connection)
        {
            if (string.IsNullOrEmpty(connection)) throw new Exception("El string de conexión es requerido.");

            this.connection = connection;
            this.libroData = new LibroData(connection);
        }

        public IEnumerable<Libro> List(int cod_publicador)
        {
            return this.libroData.GetLibrosByPublicadores(cod_publicador);
        }

    }

}

