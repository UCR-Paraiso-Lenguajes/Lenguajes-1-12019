using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using OrbisB40894.Model.Business;
using OrbisB40894.Model.Domain;

namespace OrbisB40894.Web.Controllers
{
    public class PublicadorController : Controller
    {
        readonly IConfiguration configuration;
        public PublicadorController(IConfiguration configuration)
        {
            this.configuration = configuration;
        }
        public IActionResult Index()
        {
            string sql = configuration.GetConnectionString("sql");
   
            IEnumerable<Publicador> publicadores = new PublicadorBusiness(sql).List();

            return View(publicadores);
       
        }
    }
}