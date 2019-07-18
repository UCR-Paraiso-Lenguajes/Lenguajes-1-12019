using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using OrbisB40894.Model.Business;
using OrbisB40894.Model.Domain;

namespace OrbisB40894.Web.Controllers
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
            int id_publicador=101010101;           
            IEnumerable<Libro> libros = new LibroBusiness(sql).List(id_publicador);
            //IEnumerable<Publicador> publicadores = new PublicadorBusiness(sql).List();

            return View(libros);
        }
    }
}