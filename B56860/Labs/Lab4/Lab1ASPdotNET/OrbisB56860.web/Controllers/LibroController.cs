using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using OrbisB56860.Model.Business;
using OrbisB56860.Model.Domain;

namespace OrbisB56860.web.Controllers
{
    public class LibroController : Controller
    {

        readonly IConfiguration configuration;

        public LibroController(IConfiguration configuration)
        {
            this.configuration = configuration;
        }


        public IActionResult Index()
        {
            string sql = configuration.GetConnectionString("sql");

            IEnumerable<Libro> libros;
            Publicador publicador = new PublicadorBusiness(sql).GetAll().Last();
            libros = new LibroBusiness().GetByCodPublicador(publicador);
            
            ViewData["publicadores"] = new PublicadorBusiness(sql).GetAll();
            


            

            IEnumerable<Publicador> publicadores = new PublicadorBusiness(sql).GetAll();

            return View(publicadores);
        }

        public IEnumerable<Libro> Accion()
        {

            string path = Request.Path.Value;
            int startIndex = path.Length - "/Libro/Accion/".Length;
            string idSelec = path.Substring("/Libro/Accion/".Length, startIndex);
            int idPublicador = System.Convert.ToInt32(idSelec);



            string sql = configuration.GetConnectionString("sql");

            Publicador publicador = new PublicadorBusiness(sql).GetById(idPublicador);

            IEnumerable<Libro> libros = new LibroBusiness().GetByCodPublicador(publicador);


            return libros;
        }

    }
}