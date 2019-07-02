using System;
using System.Collections.Generic;
using System.Text;
using System.Net.Http;
using Xunit;
using Microsoft.AspNetCore.TestHost;
using Microsoft.AspNetCore.Hosting;
using ExamenPriscilla;
using System.Threading.Tasks;
using System.Net;
using ExamenPriscilla.Domain;
using ExamenPriscilla.Data;

namespace XUnitTestExamenPriscilla.Api
{
    public class DepartamentoApiTest
    {
        private readonly HttpClient cliente;
        private DepartamentoData departamentoData;
        

        public DepartamentoApiTest()
        {
            var server = new TestServer(new WebHostBuilder().
                UseEnvironment("Development").UseStartup<Startup>());
            cliente = server.CreateClient();

        }

        [Theory]
        [InlineData("GET")]
        public async Task obtenerDepartamentos(string method)
        {
            //arrange
            var request = new HttpRequestMessage(new HttpMethod(method), "/api/departamento/");

            //act
            var response = await cliente.SendAsync(request);

            response.EnsureSuccessStatusCode();

            List<Departamento> departamentos = new List<Departamento>();
            Departamento d1 = new Departamento("asamblea socios", 1, 0);
            Departamento d2 = new Departamento(d1, "gerente general", 2, 0);
            Departamento d3 = new Departamento(d2, "dpto administrativo", 3, 0);
            Departamento d4 = new Departamento(d2, "dpto comercial", 4, 0);
            Departamento d5 = new Departamento(d2, "dpto de operaciones", 5, 0);

            departamentos.Add(d1);
            departamentos.Add(d2);
            departamentos.Add(d3);
            departamentos.Add(d4);
            departamentos.Add(d5);


            Assert.Equal(departamentos, departamentoData.obtenerDepartamentos());

        }

        [Theory]
        [InlineData("GET",1)]
        public async Task obtenerDepartamento(string method, int? id = null)
        {
            //arrange
            var request = new HttpRequestMessage(new HttpMethod(method), $"/api/departamento/{id}");

            //act
            var response = await cliente.SendAsync(request);

            response.EnsureSuccessStatusCode();
            Assert.Equal(HttpStatusCode.OK, response.StatusCode);

        }

        [Theory]
        [InlineData("POST")]
        public async Task insertarDepartamento(string method)
        {
            //arrange
            var request = new HttpRequestMessage(new HttpMethod(method), "/api/departamento/");

            //act
            var response = await cliente.SendAsync(request);

            response.EnsureSuccessStatusCode();
            Assert.Equal(HttpStatusCode.OK, response.StatusCode);

        }


        [Theory]
        [InlineData("PUT", 1)]
        public async Task actualizarDepartamento(string method, int? id = null)
        {
            //arrange
            var request = new HttpRequestMessage(new HttpMethod(method), $"/api/departamento/{id}");

            //act
            var response = await cliente.SendAsync(request);

            response.EnsureSuccessStatusCode();
            Assert.Equal(HttpStatusCode.OK, response.StatusCode);

        }

        [Theory]
        [InlineData("DELETE", 1)]
        public async Task eliminarDepartamento(string method, int? id = null)
        {
            //arrange
            var request = new HttpRequestMessage(new HttpMethod(method), $"/api/departamento/{id}");

            //act
            var response = await cliente.SendAsync(request);

            response.EnsureSuccessStatusCode();
            Assert.Equal(HttpStatusCode.OK, response.StatusCode);

        }



    }
}
