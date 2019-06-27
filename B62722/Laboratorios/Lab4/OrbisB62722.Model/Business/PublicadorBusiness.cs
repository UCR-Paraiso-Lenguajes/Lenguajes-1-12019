using OrbisB62722.Model.Data;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB62722.Model.Business
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
    }
}
