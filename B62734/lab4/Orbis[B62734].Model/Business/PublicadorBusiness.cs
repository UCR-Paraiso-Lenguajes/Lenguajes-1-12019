using Orbis_B62734_.Model.Data;
using Orbis_B62734_.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Orbis_B62734_.Model.Business
{
    public class PublicadorBusiness
    {
    PublicadorData publicadorData;

        public PublicadorBusiness()
        {
            publicadorData = new PublicadorData();
        }
        public IEnumerable<Publicador> GetAll() {
            return publicadorData.GetAll();
        }
    }
}
