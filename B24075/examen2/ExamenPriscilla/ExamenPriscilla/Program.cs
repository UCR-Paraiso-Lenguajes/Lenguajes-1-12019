using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using ExamenPriscilla.Data;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Logging;

namespace ExamenPriscilla
{
    public class Program
    {

        public DepartamentoData departamentoData = new DepartamentoData();

        public static void Main(string[] args)
        {
        
            
            CreateWebHostBuilder(args).Build().Run();

         
    }

        public static IWebHostBuilder CreateWebHostBuilder(string[] args) =>
            WebHost.CreateDefaultBuilder(args)
                .UseStartup<Startup>();
    }
}
