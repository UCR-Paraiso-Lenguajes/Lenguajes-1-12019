using System;
using System.Collections.Generic;
using System.Text;
using Microsoft.AspNetCore.Mvc;
using Orbis_B62734_.Model.Business;
using Orbis_B62734_.Model.Domain;
namespace OrbisB62734.Web.Model.Controller
{
    // [Route("api")]
   public class LibroController
    {
        [HttpGet("api/publicadores")]
        public IEnumerable<Publicador> Publicadores()
        {
            PublicadorBusiness publicadorBusiness = new PublicadorBusiness();    

            return publicadorBusiness.GetAll();
        }
        [HttpGet("api/libros")]
        public IEnumerable<Libro> Libros(int codPublicador)
        {
            LibroBusiness publicadorBusiness = new LibroBusiness();

            return publicadorBusiness.GetByCodPublicador(codPublicador);
        }
    }
}
