using Examen2.Model.Business;
using Examen2.Model.Domain;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Threading.Tasks;

namespace Examen2.MVC.Controllers
{
    public class DepartamentoController : Controller
    {
        [HttpGet]
        public IActionResult Departamento()
        {
            DepartamentosBusiness departamentosBusiness = new DepartamentosBusiness();
            dynamic Model = new ExpandoObject();
            Model.dep = departamentosBusiness.CargarEstadoInicial();
            return View(Model);
        }

        [HttpPost]
        public IActionResult Departamento(int id)
        {
            DepartamentosBusiness departamentosBusiness = new DepartamentosBusiness();
            dynamic Model = new ExpandoObject();
            List<Departamento> listaActualizada = departamentosBusiness.Listar();
            foreach(Departamento dep in listaActualizada)
            {
                if(dep.IdDepartamento == id)
                {
                    marcar(dep);
                }
            }
            Model.dep = departamentosBusiness.Listar();

            return View(Model);
        }

        private void marcar(Departamento dep)
        {
            DepartamentosBusiness departamentosBusiness = new DepartamentosBusiness();
            if(dep.Jefatuta!=null)
            {
                departamentosBusiness.Actualizar(dep);
                marcar(dep.Jefatuta);
            }
        }

        [HttpPut]
        public IActionResult Departamento(string nombre, bool marcado, int id)
        {
            dynamic Model = new ExpandoObject();
            DepartamentosBusiness departamentosBusiness = new DepartamentosBusiness();
            Departamento departamento = new Departamento(nombre, marcado, id);
            departamentosBusiness.Actualizar(departamento);
            Model.dep = departamentosBusiness.Listar();

            return View(Model);
        }
    }
}
