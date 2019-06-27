using OrbisB74560.Model.Data;
using OrbisB74560.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB74560.Model.Business
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
