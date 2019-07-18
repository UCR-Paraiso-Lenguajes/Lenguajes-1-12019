using Model.Data;
using Model.Domain;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Web.Controllers
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

        public IEnumerable<Publicador> List()
        {
            return publicadorData.GetAllPublicadores(connection);
        }
    }
}

