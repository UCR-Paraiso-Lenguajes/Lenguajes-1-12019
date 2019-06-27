using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using model.Data;
using model.Domain;

namespace B40894Examen2.Controllers
{
    public class DespliegaController : Controller
    {
        public IActionResult Index()
        {

            IEnumerable<Departamentos> departamentos = new DepartamentosData().GetListDepartamentos();

            return View(departamentos);
        }

        public IActionResult Seleccion(int id)
        {
            DepartamentosData departamentosData = new DepartamentosData();

            departamentosData.MetodoDeSeleccionado(id);

            IEnumerable<Departamentos> departamentos = departamentosData.GetListDepartamentos();

            return View(departamentos);
        }
    }
}