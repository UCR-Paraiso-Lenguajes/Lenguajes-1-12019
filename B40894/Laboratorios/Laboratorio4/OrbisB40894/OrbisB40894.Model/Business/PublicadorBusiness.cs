using OrbisB40894.Model.Data;
using OrbisB40894.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB40894.Model.Business
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
            return this.publicadorData.GetAll();
        }
    }
}
