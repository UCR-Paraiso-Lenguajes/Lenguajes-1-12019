using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using OrbisB74560.Model.Business;
using OrbisB74560.Model.Domain;
using OrbisB74560.web.Models;
using WebApplication1.Models;

namespace OrbisB74560.web.Controllers
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
            PublicadorBusiness publicadorBusiness = new PublicadorBusiness();

            string connectionString = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Lab4_IF4100_B74560_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

            IEnumerable<Publicador> publicadores = publicadorBusiness.GetAll();
            LibroPublicadorModel model = new LibroPublicadorModel();
            model.Publicadores = (List<Publicador>)publicadores;
            return View(model);
        }
        public IEnumerable<Libro> GetLibros()
        {
            string path = Request.Path.Value;
            int startIndex = path.Length - "/Libro/GetLibros/".Length;
            string idString = path.Substring("/Libro/GetLibros/".Length, startIndex);
            int id = System.Convert.ToInt32(idString);

            string connectionString = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Lab4_IF4100_B74560_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

            LibroBusiness libroBusiness = new LibroBusiness(connectionString);
            IEnumerable<Libro> libros = libroBusiness.GetByCodPublicador(id);
            return libros;
        }
    }
}
