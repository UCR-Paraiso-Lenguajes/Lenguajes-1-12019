
using System.Collections.Generic;
using Microsoft.AspNetCore.Mvc;
using Model;

namespace Api.Controllers
{
    public class ApiController : Controller
    {

        public static stubPeliculas stubPeliculas = new stubPeliculas();


        [HttpGet("api/peliculas")]
        public List<string> mostrar()
        {
            
            return stubPeliculas.llenaPeliculas();

        }

    }
}