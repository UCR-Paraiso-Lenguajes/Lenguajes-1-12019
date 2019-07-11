using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace ProyectoDosGrupoCinco.Data
{
    public class PedidosData
    {
        public void pedidoDespachado(PedidoPendiente pedido)
        {

            using (SqlConnection conn = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                conn.Open();
                String sql = "delete from Pedido where id= " + pedido.IdPedido+" ";

                using (SqlCommand command = new SqlCommand(sql, conn))
                {

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {

                        }
                        reader.Close();
                    };
                }
                conn.Close();

            }



            using (SqlConnection connection = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                String query = "INSERT INTO PedidoDespachado (direccion,email) " +

                    "VALUES (@direccion,@email)";

                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@direccion", pedido.OrdenDeCompra.Direccion);
                    command.Parameters.AddWithValue("@email", pedido.OrdenDeCompra.Email);


                    connection.Open();
                    int result = command.ExecuteNonQuery();

                    // Check Error
                    if (result < 0)
                        Console.WriteLine("Error inserting data into Database!");
                }

            }




            foreach (ProductoCantidad item in pedido.OrdenDeCompra.ProductosCantidad)
            {

                using (SqlConnection conn = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
                {
                    String sql = "UPDATE Producto SET cantidad_disponible = (Select cantidad_disponible from Producto where id="+item.Producto.IdProducto+")-"+item.Cantidad+" WHERE id = " + item.Producto.IdProducto + " ";

                    using (SqlCommand command = new SqlCommand(sql, conn))
                    {

                        using (SqlDataReader reader = command.ExecuteReader())
                        {
                            while (reader.Read())
                            {

                            }
                            reader.Close();
                        };
                    }
                    conn.Close();

                }




            }




            

        }

        public void pedidoEntregado(PedidoDespachado pedido)
        {

            using (SqlConnection conn = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                conn.Open();
                String sql = "delete from PedidoDespachado where id= " + pedido.IdPedido + " ";

                using (SqlCommand command = new SqlCommand(sql, conn))
                {

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {

                        }
                        reader.Close();
                    };
                }
                conn.Close();

            }



            using (SqlConnection connection = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                String query = "INSERT INTO PedidoEntregado (direccion,email) " +

                    "VALUES (@direccion,@email)";

                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@direccion", pedido.OrdenDeCompra.Direccion);
                    command.Parameters.AddWithValue("@email", pedido.OrdenDeCompra.Email);


                    connection.Open();
                    int result = command.ExecuteNonQuery();

                    // Check Error
                    if (result < 0)
                        Console.WriteLine("Error inserting data into Database!");
                }

            }



        }



        public PedidoPendiente PedidoPorId(int id)
        {

            PedidoPendiente pedido = new PedidoPendiente();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id, direccion, email from Pedido WHERE id = " + id;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int idO = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string email = reader.GetString(2);


                           
                           

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return pedido;
        }
        public List<PedidoPendiente> ListPedidoPendiente()
        {
            List<PedidoPendiente> pedidoPendientes = new List<PedidoPendiente>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id, direccion, email from Pedido";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int idO = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string email = reader.GetString(2);


                            //    pedidoPendientes.Add(new Producto(id, impuesto, nombre, descripcion, cantidadDisponible, precio, rutaImagen));

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return pedidoPendientes;
        }

    }
}
