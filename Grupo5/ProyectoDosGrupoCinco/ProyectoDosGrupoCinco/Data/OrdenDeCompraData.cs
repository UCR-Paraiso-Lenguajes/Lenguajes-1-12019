using MailKit.Net.Smtp;
using MimeKit;
using MimeKit.Utils;
using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace ProyectoDosGrupoCinco.Data
{
  public class OrdenDeCompraData
    {

        public void ComprarCarrito()
        {
            


        }


        public void ResumenCompra(string correoEnviar, string cuerpoMensaje)
        {
            var message = new MimeMessage();
            message.From.Add(new MailboxAddress("Resumen de compra", correoEnviar));
            message.To.Add(new MailboxAddress("cliente", correoEnviar));
            message.Subject = "Resumen de compra";

            var bodyBuilder = new BodyBuilder();
            var bodyBuilder2 = new BodyBuilder();


            var image = bodyBuilder.LinkedResources.Add(@"../ProyectoDosGrupoCinco/logoProyectoDos.png");
            image.ContentId = MimeUtils.GenerateMessageId();


            bodyBuilder.HtmlBody = string.Format(@"<div style=""{0}""><center><img src=""cid:{1}""></center></div> <br><div style =""{2}"" ><strong><h1>A continuación podrás ver el resumen de tú compra</h1></strong>{3}</div>", "background-color:cadetblue; width:900px;heigth:100px", image.ContentId, "color:#229954", cuerpoMensaje);



            message.Body = bodyBuilder.ToMessageBody();


            using (var client = new SmtpClient())

            {
                client.Connect("smtp.gmail.com", 587, false);
                client.Authenticate("chatproyectouno@gmail.com", "2019AEC.");
                client.Send(message);
                client.Disconnect(true);
            }
        }

        public List<ProductoCarrito> ListProductosDeCarrito()
        {
            List<ProductoCarrito> productos = new List<ProductoCarrito>();

            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                /*Select id_carrito,id_producto
from Producto_Carrito
JOIN Producto
ON (Producto_Carrito.id_producto = Producto.id)
where Producto_Carrito.id_carrito=1
*/
                connection.Open();
                string sql = "select id_carrito, id_producto from Producto_Carrito JOIN Producto ON (Producto_Carrito.id_producto=Producto.id)" +
                    "WHERE Producto_Carrito.id_carrito=1";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            decimal impuesto = reader.GetDecimal(2);
                            int cantidadDisponible = reader.GetInt32(3);
                            string descripcion = reader.GetString(4);
                            string rutaImagen = reader.GetString(5);
                            int precio = reader.GetInt32(6);
                            int idCarrito = reader.GetInt32(7);

                            productos.Add(new ProductoCarrito());

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return productos;
        }

    }
}
