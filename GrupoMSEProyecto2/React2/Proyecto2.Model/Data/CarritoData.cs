using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{

    
    public class CarritoData
    {
        private string connectionString;

        string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public CarritoData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Carrito> ObtenerCarritoPorUsuario(int idComprador,String email)
        {
            List<Carrito> carrito = new List<Carrito>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select c.id, u.id, u.nombre, u.passwordComprador, u.emailPrincipal, "+
"p.id, p.impuesto, p.nombre, p.descripcion, p.precio, p.cantidadDisponible from Carrito c inner join Comprador u on c.idUser = u.id "+
"inner join CarritoProducto cp on cp.idCarrito = c.id inner join Producto p on cp.idProducto = p.id where u.emailPrincipal = "+email;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            string id = reader.GetString(0);
                            int idUser = reader.GetInt32(1);

                            //Carrito(string id, Usuario usuario, decimal subtotal, int total, List < ProductoCantidad > productoCantidad)
                            //ProductoCantidad(Producto producto, int cantidad, float compraTotalProducto)
                            //carrito.Add(new Carrito(id_publicador, nombre_publicador, url_sitio_web));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return carrito;
        }

        public void InsertarCarrito(Carrito carrito)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "insert into Carrito(idProducto,cantidadProducto) values(@idProducto,@cantidadProducto)";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.Add(new SqlParameter("@idProducto", idProducto));
                    command.Parameters.Add(new SqlParameter("@cantidadProducto", cantidadProducto));
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
;
        }


        public void Actualiza(Carrito carrito)
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = @"UPDATE Carrito SET 
                          cantidadProducto = @CantidadProducto
                    WHERE idProducto = " + idProducto;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("idProducto", idProducto);
                    command.Parameters.AddWithValue("cantidadProducto", cantidadProducto);
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
        }


        public void BorrarCarrito(int Id)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = @"DELETE FROM Carrito 
                   WHERE idProducto = @Id";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.AddWithValue("Id", Id);
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
        }
    }
    
}
