using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Data
{
    public class BodegaDataTest
    {
        [SetUp]
        public void Setup()
        {
        }
        [Test]
        public void insertarBodega()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            BodegaData bodega = new BodegaData(sqlconnect);

            Producto producto = new Producto(100000, 3, 8, "Alcatel", "Celular pk", 25, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            bodega.Actualiza(producto,20);

            IEnumerable<Bodega> lista = bodega.ObtenerBodega();
            Assert.NotNull(lista);
        }
    }
}
