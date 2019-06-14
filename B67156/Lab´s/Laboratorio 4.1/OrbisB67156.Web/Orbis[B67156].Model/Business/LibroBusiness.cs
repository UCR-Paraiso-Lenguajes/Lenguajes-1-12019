using Orbis_B67156_.Model.Data;
using Orbis_B67156_.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Orbis_B67156_.Model.Business
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

        public IEnumerable<Libro> List(int codPublicador)
        {
            return this.libroData.GetByCodPublicador(codPublicador);
        }
    }
}
