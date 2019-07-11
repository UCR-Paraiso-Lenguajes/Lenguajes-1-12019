using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ProyectoDosGrupoCinco.Business;
using ProyectoDosGrupoCinco.Domain;

namespace WebProyectoDosGrupoCinco.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuarioController : ControllerBase
    {

        UsuarioBusiness usuarioBusiness = new UsuarioBusiness();

        [HttpGet]
        [Route("getAll")]
        public List<Usuario> Get()
        {
            return usuarioBusiness.GetAllUsuarios();
        }

        // GET: api/Usuario/5
        [HttpGet("{id}", Name = "Get")]
        public Usuario Get(int id)
        {
        return usuarioBusiness.BuscarPorId(id);
        }

        // POST: api/Usuario
        [HttpPost]
        public void Post([FromBody] Usuario usuario)
        {
            usuarioBusiness.InsertarUsuario(usuario);
        }

        // PUT: api/Usuario/5
        [HttpPut("{id}")]
        public void Activar(int id)
        {
            usuarioBusiness.Activar(id);
        }

       
    }
}
