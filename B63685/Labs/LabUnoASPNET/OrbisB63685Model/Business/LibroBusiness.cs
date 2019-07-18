using OrbisB63685Model.Data;
using OrbisB63685Model.Domain;
using System;
using System.Collections.Generic;
using System.Text;

namespace OrbisB63685Model.Business
{
   public class LibroBusiness
    {
        LibroData libroData = new LibroData();

        public IEnumerable<Libro> GetByCodEditorial(String codPublicador)
        {
            return libroData.GetByCodEditorial(codPublicador);
        }

        }
    }
