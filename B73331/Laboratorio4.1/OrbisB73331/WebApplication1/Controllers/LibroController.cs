﻿using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using OrbisB73331.Model.Business;
using OrbisB73331.Model.Domain;
using OrbisB73331.web.Models;
using WebApplication1.Models;

namespace OrbisB73331.web.Controllers
{
    public class LibroController : Controller
    {
        readonly IConfiguration configuration;

        public LibroController(IConfiguration configuration)
        {
            this.configuration = configuration;
        }
        public IActionResult Index()
        {
            PublicadorBusiness publicadorBusiness = new PublicadorBusiness();

            /*string connectionString = configuration.GetConnectionString("data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B73331]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True");*/
            string connectionString = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B73331]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            IEnumerable<Publicador> publicadores = publicadorBusiness.GetAll();
            LibroPublicadorModel model = new LibroPublicadorModel();
            model.Publicadores = (List<Publicador>)publicadores;
            //var newO = new O() { test = "cat" };
            return View(model);
        }
        public IEnumerable<Libro> GetLibros()
        {
            string path = Request.Path.Value;
            int startIndex = path.Length - "/Libro/GetLibros/".Length;
            string idString = path.Substring("/Libro/GetLibros/".Length, startIndex);
            int id = System.Convert.ToInt32(idString);
            string connectionString = "data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B73331]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            LibroBusiness libroBusiness = new LibroBusiness(connectionString);

            /*string connectionString = configuration.GetConnectionString("data source = " +
                "163.178.173.148;initial " +
                "catalog=Orbis[B73331]_I_2019;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True");*/
            
            IEnumerable<Libro> libros = libroBusiness.GetByCodPublicador(id);
            //var newO = new O() { test = "cat" };
            return libros;
        }
    }
}