using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using LabUnoAspDotNet.Models;
using Microsoft.AspNetCore.Mvc.Rendering;
using OrbisB63685Model.Domain;
using OrbisB63685Model.Data;

namespace LabUnoAspDotNet.Controllers
{
    public class HomeController : Controller
    {


        public IActionResult Index()
        {


            Editorial editorial = new Editorial();
            editorial.Editoriales = PopulateEditorials();
            return View(editorial);


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



        private static List<SelectListItem> PopulateEditorials()
        {
            List<SelectListItem> items = new List<SelectListItem>();
            EditorialData editorialData = new EditorialData();
            IEnumerable<Editorial> lista = editorialData.GetAll();

            foreach (Editorial element in lista)
            {

                items.Add(new SelectListItem { Text = element.NombreEditorial, Value = "" + element.IdEditorial});
            }

            return items;
        }


        [HttpPost]
        public ActionResult Index(Editorial editorial)
        {
            editorial.Editoriales = PopulateEditorials();
            var selectedItem = editorial.Editoriales.Find(p => p.Value == editorial.idEditorial+"");
            if (selectedItem != null)
            {
                selectedItem.Selected = true;
                ViewBag.Message =selectedItem.Value;
            }

            return View(editorial);
        }
    }
}
