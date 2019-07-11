using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;

namespace ProyectoDosGrupoCinco.Data
{
    public class CarritoData
    {

        public CarritoDisponible CarritoDisponible(int id)
        {
            CarritoDisponible carrito = null;
            using (SqlConnection connection = new SqlConnection("data source=" +
              "163.178.173.148;initial " +
              "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
              "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id_comprador,total,subtotal from Carrito WHERE id =" + id;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            
                            int id_comprador = reader.GetInt32(0);
                            int total = reader.GetInt32(1);
                            int subtotal = reader.GetInt32(2);
                            if (id_comprador <= 0)
                            {
                                carrito = new CarritoDisponible(id, total, subtotal);
                            }
                            else {

                                carrito = new CarritoDisponible(id, id_comprador, total, subtotal);
                            }


                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            if (carrito != null) {
                return carrito;
            }
            else
            {
                return null;
            }

        }

        public void crearCarrito(CarritoDisponible carrito)
        {


            using (SqlConnection connection = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                String query = "INSERT INTO Carrito (id_comprador,total,subtotal) " +

                    "VALUES (@id_comprador,@total, @subtotal)";

                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@id_comprador", carrito.Usuario.IdComprador);
                    command.Parameters.AddWithValue("@total", carrito.Total);
                    command.Parameters.AddWithValue("@subtotal", carrito.SubTotal);

                    connection.Open();
                    int result = command.ExecuteNonQuery();

                    // Check Error
                    if (result < 0)
                        Console.WriteLine("Error inserting data into Database!");
                }
            }



        }

       public void carritoProducto(ProductoCarrito productoCarrito)
        {


            using (SqlConnection connection = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                String query = "INSERT INTO Producto_Carrito (id_carrito,id_producto,cantidad) " +

                    "VALUES (@id_carrito,@id_producto,@cantidad)";

                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@id_carrito", productoCarrito.IdCarrito);
                    command.Parameters.AddWithValue("@id_producto", productoCarrito.IdProducto);
                    command.Parameters.AddWithValue("@cantidad", productoCarrito.Cantidad);

                    connection.Open();
                    int result = command.ExecuteNonQuery();

                    // Check Error
                    if (result < 0)
                        Console.WriteLine("Error inserting data into Database!");
                }
            }



        }


        public void carritoProductoActualizar(ProductoCarrito productoCarrito)
        {


            using (SqlConnection conn = new SqlConnection("data source=" +
           "163.178.173.148;initial " +
           "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
           "multipleactiveresultsets=True"))
            {
                conn.Open();
                string sql = "UPDATE Producto_Carrito SET cantidad="+productoCarrito.Cantidad+" WHERE id_carrito= "+productoCarrito.IdCarrito+" AND id_producto="+productoCarrito.IdProducto+" ";
                


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
}
