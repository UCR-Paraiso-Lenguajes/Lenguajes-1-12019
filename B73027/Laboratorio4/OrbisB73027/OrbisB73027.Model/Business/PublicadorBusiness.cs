using OrbisB73027.Model.Data;
using OrbisB73027.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB73027.Model.Business
{
    public class PublicadorBusiness
    {
        private PublicadorData publicadorData;

        public PublicadorBusiness()
        {
            this.publicadorData = new PublicadorData();
        }
        public IEnumerable<Publicador> GetAll()
        {
            return publicadorData.GetAll();
        }
    }
}
