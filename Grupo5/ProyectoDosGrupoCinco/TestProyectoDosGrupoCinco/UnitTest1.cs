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


            Assert.AreEqual("Cables de alimentaci�n", producto.Nombre);
            Assert.AreEqual(3, producto.IdProducto);
            Assert.AreEqual(2.00, producto.Impuesto);
            Assert.AreEqual(2700, producto.Precio);
            Assert.AreEqual("PCI EXPRESS POWER CABLE", producto.Descripcion);
            Assert.AreEqual(100, producto.CantidadDisponible);
  

        }

        [Test]
        public void BuscarProducto2()
        {
            decimal impuesto = 5;
            Producto nuevoProducto=new Producto("test", impuesto, 50, "test", "'https://i56.photozi.com/images/hoFwB.jpg'", 50);

            
            
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


        }

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


        [Test]
        public void ActualizarInventario()
        {
            ProductoBusiness productoBusiness = new ProductoBusiness();

            productoBusiness.ActualizarCantidad(7, 500);

            ProductoData productoData = new ProductoData();

            Producto producto = productoData.GetProductById(7);




            Assert.AreEqual(producto.CantidadDisponible, 500);




        }


        [Test]
        public void RecuperarCarrito()
        {

            try
            {
                CarritoData carritoData = new CarritoData();

                carritoData.CarritoDisponible(2);
            }
            catch (Exception e)
            {
                CarritoData carritoData2 = new CarritoData();
                CarritoDisponible carrito = new CarritoDisponible(1,100,1000);

                carritoData2.crearCarrito(carrito);
            }

            




        }


        [Test]
        public void CarritoAgregar()
        {

            
            CarritoData carritoData = new CarritoData();

          /*CarritoDisponible carritoDisponible = carritoData.CarritoDisponible(3);*/

            ProductoData productoData = new ProductoData();

            Producto producto = productoData.GetProductById(2);

            ProductoCarrito productoCarrito = new ProductoCarrito(3, producto.IdProducto, 10);

            try
            {
                carritoData.carritoProducto(productoCarrito);
            }
            catch (Exception e)
            {
                carritoData.carritoProductoActualizar(productoCarrito);
            }


        }



    }
}