using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using Proyecto2.Model.Data;
using Proyecto2.Model.Domain;

namespace Proyecto2.Tests.Data
{
    public class PedidoDataTest
    {
        [SetUp]
        public void Setup()
        {
        }
        [Test]
        public void ListaPedido()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            PedidoData pedidoData = new PedidoData();



            Pedido pedido = pedidoData.ObtenerPedido(1);

            if (pedido is PedidoEntregado)
                Assert.AreEqual(1,pedido.Id);

        }

        [Test]
        public void ListaPedidoIndice()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            PedidoData pedidoData = new PedidoData();



            IEnumerable<Pedido> lista = pedidoData.ObtenerPedidoRango(1);

            Assert.NotNull(lista);
        }


        [Test]
        public void InsertarPedidoEntregado()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            PedidoData pedidoData = new PedidoData();

            List<ProductoCantidad> listaProducto = new List<ProductoCantidad>();
            Producto producto = new Producto(80000, 4, 5, "LG", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            Producto producto2 = new Producto(80000, 2, 5, "Huawei", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            ProductoCantidad productoCantidad = new ProductoCantidad(producto, 2);
            ProductoCantidad productoCantidad2 = new ProductoCantidad(producto2, 2);
            listaProducto.Add(productoCantidad);
            listaProducto.Add(productoCantidad2);
            
            OrdenDeCompra orden = new OrdenDeCompra(listaProducto);
            PedidoEntregado pedido = new PedidoEntregado(59,"manfredgh@gmail,com","Alvarado,Cartago",orden, DateTime.Now, orden.TotalCompra, orden.ProductosCantidad.Count);

            Assert.AreEqual(59, pedido.Id);
            Assert.AreEqual("manfredgh@gmail,com", pedido.Email);
            Assert.AreEqual("Alvarado,Cartago", pedido.Direccion);
            Assert.AreEqual(2, pedido.TotalProductosEntregados);
   


            pedidoData.InsertarPedido(pedido);
            pedidoData.BorrarPedido(pedido.Id);

        }

        
        [Test]
        public void InsertarPedidoDespachar()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            PedidoData pedidoData = new PedidoData();

            List<ProductoCantidad> listaProducto = new List<ProductoCantidad>();
            Producto producto = new Producto(80000, 4, 5, "LG", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            Producto producto2 = new Producto(80000, 2, 5, "Huawei", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            ProductoCantidad productoCantidad = new ProductoCantidad(producto, 2);
            ProductoCantidad productoCantidad2 = new ProductoCantidad(producto2, 2);
            listaProducto.Add(productoCantidad);
            listaProducto.Add(productoCantidad2);

            OrdenDeCompra orden = new OrdenDeCompra(listaProducto);

            DateTime fecha = DateTime.Parse("10-05-2019");
            PedidoDespachado despachado = new PedidoDespachado(5, "samistile@gmail.com", "Cervantes,Paraiso", orden, fecha, orden.TotalCompra);

            Assert.AreEqual(5, despachado.Id);
            Assert.AreEqual("samistile@gmail.com", despachado.Email);
            Assert.AreEqual("Cervantes,Paraiso", despachado.Direccion);
            Assert.AreEqual(336000, despachado.TotalCompra);



            pedidoData.InsertarPedido(despachado);

        }

        [Test]
        public void CambiarEstado()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            PedidoData pedidoData = new PedidoData();

            List<ProductoCantidad> listaProducto = new List<ProductoCantidad>();
            Producto producto = new Producto(80000, 4, 5, "LG", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            Producto producto2 = new Producto(80000, 2, 5, "Huawei", "Celular", 10, "https://www.alcatelmobile.com/media/catalog/product/cache/image/1100x1100/e9c3970ab036de70892d86c6d221abfe/a/l/alcatel_1x_front_pebble_blue_with_ui__3.png");
            ProductoCantidad productoCantidad = new ProductoCantidad(producto, 2);
            ProductoCantidad productoCantidad2 = new ProductoCantidad(producto2, 2);
            listaProducto.Add(productoCantidad);
            listaProducto.Add(productoCantidad2);

            OrdenDeCompra orden = new OrdenDeCompra(listaProducto);

            DateTime fecha = DateTime.Parse("10-05-2019");
            PedidoDespachado despachado = new PedidoDespachado(3, "samistile@gmail.com", "Cervantes,Paraiso", orden, fecha, orden.TotalCompra);

            Assert.AreEqual(3, despachado.Id);
            Assert.AreEqual("samistile@gmail.com", despachado.Email);
            Assert.AreEqual("Cervantes,Paraiso", despachado.Direccion);
            Assert.AreEqual(336000, despachado.TotalCompra);


            pedidoData.ActualizaEstado(despachado);

        }

        [Test]
        public void BorrarPedido()
        {

            string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";
            PedidoData pedidoData = new PedidoData();

            pedidoData.BorrarPedido(5);

        }
    }
}
