using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Examen2B52265.Models;
using ModelExamen2.Domain;
using ModelExamen2.Data;

namespace Examen2B52265.Controllers
{
    public class HomeController : Controller
    {

        public DepartamentosData depa = new DepartamentosData();
        
        public IActionResult Index()
        {
           depa.MetodoDeJerarquia(11);
            IEnumerable<Departamentos> departamentos = depa.GetDepartamentos();

            return View(departamentos);
        }
        public IActionResult About()
        {
            ViewData["Message"] = "Your application description page.";

            return View();
        }

        public IActionResult Contact()
        {
            ViewData["Message"] = "Your contact page.";

            return View();
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
