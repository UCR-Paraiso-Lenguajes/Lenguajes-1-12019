using Proyecto2.Clases.Domain;
using System;
using System.Collections.Generic;
using System.Text;
using System.Data.SqlClient;
using System.Data;

namespace Proyecto2.Clases.Data
{
    class PedidoData
    {

        CarritoData carritoData = new CarritoData();
        public PedidoData()
        {
        }

        public void Insertar(Pedido pedido)
        {

            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                using (SqlCommand command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandType = CommandType.Text;
                    command.CommandText = "INSERT into Pedido (id_carrito, email, direccion) VALUES (@id_carrito, @email, @direccion)";
                    command.Parameters.AddWithValue("@id_carrito", pedido.OrdenDeCompra.Id);
                    command.Parameters.AddWithValue("@email", pedido.Email);
                    command.Parameters.AddWithValue("@direccion", pedido.Direccion);
                    try
                    {
                        connection.Open();
                        int recordsAffected = command.ExecuteNonQuery();
                    }
                    catch (SqlException)
                    {
                        // error here
                    }
                    finally
                    {
                        connection.Close();
                    }
                }
            }
        }



        public List<Pedido> ListaPedido()
        {
            List<Pedido> pedidos = new List<Pedido>();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select id_pedido, id_carrito, email, direccion from Pedido";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {


                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id_pedido = reader.GetInt32(0);
                            int id_carrito = reader.GetInt32(0);
                            string email = reader.GetString(1);
                            string direccion = reader.GetString(2);


                            List<ProductoCantidad> productoCantidads = carritoData.ListProductCantidadbyCarrito(id_carrito.ToString());

                            pedidos.Add(new Pedido(carritoData.getCarritobyid(id_carrito), id_pedido.ToString(), email, direccion, productoCantidads));
           
             
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            return pedidos;

        }
    }


}
        