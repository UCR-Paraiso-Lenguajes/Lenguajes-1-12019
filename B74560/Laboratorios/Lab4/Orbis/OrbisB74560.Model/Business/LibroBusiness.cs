using OrbisB74560.Model.Data;
using OrbisB74560.Model.Domain;
using OrbisB74560.Model.ExceptionOrbis;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB74560.Model.Business
{
    public class LibroBusiness
    {
        private LibroData libroData;
        private String connectionString;
        public LibroBusiness(String connectionStringP)
        {
            if (string.IsNullOrEmpty(connectionStringP)) throw new ExceptionsOrbis("La caneda de conexión es requerido.");

            this.connectionString = connectionStringP;
            this.libroData = new LibroData(this.connectionString);
        }
        public IEnumerable<Libro> GetByCodPublicador(int codPublicador)
        {
            return this.libroData.GetByCodPublicador(codPublicador);
        }
    }
}
