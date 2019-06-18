using OrbisB53953.Model.Data;
using OrbisB53953.Web.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB53953.Model.Business
{
    class LibrorBusiness
    {

        private string connection;
        private LibroData libroData;
        public LibrorBusiness(string connection)
        {
            if (string.IsNullOrEmpty(connection)) throw new Exception("El string de conexión es requerido.");

            this.connection = connection;
            this.libroData = new LibroData();
        }

        public List<Libro> GetByPublicador(int idPublicador)
        {
            return this.libroData.GetByPublicador(idPublicador);
        }
    }
}
