using Orbis_B62734_.Model.Data;
using Orbis_B62734_.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace Orbis_B62734_.Model.Business
{
   public class LibroBusiness
    {
        LibroData libroData;

        public LibroBusiness()
        {
            libroData = new LibroData();
        }
        public IEnumerable<Libro> GetByCodPublicador(int codPublicador) {
            yield return libroData.GetByCodPublicador(codPublicador);
        }
    }
}
