using AccesoDatos;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Servicios
{
   public class PublicadorBusiness
    {
        #region variables
        private PublicadorData publicadorData = new PublicadorData();
        #endregion

        /// <summary>
        /// Priscilla Mena
        /// Efecto: devuelve una lista con todos los Libros
        /// Requiere: -
        /// Modifica: -
        /// Devuelve: lista de Libros
        /// </summary>
        /// <returns></returns>
        public List<Libro> GetByCodPublicador(int codPublicador)
        {
            return publicadorData.GetByCodPublicador(codPublicador);

        }
        public List<Publicador> getPublicadores()
        {
            return publicadorData.getPublicadores();
        }

        }
}
