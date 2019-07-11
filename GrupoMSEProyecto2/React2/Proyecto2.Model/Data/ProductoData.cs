using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{
    public class ProductoData
    {
        private string connectionString;

        string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public ProductoData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Producto> ObtenerProducto(int idProducto)
        {
            List<Producto> producto = new List<Producto>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select p.id, p.impuesto, p.nombre, p.descripcion, p.precio, p.cantidadDisponible, p.imagen from Producto p where p.id = " + idProducto;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            Double impuesto = Convert.ToDouble(reader.GetDecimal(1)) / 100;
                            string nombre = reader.GetString(2);
                            string descripcion = reader.GetString(3);
                            Double precio = (Double)reader.GetDouble(4);
                            int cantidadDis = reader.GetInt32(5);
                            string imagen = reader.GetString(6);

                            producto.Add(new Producto((float)precio, id, impuesto, nombre, descripcion, cantidadDis, imagen));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return producto;
        }

        public IEnumerable<Producto> ObtenerRango(int indice)
        {
            List<Producto> producto = new List<Producto>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select p.id, p.impuesto, p.nombre, p.descripcion, p.precio, p.cantidadDisponible, p.imagen from Producto p where p.id between "+indice+" and "+(indice+49);
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            Double impuesto = Convert.ToDouble(reader.GetDecimal(1)) / 100;
                            string nombre = reader.GetString(2);
                            string descripcion = reader.GetString(3);
                            Double precio = (Double)reader.GetDouble(4);
                            int cantidadDis = reader.GetInt32(5);
                            string imagen = reader.GetString(6);

                            producto.Add(new Producto((float)precio, id, impuesto, nombre, descripcion, cantidadDis, imagen));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return producto;
        }



        public void InsertarProducto(Producto producto)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "insert into Producto(id, impuesto, nombre, descripcion, precio, cantidadDisponible, imagen) values(@id, @impuesto, @nombre, @descripcion, @precio, @cantidadDisponible, @imagen)";
                string sqlBodega = "insert into Bodega(idProducto, cantidadProducto) values (@idProducto,@cantidadProducto)";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.Add(new SqlParameter("@id", producto.IdProducto));
                    command.Parameters.Add(new SqlParameter("@impuesto", producto.Impuesto));
                    command.Parameters.Add(new SqlParameter("@nombre", producto.Nombre));
                    command.Parameters.Add(new SqlParameter("@descripcion", producto.Descripcion));
                    command.Parameters.Add(new SqlParameter("@precio", producto.PrecioUnitario));
                    command.Parameters.Add(new SqlParameter("@cantidadDisponible", producto.CantidadDisponible));
                    command.Parameters.Add(new SqlParameter("@imagen", producto.Imagen));
                    SqlCommand commandBodega = new SqlCommand(sqlBodega, connection);
                    commandBodega.Parameters.Add(new SqlParameter("@idProducto", producto.IdProducto));
                    commandBodega.Parameters.Add(new SqlParameter("@cantidadProducto", producto.CantidadDisponible));
                    command.ExecuteNonQuery();
                    commandBodega.ExecuteNonQuery();
                }
                connection.Close();
            }
;
        }


        public void Actualiza(Producto producto)
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {

                connection.Open();
                string sqlProducto = "update Producto set impuesto=@impuesto, nombre=@nombre,descripcion=@descripcion,precio=@precio,cantidadDisponible=@cantidadDisponible, imagen=@imagen where id= " + producto.IdProducto;
                string sqlBodega = "update Bodega set cantidadProducto = @cantidadProducto where idProducto = " + producto.IdProducto;
                using (SqlCommand command = new SqlCommand(sqlProducto, connection))
                {
                    command.Parameters.AddWithValue("impuesto", producto.Impuesto);
                    command.Parameters.AddWithValue("nombre", producto.Nombre);
                    command.Parameters.AddWithValue("descripcion", producto.Descripcion);
                    command.Parameters.AddWithValue("precio", producto.PrecioUnitario);
                    command.Parameters.AddWithValue("cantidadDisponible", producto.CantidadDisponible);
                    command.Parameters.AddWithValue("imagen", producto.Imagen);

                    SqlCommand commandBodega = new SqlCommand(sqlBodega, connection);
                    commandBodega.Parameters.AddWithValue("cantidadProducto", producto.CantidadDisponible);
                    command.ExecuteNonQuery();
                    commandBodega.ExecuteNonQuery();
                }
                connection.Close();
            }
        }


        public void BorrarProducto(int Id)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sqlBodega = "delete Bodega where idProducto = " + Id;
                string sqlProducto = "delete Producto where id = " + Id;
                using (SqlCommand command = new SqlCommand(sqlBodega, connection))
                {
                    SqlCommand commandProducto = new SqlCommand(sqlProducto, connection);
                    command.ExecuteNonQuery();
                    commandProducto.ExecuteNonQuery();
                }
                connection.Close();
            }
        }
    }
}
