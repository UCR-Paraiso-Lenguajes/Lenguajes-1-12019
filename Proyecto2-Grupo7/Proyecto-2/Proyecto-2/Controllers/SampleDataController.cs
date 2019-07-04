using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Proyecto2.Clases.Data;
using Proyecto2.Clases.Domain;


namespace Proyecto_2.Controllers
{
    [Route("api/[controller]")]
    public class SampleDataController : Controller
    {
        ProductoData data = new ProductoData();

        [HttpGet("[action]")]
        public IEnumerable<Producto> Products(string summary)
        {

            IEnumerable<Producto> products = data.listaProducto();

            /*for (int i = 50; i > 0; i--)
            {
                products.Add(new Producto(
                $@"Ford 2{i}",
                $@"Conoce Ford Figo 20{i} y descubre todo lo...",
                "https://www.ford.mx/content/dam/Ford/website-assets/latam/mx/nameplate/figo/2019/showroom/ford-figo-2019-auto-compacto-lateral-gris.png",
                i,
                20000 + i));
            }

            if (!string.IsNullOrEmpty(summary))
            {
                products.Where(p => p.Summary.Contains(summary) || p.Title.Contains(summary));
            }*/

            return products;
        }


        //private static string[] Summaries = new[]
        //{
        //    "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
        //};

        //[HttpGet("[action]")]
        //public IEnumerable<WeatherForecast> WeatherForecasts()
        //{
        //    var rng = new Random();
        //    return Enumerable.Range(1, 5).Select(index => new WeatherForecast
        //    {
        //        DateFormatted = DateTime.Now.AddDays(index).ToString("d"),
        //        TemperatureC = rng.Next(-20, 55),
        //        Summary = Summaries[rng.Next(Summaries.Length)]
        //    });
        //}

        //public class WeatherForecast
        //{
        //    public string DateFormatted { get; set; }
        //    public int TemperatureC { get; set; }
        //    public string Summary { get; set; }

        //    public int TemperatureF
        //    {
        //        get
        //        {
        //            return 32 + (int)(TemperatureC / 0.5556);
        //        }
        //    }
    }

    
}
