using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{
    public class ProductoCantidadData
    {
        private string connectionString;

        string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public ProductoCantidadData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<ProductoCantidad> ObtenerProductoCantidad(int idProducto)
        {
            List<ProductoCantidad> productoCantidad = new List<ProductoCantidad>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select p.id, p.impuesto, p.nombre, p.descripcion, p.precio, p.cantidadDisponible, p.imagen, b.cantidadProducto from Producto p join Bodega b on p.id = b.idProducto where p.id = "+idProducto;
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            Decimal impuesto = reader.GetDecimal(1);
                            string nombre = reader.GetString(2);
                            string descripcion = reader.GetString(3);
                            Double precio = (Double)reader.GetDouble(4);
                            int cantidadDis = reader.GetInt32(5);
                            string imagen = reader.GetString(6);
                            int cantidadProducto = reader.GetInt32(7);

                            productoCantidad.Add(new ProductoCantidad(new Producto((float)precio,id,(double)impuesto,nombre,descripcion,cantidadDis,imagen),cantidadProducto));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return productoCantidad;
        }


        
        public void InsertarProductoCantidad(ProductoCantidad productoCantidad)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "insert into Producto(id, impuesto, nombre, descripcion, precio, cantidadDisponible, imagen) values(@id, @impuesto, @nombre, @descripcion, @precio, @cantidadDisponible, @imagen)";
                string sqlBodega = "insert into Bodega(idProducto, cantidadProducto) values (@idProducto,@cantidadProducto)";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.Add(new SqlParameter("@id", productoCantidad.Producto.IdProducto));
                    command.Parameters.Add(new SqlParameter("@impuesto", productoCantidad.Producto.Impuesto));
                    command.Parameters.Add(new SqlParameter("@nombre", productoCantidad.Producto.Nombre));
                    command.Parameters.Add(new SqlParameter("@descripcion", productoCantidad.Producto.Descripcion));
                    command.Parameters.Add(new SqlParameter("@precio", productoCantidad.Producto.PrecioUnitario));
                    command.Parameters.Add(new SqlParameter("@cantidadDisponible", productoCantidad.Producto.CantidadDisponible));
                    command.Parameters.Add(new SqlParameter("@imagen", productoCantidad.Producto.Imagen));
                    SqlCommand commandBodega = new SqlCommand(sqlBodega,connection);
                    commandBodega.Parameters.Add(new SqlParameter("@idProducto", productoCantidad.Producto.IdProducto));
                    commandBodega.Parameters.Add(new SqlParameter("@cantidadProducto", productoCantidad.Cantidad));
                    command.ExecuteNonQuery();
                    commandBodega.ExecuteNonQuery();
                }
                connection.Close();
            }
;
        }


        public void Actualiza(ProductoCantidad productoCantidad)
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                
                connection.Open();
                string sqlProducto = "update Producto set impuesto=@impuesto, nombre=@nombre,descripcion=@descripcion,precio=@precio,cantidadDisponible=@cantidadDisponible, imagen=@imagen where id= "+productoCantidad.Producto.IdProducto;
                string sqlBodega = "update Bodega set cantidadProducto = @cantidadProducto where idProducto = "+productoCantidad.Producto.IdProducto;
                using (SqlCommand command = new SqlCommand(sqlProducto, connection))
                {
                    command.Parameters.AddWithValue("impuesto", productoCantidad.Producto.Impuesto);
                    command.Parameters.AddWithValue("nombre", productoCantidad.Producto.Nombre);
                    command.Parameters.AddWithValue("descripcion", productoCantidad.Producto.Descripcion);
                    command.Parameters.AddWithValue("precio", productoCantidad.Producto.PrecioUnitario);
                    command.Parameters.AddWithValue("cantidadDisponible", productoCantidad.Producto.CantidadDisponible);
                    command.Parameters.AddWithValue("imagen", productoCantidad.Producto.Imagen);

                    SqlCommand commandBodega = new SqlCommand(sqlBodega, connection);
                    commandBodega.Parameters.AddWithValue("cantidadProducto", productoCantidad.Cantidad);
                    command.ExecuteNonQuery();
                    commandBodega.ExecuteNonQuery();
                }
                connection.Close();
            }
        }


        public void BorrarProductoCantidad(int Id)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();

                //delete Bodega where idProducto=3
                //delete Producto where id = 3
                string sqlBodega = "delete Bodega where idProducto = "+Id;
                string sqlProducto = "delete Producto where id = "+Id;
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
