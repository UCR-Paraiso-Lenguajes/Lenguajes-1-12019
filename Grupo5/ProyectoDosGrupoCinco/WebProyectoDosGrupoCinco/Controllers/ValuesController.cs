using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using MailKit.Net.Smtp;
using Microsoft.AspNetCore.Mvc;
using MimeKit;
using ProyectoDosGrupoCinco.Business;
using ProyectoDosGrupoCinco.Data;

namespace WebProyectoDosGrupoCinco.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ValuesController : ControllerBase
    {

        OrdenDeCompraData ordenDeCompraData = new OrdenDeCompraData();
        // GET api/values
        [HttpGet]
        public ActionResult<IEnumerable<string>> Get()
        {

         //   ordenDeCompraData.ComprarCarrito("Cartago, Pitahaya", "alfonsoaju6@gmail.com", 1);
    
            

            return new string[] { "value1", "value2" };
        }

        // GET api/values/5
        [HttpGet("{id}")]
        public ActionResult<string> Get(int id)
        {
            return "value";
        }

        // POST api/values
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/values/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/values/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
