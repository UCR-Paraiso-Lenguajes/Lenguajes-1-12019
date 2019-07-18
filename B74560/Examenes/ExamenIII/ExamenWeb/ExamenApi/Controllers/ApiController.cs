
using ExamenModel.data;
using ExamenModel.domain;
using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;

namespace ExamenApi.Controllers
{
    public class ApiController : Controller
    {
        private static StubPelicula stubPeliculas = new StubPelicula();

        [HttpGet("api/listarpeliculas")]
        public List<string> listarPelicula()
        {

            return stubPeliculas.llenarPeliculas();

        }

        [HttpGet("api/listarPeliculaNombres")]
        public List<string> listarPeliculaNombres()
        {

            return stubPeliculas.llenarPeliculasNombres();

        }

    }
}