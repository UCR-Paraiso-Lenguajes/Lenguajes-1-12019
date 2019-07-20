using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Examen3B56860.Pages
{
    [Route("api/[controller]")]
    [ApiController]
    public class PeliculasController : ControllerBase
    {

        private MockPeliculas mockPeliculas = new MockPeliculas();

        // GET 
        [HttpGet]
        public IEnumerable<Pelicula> Get()
        {
            return mockPeliculas.GetAllPeliculas();
        }

    }
}
