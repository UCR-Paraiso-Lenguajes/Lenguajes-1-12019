using OrbisB63685Model.Data;
using OrbisB63685Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB63685Model.Business
{
    public class EditorialBusiness
    {
        EditorialData editorialData = new EditorialData();

        public IEnumerable<Editorial> GetAll()
        {

            return editorialData.GetAll();
        }


    }
}

