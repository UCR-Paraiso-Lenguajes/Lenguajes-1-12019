using OrbisB56860.Model.Data;
using OrbisB56860.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB56860.Model.Business
{
    public class LibroBusiness
    {

        private LibroData libroData = new LibroData("data source=" +
                "163.178.173.148;initial " +
                "catalog=OrbisB56860_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True");

        public IEnumerable<Libro> GetByCodPublicador(Publicador publicador)
        {
            return libroData.GetByCodPublicador(publicador) ?? throw new Exception("La lista no puede estar vacía");
        }

    }
}
