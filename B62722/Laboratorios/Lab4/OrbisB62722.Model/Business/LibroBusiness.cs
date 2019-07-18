using OrbisB62722.Model.Data;
using OrbisB62722.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB62722.Model.Business
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
    }
}
