using ProyectoDosGrupoCinco.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace ProyectoDosGrupoCinco.Data
{
    public class ProductoData
    {
        public List<Producto> ListProducts()
        {
            List<Producto> productos = new List<Producto>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id, nombre, impuesto, cantidad_disponible, descripcion,ruta_imagen, precio from Producto";
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
                           

                            productos.Add(new Producto(id, impuesto, nombre, descripcion, cantidadDisponible, precio, rutaImagen));

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

            using (SqlConnection connection = new SqlConnection("data source=" +
                 "163.178.173.148;initial " +
                 "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                 "multipleactiveresultsets=True"))
            {
                String query = "INSERT INTO Producto (nombre, impuesto, cantidad_disponible, descripcion, ruta_imagen, precio ) " +

                    "VALUES (@nombre,@impuesto,@cantidad_disponible, @descripcion,@ruta_imagen, @precio  )";

                using (SqlCommand command = new SqlCommand(query, connection))
                {
                    command.Parameters.AddWithValue("@nombre", producto.Nombre);
                    command.Parameters.AddWithValue("@impuesto", producto.Impuesto);
                    command.Parameters.AddWithValue("@cantidad_disponible", producto.CantidadDisponible);
                    command.Parameters.AddWithValue("@descripcion", producto.Descripcion);
                    command.Parameters.AddWithValue("@precio", producto.Precio);
                    command.Parameters.AddWithValue("@ruta_imagen", producto.Imagen);



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

                string sql = "delete from Producto where id = " + productoId;
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
                string sql = "select id, nombre, impuesto, cantidad_disponible, descripcion,ruta_imagen, precio from Producto WHERE id = "+id;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int idProducto = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            decimal impuesto = reader.GetDecimal(2);
                            int cantidadDisponible = reader.GetInt32(3);
                            string descripcion = reader.GetString(4);
                            string rutaImagen = reader.GetString(5);
                            int precio = reader.GetInt32(6);
                            producto = new Producto(id, impuesto, nombre, descripcion, cantidadDisponible, precio, " ");

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
                  + ", descripcion = "+ "'"+producto.Descripcion+"'" + ", precio = " + "'"+ producto.Precio+"'" + ", ruta_imagen= " +"'" +producto.Imagen+"'"
                  + "WHERE id = "+ id;


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


        public void actualizarCantidad(int id,int cantidad)
        {

            using (SqlConnection conn = new SqlConnection("data source=" +
           "163.178.173.148;initial " +
           "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
           "multipleactiveresultsets=True"))
            {
                conn.Open();

                string sql = "UPDATE Producto SET cantidad_disponible = " + "'" + cantidad + "'"
                                 + "WHERE id = " + id;


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

        public List<Producto> BuscarPorDescripcion(string descripcionBuscar)
        {
            List<Producto> productos = new List<Producto>();
            using (SqlConnection connection = new SqlConnection("data source=" +
                "163.178.173.148;initial " +
                "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
                "multipleactiveresultsets=True"))
            {
                connection.Open();
                string sql = "select id, nombre, impuesto, cantidad_disponible, descripcion, precio from Producto WHERE descripcion LIKE '%" + descripcionBuscar+"%'" ;
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
                            string rutaImagen = reader.GetString(5);
                            int precio = reader.GetInt32(6);
                            productos.Add(new Producto(idProducto, impuesto, nombre, descripcion, cantidadDisponible, precio, rutaImagen));

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
