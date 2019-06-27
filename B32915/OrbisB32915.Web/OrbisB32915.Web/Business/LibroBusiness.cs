using OrbisB32915.Web.Data;
using OrbisB32915.Web.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB32915.Web.Business
{
    public class LibroBusiness
    {
        public LibroBusiness()
        {

        }

        private string connection;
        private LibroData libroData;
        public LibroBusiness(string connection)
        {
            if (string.IsNullOrEmpty(connection)) throw new Exception("El string de conexión es requerido.");

            this.connection = connection;
        }

        public IEnumerable<Libro> GetByPublicadorId(int idPublicador = 1)
        {
            return this.libroData.GetByPublicador(idPublicador);
        }
    }
}
