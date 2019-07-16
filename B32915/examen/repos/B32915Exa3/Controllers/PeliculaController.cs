using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using model.Data;
using model.Domain;

namespace B32915Exa3.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PeliculaController : ControllerBase
    {
        public PeliculaData peliculaData = new PeliculaData();
        // GET: api/Pelicula
        [HttpGet]
        public IEnumerable<Pelicula> ObtenerTodos()
        {
            return peliculaData.ObtenerListaPeliculas();
        }

        // GET: api/Pelicula/id
        [HttpGet("{id}")]
        public Pelicula ObtenerPorId(int id)
        {
            return peliculaData.ObtenerPeliculaPorId(id);
        }

        // POST: api/Pelicula
        [HttpPost]
        public void Post([FromBody] Pelicula value)
        {
            peliculaData.InsertarPelicula(value);
        }

        // PUT: api/Pelicula/id
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] Pelicula value)
        {
            peliculaData.EditarPelicula(value,id);
        }

        // DELETE: api/Pelicula/id
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            peliculaData.EliminarPelicula(id);
        }
    }
}
