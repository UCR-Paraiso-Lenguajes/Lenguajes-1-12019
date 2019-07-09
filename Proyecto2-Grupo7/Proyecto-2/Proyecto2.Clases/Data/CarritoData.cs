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
        public Carrito getCarritobyid(string idCarrito)
        {
            Carrito carrito = new Carrito(); 
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
                         carrito.Id=idCarrito;
                         carrito.Comprador = ListCompradorbyid(reader.GetString(0));



                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }
            carrito.ProductoCantidad = ListProductCantidadbyCarrito(idCarrito);
            return carrito;
        }
        private Comprador ListCompradorbyid(string idComprador)
        {
            Comprador comprador = new Comprador();
            using (SqlConnection connection = new SqlConnection("Server=163.178.173.148;" + "DataBase=group7_DB;" +
           "User id=estudiantesrp;Password=estudiantesrp"))
            {
                connection.Open();
                string sql = "select nombre,password,email_principal from Comprador where id_comprador=" + idComprador;

                using (SqlCommand command = new SqlCommand(sql, connection))
                {


                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            comprador.Id = idComprador;
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
      
        private List<ProductoCantidad> ListProductCantidadbyCarrito(String idCarrito)
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
                            String id = reader.GetString(0);
                            int cantidad = reader.GetInt32(1);

                            ProductoCantidad productoCantidad = new ProductoCantidad(productoData.ListProductsbyid(id),cantidad);

                            productosCantidad.Add(productoCantidad);

                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return productosCantidad;
        }

    }
}
