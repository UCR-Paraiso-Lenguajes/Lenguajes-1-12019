using OrbisB53953.Web.Data;
using OrbisB53953.Web.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace OrbisB53953.Web.Business
{
    public class PublicadorBusiness
    {

        private string connection;
        private PublicadorData publicadorData;
        public PublicadorBusiness(string connection)
        {
            if (string.IsNullOrEmpty(connection)) throw new Exception("El string de conexión es requerido.");

            this.connection = connection;
            this.publicadorData = new PublicadorData();
        }

        public IEnumerable<Publicador> GetAll()
        {
            return this.publicadorData.GetAll();
        }
    }
}
