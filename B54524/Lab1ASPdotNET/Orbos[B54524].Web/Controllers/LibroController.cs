using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using OrbisB54524.Model.Domain;
using OrbisB54524.Model.Business;
using System.Dynamic;

namespace Orbis_B54524_.Web.Controllers
{
    public class LibroController : Controller
    {
        readonly IConfiguration configuration;
        public LibroController(IConfiguration configuration)
        {
            this.configuration = configuration;
        }
        [HttpGet]
        public IActionResult Index()
        {
            string sql = configuration.GetConnectionString("sql");
            dynamic Model = new ExpandoObject();
            Model.Publicadores = new PublicadorBusiness(sql).getAll();
            Model.Libros = new LibroBusiness(sql).GetByPublicadorCode();
            return View(Model);
        }
        //[Route("LibroController/IndexPost")]
        [HttpPost]
        public IActionResult Index(string Segmentation)
        {
            int id = Convert.ToInt32(Segmentation);
            string sql = configuration.GetConnectionString("sql");
            dynamic Model = new ExpandoObject();
            Model.Publicadores = new PublicadorBusiness(sql).getAll();
            Model.Libros = new LibroBusiness(sql).GetByPublicadorCode(id);
            return View(Model);
        }
    }
}