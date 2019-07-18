using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Model.Domain;
using Model.Business;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Web.Controllers
{
  
    public class LibroController : Controller
    {

        readonly IConfiguration configuration;
        LibroBusiness libroBusiness;
        PublicadorBusiness publicadorBusiness;

        public LibroController(IConfiguration configuration)
        {
            this.configuration = configuration;
        }

        // GET api/<controller>/5
        // [HttpGet("{id}")]
        [HttpGet]
        public IActionResult Index()
        {
            // publicadorBusiness = new PublicadorBusiness(configuration.GetConnectionString("DefaultConnection").ToString());
            string sql = "Server=163.178.173.148; initial catalog=Lab4-[B63199];user id=estudiantesrp;password=estudiantesrp; MultipleActiveResultSets=True";
           // string sql = configuration.GetConnectionString("sql");
            IEnumerable<Publicador> publicadores = new PublicadorBusiness(sql).List();


            return View(publicadores);


        }

        [HttpPost]
        public IActionResult Index(int codPublicador)
        {
           // libroBusiness = new LibroBusiness(configuration.GetConnectionString("DefaultConnection").ToString());
            string sql = "Server=163.178.173.148; initial catalog=Lab4-[B63199];user id=estudiantesrp;password=estudiantesrp; MultipleActiveResultSets=True";
            // string sql = configuration.GetConnectionString("sql");

            IEnumerable<Libro> libros = new LibroBusiness(sql).List(codPublicador);

            return View(libros);
        }
    }
}
