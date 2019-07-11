using NUnit.Framework;
using ProyectoDosGrupoCinco.Business;
using ProyectoDosGrupoCinco.Data;
using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;

namespace Tests
{
    public class Tests
    {
        [SetUp]
        public void Setup()
        {
        }

        [Test]
        public void Test1()
        {
            Assert.Pass();
        }


        [Test]
        public void BuscarProducto()
        {
            ProductoData productoData = new ProductoData();

            Producto producto=productoData.GetProductById(3);


            Assert.AreEqual("llavero", producto.Nombre);
            Assert.AreEqual(3, producto.IdProducto);
            Assert.AreEqual(5.00, producto.Impuesto);
            Assert.AreEqual(500, producto.Precio);
            Assert.AreEqual("Llavero de game of thrones", producto.Descripcion);
            Assert.AreEqual(1000, producto.CantidadDisponible);
  

        }

      /*  [Test]
        public void BuscarProducto2()
        {
            decimal impuesto = 5;
            Producto nuevoProducto=new Producto("test", impuesto, 50, "test", "imagen", 50);

            
            
            ProductoData productoData = new ProductoData();

            productoData.InsertarProducto(nuevoProducto);

            List<Producto> productos = productoData.ListProducts() ;

            Producto ultimoProductoLista = new Producto();

            foreach (Producto item in productos)
            {

                ultimoProductoLista = item;

            }

            Producto producto = productoData.GetProductById(ultimoProductoLista.IdProducto);

            

            Assert.AreEqual("test", producto.Nombre);
            Assert.AreEqual(ultimoProductoLista.IdProducto, producto.IdProducto);
            Assert.AreEqual(impuesto, producto.Impuesto);
            Assert.AreEqual(50, producto.Precio);
            Assert.AreEqual("test", producto.Descripcion);
            Assert.AreEqual(50, producto.CantidadDisponible);


        }*/

        [Test]
        public void ListarProducto()
        {
              ProductoBusiness productoBusiness = new ProductoBusiness();
            List<Producto> productos = productoBusiness.CargarProductos(2);
            
             bool verifica = false;

              foreach (Producto item in productos)
              {

                  if (item.IdProducto > 50) {
                      verifica = true;
                    Console.WriteLine(item.IdProducto);
                }

              }

            

            Assert.AreEqual(verifica, true);




        }


    }
}