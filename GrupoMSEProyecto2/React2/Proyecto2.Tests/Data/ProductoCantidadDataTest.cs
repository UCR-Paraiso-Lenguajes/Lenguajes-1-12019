using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Data
{
    public class ProductoCantidadDataTest
    {
        [SetUp]
        public void Setup()
        {
        }
        //[Test]
        public void listarProductoCantidad()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoCantidadData productoCantidad = new ProductoCantidadData(sqlconnect);

            IEnumerable<ProductoCantidad> lista = productoCantidad.ObtenerProductoCantidad(1);

            Assert.NotNull(lista);

        }

        [Test]
        public void InsertarProductoCantidad()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoCantidadData productoCantidad = new ProductoCantidadData(sqlconnect);

            
            Producto producto = new Producto(80000, 4, 5, "LG", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            ProductoCantidad pcNuevo = new ProductoCantidad(producto, 2);

            productoCantidad.InsertarProductoCantidad(pcNuevo);

        }

        [Test]
        public void ActualizarProductoCantidad()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoCantidadData productoCantidad = new ProductoCantidadData(sqlconnect);


            Producto producto = new Producto(45000, 3, 4, "Alcatel", "Celular", 15, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            ProductoCantidad pcActualizar = new ProductoCantidad(producto, 5);

            productoCantidad.Actualiza(pcActualizar);

        }

        [Test]
        public void BorrarProductoCantidad()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            ProductoCantidadData productoCantidad = new ProductoCantidadData(sqlconnect);


            Producto producto = new Producto(45000, 3, 4, "Alcatel", "Celular", 15, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            ProductoCantidad pcActualizar = new ProductoCantidad(producto, 5);

            productoCantidad.BorrarProductoCantidad(3);

        }
    }
}
