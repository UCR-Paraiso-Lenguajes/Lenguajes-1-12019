using OrbisB56860.Model.Data;
using OrbisB56860.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB56860.Model.Business
{
    public class PublicadorBusiness
    {

        private PublicadorData publicadorData;
        private string connection;

        public PublicadorBusiness(string connection)
        {
            if (string.IsNullOrEmpty(connection)) throw new Exception("El string de conexión es requerido.");

            this.connection = connection;
            publicadorData = new PublicadorData(connection);
        }

        public IEnumerable<Publicador> GetAll()
        {
            return publicadorData.GetAll() ?? throw new Exception("La lista no puede estar vacía");
        }

        public Publicador GetById(int idPublicador)
        {
            return publicadorData.GetById(idPublicador) ?? throw new Exception("El publicador debe existir");
        }
    }
}
