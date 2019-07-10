using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Data
{
    public class ProductoDataTest
    {
        [SetUp]
        public void Setup()
        {
        }
        [Test]
        public void BuscaProductoEspecifico()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoData productoData = new ProductoData(sqlconnect);



            IEnumerable<Producto> lista = productoData.ObtenerProducto(1);

            Assert.NotNull(lista);

        }


        [Test]
        public void ListarProductos()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoData productoData = new ProductoData(sqlconnect);



            IEnumerable<Producto> lista = productoData.ObtenerRango(1);

            Assert.NotNull(lista);

        }

        [Test]
        public void InsertarProductos()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoData productoData = new ProductoData(sqlconnect);



            Producto producto = new Producto(80000, 4, 5, "LG", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");


            Assert.AreEqual(80000,producto.PrecioUnitario);
            Assert.AreEqual(4, producto.IdProducto);
            Assert.AreEqual(5, producto.Impuesto);
            Assert.AreEqual("LG",producto.Nombre);
            Assert.AreEqual("Celular",producto.Descripcion);
            Assert.AreEqual(10, producto.CantidadDisponible);

            productoData.InsertarProducto(producto);

        }

        [Test]
        public void ActualizarProducto()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoData productoData = new ProductoData(sqlconnect);



            Producto producto = new Producto(20000, 4, 3, "LG", "Tablet", 20, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");


            Assert.AreEqual(20000, producto.PrecioUnitario);
            Assert.AreEqual(4, producto.IdProducto);
            Assert.AreEqual(3, producto.Impuesto);
            Assert.AreEqual("LG", producto.Nombre);
            Assert.AreEqual("Tablet", producto.Descripcion);
            Assert.AreEqual(20, producto.CantidadDisponible);

            productoData.Actualiza(producto);


        }

        [Test]
        public void BorrarProducto()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoData productoData = new ProductoData(sqlconnect);



            Producto producto = new Producto(20000, 4, 3, "LG", "Tablet", 20, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");


            Assert.AreEqual(20000, producto.PrecioUnitario);
            Assert.AreEqual(4, producto.IdProducto);
            Assert.AreEqual(3, producto.Impuesto);
            Assert.AreEqual("LG", producto.Nombre);
            Assert.AreEqual("Tablet", producto.Descripcion);
            Assert.AreEqual(20, producto.CantidadDisponible);

            productoData.BorrarProducto(4);

        }
    }
}
