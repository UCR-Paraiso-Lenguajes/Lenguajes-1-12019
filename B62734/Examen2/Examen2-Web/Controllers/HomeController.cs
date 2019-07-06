using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Examen2_Clases.Business;

namespace Examen2.Web.Controllers
{
    public class HomeController : Controller
    {

        public IActionResult Index()
        {
            DepartamentoBusiness departamentoBusiness = new DepartamentoBusiness();

            TempData["listaDepartamentos"] = departamentoBusiness.Listar();
            return View();
        }
    }
}
