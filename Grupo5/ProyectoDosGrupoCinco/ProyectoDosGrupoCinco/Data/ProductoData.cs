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

        public void actualizarProducto(int id, Producto productoActualizar)
        {
            throw new NotImplementedException();
        }

        public void InsertarProducto(Producto producto)
        {


            using (SqlConnection conn = new SqlConnection("data source=" +
               "163.178.173.148;initial " +
               "catalog=ProyectoDosLenguajesGrupo05;user id=lenguajesap;password=lenguajesap;" +
               "multipleactiveresultsets=True"))
            {
                conn.Open();
                /*
                 INSERT INTO Producto (nombre, impuesto, cantidad_disponible, descripcion)
                VALUES ('Zapato', 200, 12, 'zapato talla 40');
                 */
                string sql = "INSERT INTO Producto (nombre, impuesto, cantidad_disponible, descripcion)" +
                    "VALUES(" + producto.Nombre + producto.Impuesto+producto.CantidadDisponible+producto.Descripcion+");";

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

    }
}
