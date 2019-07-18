using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Examen2_Clases.Business;
using Examen2_Clases.Domain;


namespace Examen2_react.Controllers
{
    [ApiController]
    public class DepartamentosController : ControllerBase
    {
        DepartamentoBusiness departamentoBusiness = new DepartamentoBusiness();
        [HttpGet("api/departamentos")]
        public IEnumerable<Departamento> Listar()
        {
            return departamentoBusiness.Listar();
        }
        [HttpPut("api/updateDepartamento/{departamentoNuevo}")]
        public void Actualizar( [FromBody] Departamento departamentoNuevo)
        {
            departamentoBusiness.Actualizar( departamentoNuevo);
        }
        [HttpDelete("api/deleteOrganigrama/{departamento}")]
        public void Eliminar([FromBody] Departamento departamento)
        {
            departamentoBusiness.Eliminar(departamento);
        }
        [HttpPost("api/agregarOrganigrama/{departamento}")]
        public void Agregar([FromBody] Departamento departamento)
        {
            departamentoBusiness.Agregar(departamento);
        }
    }
}