using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using model.Data;
using model.Domain;

namespace B32915Exa3.Controllers
{
    public class PeliculasController : Controller
    {
        public IActionResult Index()
        {

            IEnumerable<Pelicula> peliculas = new PeliculaData().ObtenerListaPeliculas();

            return View(peliculas);
        }
     }
}