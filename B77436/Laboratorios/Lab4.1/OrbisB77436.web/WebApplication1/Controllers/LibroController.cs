using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using OrbisB77436.web.Models;
using Microsoft.Extensions.Configuration;
using OrbisB77436.Model.Business;
using OrbisB7743.Model.Business;
using OrbisB77436.Model.Domain;

namespace OrbisB77436.web.Controllers
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
            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B77436]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";


            PublicadorBusiness publicadorBusiness = new PublicadorBusiness(sqlconnect);
            IEnumerable<Publicador> publicadores = publicadorBusiness.List();
            PublicadorLibro model = new PublicadorLibro();
            model.Publicadores = (List<Publicador>)publicadores;
            return View(model);
        }

        public IEnumerable<Libro> GetAll()
        {
            string path = Request.Path.Value;
            int startIndex = path.Length - "/Libro/GetAll/".Length;
            string idSelec = path.Substring("/Libro/GetAll/".Length, startIndex);
            int id = System.Convert.ToInt32(idSelec);

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B77436]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            LibroBusiness libroBusiness = new LibroBusiness(sqlconnect);

            IEnumerable<Libro> libros = libroBusiness.List(id);
            return libros;
        }
    }
}
