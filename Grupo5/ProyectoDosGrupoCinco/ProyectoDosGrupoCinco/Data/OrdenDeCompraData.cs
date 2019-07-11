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
        ProductoData productoData = new ProductoData();
        public void ComprarCarrito(OrdenDeCompra ordenDeCompra)
        {
            string cuerpoMensaje = "";
            int precio = 0;

            cuerpoMensaje = "correo específicado: "+ ordenDeCompra.Email +"<br><br> Dirección a la que se enviará el parquete: <br>"+ ordenDeCompra.Direccion+"<br><br><br>Los productos solicitados son los siguientes:<br><br>   ";

            foreach (ProductoCantidad productosComprar in ordenDeCompra.ProductosCantidad)
            {
                cuerpoMensaje += productosComprar.Producto.Nombre+" precio: "+ productosComprar.Producto.Precio+"<br><br>";
                precio += productosComprar.Producto.Precio;
            }
            cuerpoMensaje+="<br><br><br> Para un total de: " +precio;
            

            var message = new MimeMessage();
            message.From.Add(new MailboxAddress("Resumen de compra", ordenDeCompra.Email));
            message.To.Add(new MailboxAddress("cliente", ordenDeCompra.Email));
            message.Subject = "Resumen de compra";

            var bodyBuilder = new BodyBuilder();
            var bodyBuilder2 = new BodyBuilder();


            var image = bodyBuilder.LinkedResources.Add(@"../ProyectoDosGrupoCinco/logoProyectoDos.png");
            image.ContentId = MimeUtils.GenerateMessageId();


            bodyBuilder.HtmlBody = string.Format(@"<div style=""{0}""><center><img src=""cid:{1}""></center></div> <br><div style =""{2}"" ><strong><h1>A continuación podrás ver el resumen de tú compra</h1></strong></div><div style =""{3}""><strong>{4}</strong></div>", "background-color:cadetblue; width:900px;heigth:100px", image.ContentId, "color:#229954", "color:#5DADE2", cuerpoMensaje);



            message.Body = bodyBuilder.ToMessageBody();


            using (var client = new SmtpClient())

            {
                client.Connect("smtp.gmail.com", 587, false);
                client.Authenticate("chatproyectouno@gmail.com", "2019AEC.");
                client.Send(message);
                client.Disconnect(true);
            }

            InsertOrdenDeCompra(ordenDeCompra);
        }


        public void InsertOrdenDeCompra(OrdenDeCompra ordenDeCompra)
        {
            using (SqlConnection connection = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                String query = "INSERT INTO Pedido (direccion,email) " +

                    "VALUES (@direccion,@email)";

                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@direccion", ordenDeCompra.Direccion);
                    command.Parameters.AddWithValue("@email", ordenDeCompra.Email);


                    connection.Open();
                    int result = command.ExecuteNonQuery();

                    // Check Error
                    if (result < 0)
                        Console.WriteLine("Error inserting data into Database!");
                }

            }


        }

        public List<ProductoCarrito> ListProductosDeCarrito(int idCarrito)
        {
            List<ProductoCarrito> productos = new List<ProductoCarrito>();

            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
               
                connection.Open();
                string sql = "select id_carrito, id_producto from Producto_Carrito JOIN Producto ON (Producto_Carrito.id_producto=Producto.id)" +
                    "WHERE Producto_Carrito.id_carrito="+idCarrito;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int idShoppingCart = reader.GetInt32(0);
                            int idProducto = reader.GetInt32(1);
                            

                            productos.Add(new ProductoCarrito(idShoppingCart, idProducto));

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
