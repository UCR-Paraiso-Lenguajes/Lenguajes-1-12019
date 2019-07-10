using Proyecto2.Model.Domain;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Text;

namespace Proyecto2.Model.Data
{
    public class BodegaData
    {
        private string connectionString;

        string sqlconnect = "data source = " +
                "163.178.173.148;initial " +
                "catalog=IF4101_2019_PROYECTO2;user id=estudiantesrp;password=estudiantesrp;" +
                "multipleactiveresultsets=True";

        public BodegaData(string connectiostring)
        {
            this.connectionString = connectiostring;
        }

        public IEnumerable<Bodega> ObtenerBodega()
        {
            List<Bodega> bodega = new List<Bodega>();
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "select idProducto, cantidadProducto from Bodega";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    using (SqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            int id = reader.GetInt32(0);
                            int cantidad = reader.GetInt32(1);
                            bodega.Add(new Bodega(id,cantidad));
                        }
                        reader.Close();
                    };
                }
                connection.Close();
            }

            return bodega;
        }

        public void InsertarBodega( int idProducto, int cantidadProducto)
        {
            
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = "insert into Bodega(idProducto,cantidadProducto) values(@idProducto,@cantidadProducto)";
                using (SqlCommand command = new SqlCommand(sql, connection))
                {
                    command.Parameters.Add(new SqlParameter("@idProducto",idProducto));
                    command.Parameters.Add(new SqlParameter("@cantidadProducto", cantidadProducto));
                    command.ExecuteNonQuery();
                }
                connection.Close();
            }
;
        }


        public void Actualiza(int idProducto, int cantidadProducto)
        {
            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = @"UPDATE Bodega SET 
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


        public void BorrarBodega(int Id)
        {

            using (SqlConnection connection = new SqlConnection(connectionString))
            {
                connection.Open();
                string sql = @"DELETE FROM Bodega 
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
