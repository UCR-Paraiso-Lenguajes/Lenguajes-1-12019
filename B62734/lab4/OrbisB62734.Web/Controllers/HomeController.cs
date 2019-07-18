using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using OrbisB62734.Web.Models;
using Microsoft.AspNetCore.Mvc.Rendering;
using System.Collections.Generic;
using Orbis_B62734_.Model.Business;
using System.Collections;
using Orbis_B62734_.Model.Domain;

namespace OrbisB62734.Web.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            PublicadorBusiness publicadorBusiness = new PublicadorBusiness();
            IEnumerable publicadores = publicadorBusiness.GetAll();
            List<SelectListItem> listaPublicadores = new List<SelectListItem>();
            
            foreach (Publicador publicador in publicadores) {
                listaPublicadores.Add(new SelectListItem(publicador.nombre_publicador,""+publicador.id_publicador));
                
            }
            TempData["listaPublicadores"] = listaPublicadores;

            return View();
        }

      

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
