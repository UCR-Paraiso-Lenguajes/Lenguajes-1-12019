using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace ProyectoDosGrupoCinco.Data
{
    public class ProductoData
    {
        public IEnumerable<Producto> ListProducts()
        {
            List<Producto> productos = new List<Producto>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id, nombre, impuesto, cantidad_disponible, descripcion from Producto";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            int impuesto = reader.GetInt32(2);
                            int cantidadDisponible = reader.GetInt32(3);
                            string descripcion = reader.GetString(4);

                            productos.Add(new Producto(id, impuesto, nombre, descripcion, cantidadDisponible));

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return productos;
        }

     

        public void InsertarProducto(Producto producto)
        {


            /* using (SqlConnection conn = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
             {
                 conn.Open();

                 string sql = "INSERT INTO Producto (nombre, impuesto, cantidad_disponible, descripcion)" +
                     "VALUES(" + "'"+producto.Nombre+"'" + producto.Impuesto +"\n"+ producto.CantidadDisponible +"'"+producto.Descripcion+"'"+  ");";

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
             }*/


            using (SqlConnection connection = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                String query = "INSERT INTO Producto (nombre, impuesto, cantidad_disponible, descripcion) " +
                   
                    "VALUES (@nombre,@impuesto,@cantidad_disponible, @descripcion)";

                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@nombre", producto.Nombre);
                    command.Parameters.AddWithValue("@impuesto", producto.Impuesto);
                    command.Parameters.AddWithValue("@cantidad_disponible", producto.CantidadDisponible);
                    command.Parameters.AddWithValue("@descripcion", producto.Descripcion);

                    connection.Open();
                    int result = command.ExecuteNonQuery();

                    // Check Error
                    if (result < 0)
                        Console.WriteLine("Error inserting data into Database!");
                }
            }



        }

        public void Delete(int productoId)
        {
            using (SqlConnection conn = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                conn.Open();

                string sql = "delete from Producto where id = " + 4;
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

        public Producto GetProductById(int id)
        {

            Producto producto = new Producto();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id, nombre, impuesto, cantidad_disponible, descripcion from Producto WHERE id = "+id;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int idProducto = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            int impuesto = reader.GetInt32(2);
                            int cantidadDisponible = reader.GetInt32(3);
                            string descripcion = reader.GetString(4);

                            producto = new Producto(id, impuesto, nombre, descripcion, cantidadDisponible);

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return producto;
        }
        public void actualizarProducto(int id, Producto producto)
        {

            using (SqlConnection conn = new SqlConnection("data source=" +
           "163.178.173.148;initial " +
           "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
           "multipleactiveresultsets=True"))
            {
                conn.Open();

                string sql = "UPDATE Producto SET nombre = " + "'" + producto.Nombre + "'"                     
                    + ", impuesto = "+"'"+ producto.Impuesto +"'"+
                    ", cantidad_disponible = "+"'"+ producto.CantidadDisponible+"'"
                  + ", descripcion = "+ "'"+producto.Descripcion+"'" + "WHERE id = "+ id;


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
