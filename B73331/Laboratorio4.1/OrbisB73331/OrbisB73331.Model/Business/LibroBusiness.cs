using OrbisB73331.Model.Data;
using OrbisB73331.Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB73331.Model.Business
{
    public class LibroBusiness
    {
        private LibroData libroData;
        private String connectionString;
        public LibroBusiness(String connectionStringP)
        {
            if (string.IsNullOrEmpty(connectionStringP)) throw new Exception("El string de conexión es requerido.");

            this.connectionString = connectionStringP;
            this.libroData = new LibroData(this.connectionString);
        }
        public IEnumerable<Libro> GetByCodPublicador(int codPublicador)
        {
            return this.libroData.GetByCodPublicador(codPublicador);
        }
    }
}
