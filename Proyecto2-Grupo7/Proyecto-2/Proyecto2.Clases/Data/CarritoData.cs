using System;
using System.Collections.Generic;
using System.Text;
using Proyecto2.Clases.Domain;
using Proyecto2.Clases.Data;
using System.Data;
using System.Data.SqlClient;

namespace Proyecto2.Clases.Data
{
    public class CarritoData
    {
        public Carrito getCarritobyid(int idCarrito)
        {
            Carrito carrito = new Carrito();
            int compradorId = 0;
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select id_comprador from Carrito where id_carrito="+idCarrito;
               
                using (SqlCommand command = new SqlCommand(sql, connection))
                {

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                         carrito.Id=idCarrito.ToString();
                          compradorId = reader.GetInt32(0);



                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            carrito.Comprador = ListCompradorbyid(compradorId.ToString());
            carrito.ProductoCantidad = ListProductCantidadbyCarrito(idCarrito.ToString());
            return carrito;
        }
        public Comprador ListCompradorbyid(string idComprador)
        {
            Comprador comprador = new Comprador();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
              

                using (SqlCommand command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandType = CommandType.Text;
                    command.CommandText = "select nombre, password, email_principal from Comprador where id_comprador = @id_comprador";
                    command.Parameters.AddWithValue("@id_comprador", idComprador);

                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            comprador.Id =idComprador;
                            comprador.Nombre = reader.GetString(0);
                            comprador.Password= reader.GetString(1);
                            comprador.EmailPrincipal = reader.GetString(2);


                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return comprador ;
        }
      
        public List<ProductoCantidad> ListProductCantidadbyCarrito(String idCarrito)
        {
            List<ProductoCantidad> productosCantidad = new List<ProductoCantidad>();
            ProductoData productoData = new ProductoData();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select id_producto, cantidad  from ProductoCantidad where id_carrito="+idCarrito;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {


                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                           int  id = reader.GetInt32(0);
                           int cantidad = reader.GetInt32(1);

                            ProductoCantidad productoCantidad = new ProductoCantidad(productoData.ListProductsbyid(id.ToString()),cantidad);

                            productosCantidad.Add(productoCantidad);

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return productosCantidad;
        }

        public List<Carrito> listarCarritos()
        {
            List<Carrito> carritos = new List<Carrito>();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select id_carrito, id_comprador from Carrito";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {


                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id_carrito = reader.GetInt32(0);
                            int id_comprador = reader.GetInt32(1);


                            Comprador comprador= ListCompradorbyid(id_comprador.ToString());
                            List<ProductoCantidad> productos = ListProductCantidadbyCarrito(id_carrito.ToString());
                            carritos.Add(new Carrito(productos, id_carrito.ToString(), comprador));

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return carritos;
        }


        public void InsertarCarrito(Carrito carrito)
        {

            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                using (SqlCommand command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandType = CommandType.Text;
                    command.CommandText = "INSERT into Carrito (id_comprador) VALUES (@id_comprador)";
                    command.Parameters.AddWithValue("@id_comprador", carrito.Comprador.Id);
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
        public void InsertarProductoCantidad(ProductoCantidad productoCantidad, string idCarrito)
        {

            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                using (SqlCommand command = new SqlCommand())
                {
                    command.Connection = connection;
                    command.CommandType = CommandType.Text;
                    command.CommandText = "INSERT into ProductoCantidad (id_producto, cantidad, id_carrito) VALUES (@id_producto, @cantidad, @id_carrito)";
                    command.Parameters.AddWithValue("@id_producto", productoCantidad.Producto.Id);
                    command.Parameters.AddWithValue("@cantidad", productoCantidad.Cantidad);
                    command.Parameters.AddWithValue("@id_carrito", idCarrito);
                    
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
