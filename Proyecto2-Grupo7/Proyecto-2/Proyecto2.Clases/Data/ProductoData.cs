using Proyecto2.Clases.Domain;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Common;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto2.Clases.Data
{
    public class ProductoData
    {
        public ProductoData()
        {
        }


        public IEnumerable<Producto> ListProducts()
        {
            List<Producto> productos = new List<Producto>();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select id_producto, url_image, nombre, cantidad_disponible,impuesto,descripcion  from Producto";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {


                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            string nombre = reader.GetString(1);
                            string url_image = reader.GetString(2);
                            int cantidadDisponible = reader.GetInt32(3);
                            decimal impuesto = reader.GetDecimal(4);
                            string descripcion = reader.GetString(5);



                            productos.Add(new Producto(id.ToString(), impuesto, url_image, nombre, descripcion, cantidadDisponible));

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return productos;
        }

        public void Insertar(Producto producto)
        {

            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                using (SqlCommand command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandType = CommandType.Text;
                    command.CommandText = "INSERT into Producto (impuesto, url_image, nombre, descripcion, cantidad_disponible) VALUES (@impuesto, @url_image, @nombre, @descripcion, @cantidad_disponible )";
                    command.Parameters.AddWithValue("@impuesto", producto.Impuesto);
                    command.Parameters.AddWithValue("@url_image", producto.Url_image);
                    command.Parameters.AddWithValue("@nombre", producto.Nombre);
                    command.Parameters.AddWithValue("@descripcion", producto.Descripcion);
                    command.Parameters.AddWithValue("@cantidad_disponible", producto.CantidadDisponible);
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
        public void Actualizar(Producto producto)
        {

            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                using (SqlCommand command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandType = CommandType.Text;
                    command.CommandText = "UPDATE Producto set impuesto=@impuesto, url_image= @url_image, nombre=@nombre, descripcion=@descripcion, cantidad_disponible=@cantidad_disponible where id_producto=@id";
                    command.Parameters.AddWithValue("@id", producto.Id);
                    command.Parameters.AddWithValue("@impuesto", producto.Impuesto);
                    command.Parameters.AddWithValue("@url_image", producto.Url_image);
                    command.Parameters.AddWithValue("@nombre", producto.Nombre);
                    command.Parameters.AddWithValue("@descripcion", producto.Descripcion);
                    command.Parameters.AddWithValue("@cantidad_disponible", producto.CantidadDisponible);
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

    }
}