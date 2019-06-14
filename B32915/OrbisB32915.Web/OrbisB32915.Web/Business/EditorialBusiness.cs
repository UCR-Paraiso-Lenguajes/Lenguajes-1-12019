using OrbisB32915.Web.Data;
using OrbisB32915.Web.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB32915.Web.Business
{
    public class EditorialBusiness
    {

        public EditorialBusiness()
        {

        }

        private string connection;
        private EditorialData editorialData;

        public EditorialBusiness(string connection)
        {
            if (string.IsNullOrEmpty(connection)) throw new Exception("El string de conexión es requerido.");

            this.connection = connection;
        }

        public IEnumerable<Editorial> GetAll()
        {
            return this.editorialData.GetAll();
        }

    }
}
