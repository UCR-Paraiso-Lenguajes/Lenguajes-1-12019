using Orbis_B67156_.Model.Data;
using Orbis_B67156_.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Orbis_B67156_.Model.Business
{
    public class PublicadorBusiness
    {

        private string connection;
        private PublicadorData publicadorData;
        public PublicadorBusiness(string connection)
        {
            if (string.IsNullOrEmpty(connection)) throw new Exception("El string de conexión es requerido.");

            this.connection = connection;
            this.publicadorData = new PublicadorData(connection);
        }

        public IEnumerable<Publicador> List()
        {
            return this.publicadorData.GetAll();
        }
    }
}
