using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Orbis_B67156_.Model.Business;
using Orbis_B67156_.Model.Domain;
using OrbisB67156.Web.Models;

namespace OrbisB67156.Web.Controllers
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
            string connection = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B77436]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            int cod = 0;
            IEnumerable<Libro> libro = new LibroBusiness(connection).List(cod);
            IEnumerable<Publicador> publicadores = new PublicadorBusiness(connection).List();

            return View(publicadores);
        }


        public IEnumerable<Libro> GetLibros()
        {
            string path = Request.Path.Value;
            int startIndex = path.Length - "/Libro/GetLibros/".Length;
            string idString = path.Substring("/Libro/GetLibros/".Length, startIndex);
            int id = System.Convert.ToInt32(idString);
            string connectionString = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B77436]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            LibroBusiness libroBusiness = new LibroBusiness(connectionString);



            IEnumerable<Libro> libros = libroBusiness.List(id);
            return libros;
        }

    }
}
